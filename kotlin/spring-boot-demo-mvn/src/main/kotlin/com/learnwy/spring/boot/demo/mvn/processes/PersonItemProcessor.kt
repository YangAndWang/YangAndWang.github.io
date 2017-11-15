package com.learnwy.spring.boot.demo.mvn.processes

import com.learnwy.spring.boot.demo.mvn.dtos.Person2
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.batch.item.ItemProcessor

class PersonItemProcessor : ItemProcessor<Person2, Person2> {

    @Throws(Exception::class)
    override fun process(person: Person2): Person2 {
        val firstName = person.firstName?.toUpperCase() ?: ""
        val lastName = person.lastName?.toUpperCase() ?: ""

        val transformedPerson2 = Person2(firstName, lastName)

        log.info("Converting ($person) into ($transformedPerson2)")

        return transformedPerson2
    }

    companion object {

        private val log = LoggerFactory.getLogger(PersonItemProcessor::class.java)
    }

}