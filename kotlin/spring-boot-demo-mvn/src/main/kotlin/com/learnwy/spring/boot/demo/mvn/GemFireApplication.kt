package com.learnwy.spring.boot.demo.mvn
//
//import org.apache.geode.cache.GemFireCache;
//import org.apache.geode.cache.client.ClientRegionShortcut;
//import jdk.nashorn.internal.objects.NativeArray.forEach
//import ch.qos.logback.core.joran.spi.ConsoleTarget.findByName
//import com.learnwy.spring.boot.demo.mvn.dtos.Person
//import com.learnwy.spring.boot.demo.mvn.dtos.Person3
//import com.learnwy.spring.boot.demo.mvn.repositories.Person3Repository
//import org.springframework.boot.ApplicationRunner
//import org.springframework.data.gemfire.client.ClientRegionFactoryBean
//import org.springframework.boot.SpringApplication
//import org.springframework.context.annotation.Bean
//import org.springframework.data.gemfire.config.annotation.ClientCacheApplication
//import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories
//import java.io.IOException
//import java.util.Arrays.asList
//import java.util.stream.StreamSupport.stream

//
//@ClientCacheApplication(name = "DataGemFireApplication", logLevel = "error")
//@EnableGemfireRepositories
//class GemFireApplication {
//
//    @Bean("People")
//    fun peopleRegion(gemfireCache: GemFireCache): ClientRegionFactoryBean<String, Person> {
//
//        val peopleRegion = ClientRegionFactoryBean<String, Person>()
//
//        peopleRegion.cache = gemfireCache
//        peopleRegion.setClose(false)
//        peopleRegion.setShortcut(ClientRegionShortcut.LOCAL)
//
//        return peopleRegion
//    }
//
//    @Bean
//    internal fun run(personRepository: Person3Repository): ApplicationRunner {
//        return ApplicationRunner{ args ->
//            val alice = Person3("Alice", 40)
//            val bob = Person3("Baby Bob", 1)
//            val carol = Person3("Teen Carol", 13)
//
//            println("Before accessing data in GemFire...")
//
//            asList(alice, bob, carol).forEach { person -> println("\t" + person) }
//
//            println("Save Alice, Bob and Carol to GemFire...")
//
//            personRepository.save(alice)
//            personRepository.save(bob)
//            personRepository.save(carol)
//
//            println("Lookup each person by name...")
//
//            asList(alice.name, bob.name, carol.name)
//                    .forEach { name -> System.out.println("\t" + personRepository.findByName(name)) }
//
//            println("Query adults (over 18):")
//
//            stream(personRepository.findByAgeGreaterThan(18).spliterator(), false)
//                    .forEach { person -> println("\t" + person) }
//
//            println("Query babies (less than 5):")
//
//            stream(personRepository.findByAgeLessThan(5).spliterator(), false)
//                    .forEach { person -> println("\t" + person) }
//
//            println("Query teens (between 12 and 20):")
//
//            stream(personRepository.findByAgeGreaterThanAndAgeLessThan(12, 20).spliterator(), false)
//                    .forEach { person -> println("\t" + person) }
//        }
//    }
//
//    companion object {
//
//        @Throws(IOException::class)
//        @JvmStatic
//        fun main(args: Array<String>) {
//            SpringApplication.run(GemFireApplication::class.java, *args)
//        }
//    }
//}