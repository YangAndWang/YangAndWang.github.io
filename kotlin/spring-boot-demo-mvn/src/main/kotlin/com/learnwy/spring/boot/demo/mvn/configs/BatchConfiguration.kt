package com.learnwy.spring.boot.demo.mvn.configs


import javax.sql.DataSource

import com.learnwy.spring.boot.demo.mvn.dtos.Person2
import com.learnwy.spring.boot.demo.mvn.listens.JobCompletionNotificationListener
import com.learnwy.spring.boot.demo.mvn.processes.PersonItemProcessor
import com.zaxxer.hikari.HikariDataSource
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
@EnableBatchProcessing
class BatchConfiguration {

    @Autowired
    var jobBuilderFactory: JobBuilderFactory? = null

    @Autowired
    var stepBuilderFactory: StepBuilderFactory? = null

    @Autowired
    var dataSource: DataSource? = null

    // tag::readerwriterprocessor[]
    @Bean
    fun reader(): FlatFileItemReader<Person2> {
        val reader = FlatFileItemReader<Person2>()
        reader.setResource(ClassPathResource("sample-data.csv"))
        reader.setLineMapper(object : DefaultLineMapper<Person2>() {
            init {
                setLineTokenizer(object : DelimitedLineTokenizer() {
                    init {
                        setNames(*arrayOf("firstName", "lastName"))
                    }
                })
                setFieldSetMapper(object : BeanWrapperFieldSetMapper<Person2>() {
                    init {
                        setTargetType(Person2::class.java)
                    }
                })
            }
        })
        return reader
    }

    @Bean
    fun processor(): PersonItemProcessor {
        return PersonItemProcessor()
    }

    @Bean
    fun writer(): JdbcBatchItemWriter<Person2> {
        val writer = JdbcBatchItemWriter<Person2>()
        writer.setItemSqlParameterSourceProvider(BeanPropertyItemSqlParameterSourceProvider())
        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
        writer.setDataSource(dataSource)
        return writer
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    fun importUserJob(listener: JobCompletionNotificationListener): Job {
        return jobBuilderFactory!!.get("importUserJob")
                .incrementer(RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build()
    }

    @Bean
    fun step1(): Step {
        return stepBuilderFactory!!.get("step1")
                .chunk<Person2, Person2>(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build()
    }
    // end::jobstep[]
}