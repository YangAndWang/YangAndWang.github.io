package com.learnwy.spring.boot.demo.mvn.listens

import java.sql.ResultSet
import java.sql.SQLException

import com.learnwy.spring.boot.demo.mvn.dtos.Person2
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component

@Component
class JobCompletionNotificationListener @Autowired
constructor(private val jdbcTemplate: JdbcTemplate) : JobExecutionListenerSupport() {

    override fun afterJob(jobExecution: JobExecution?) {
        if (jobExecution!!.status == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results")

            val results = jdbcTemplate
                    .query("SELECT first_name, last_name FROM people") { rs, row ->
                        Person2(rs.getString(1), rs.getString(2))
                    }

            for (person in results) {
                log.info("Found <$person> in the database.")
            }

        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(JobCompletionNotificationListener::class.java)
    }
}