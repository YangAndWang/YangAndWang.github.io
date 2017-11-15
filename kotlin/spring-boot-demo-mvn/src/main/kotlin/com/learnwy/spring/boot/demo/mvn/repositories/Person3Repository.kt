package com.learnwy.spring.boot.demo.mvn.repositories
//
//import com.learnwy.spring.boot.demo.mvn.dtos.Person3
//import org.springframework.data.gemfire.repository.query.annotation.Trace
//import org.springframework.data.repository.CrudRepository
//
//interface Person3Repository : CrudRepository<Person3, String> {
//
//    @Trace
//    fun findByName(name: String): Person3
//
//    @Trace
//    fun findByAgeGreaterThan(age: Int): Iterable<Person3>
//
//    @Trace
//    fun findByAgeLessThan(age: Int): Iterable<Person3>
//
//    @Trace
//    fun findByAgeGreaterThanAndAgeLessThan(greaterThanAge: Int, lessThanAge: Int): Iterable<Person3>
//
//}