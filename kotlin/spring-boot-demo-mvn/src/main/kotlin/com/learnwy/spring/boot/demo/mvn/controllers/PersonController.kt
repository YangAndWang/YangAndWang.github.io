package com.learnwy.spring.boot.demo.mvn.controllers

import com.learnwy.spring.boot.demo.mvn.dtos.Person
import org.springframework.boot.context.properties.bind.BindResult
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
@RequestMapping(path = arrayOf("/person"))
@CrossOrigin
class PersonController {
    companion object {
        val persons = mutableListOf<Person>()
    }

    @PostMapping
    @ResponseBody
    fun getPersons(): List<Person> {
        return persons
    }

    @GetMapping(produces = arrayOf("application/json"))
    @ResponseBody
    fun getPerson(
            @RequestParam(name = "name")
            name: String
    ): Person {
        return (persons.find { it -> it.name == name }) ?: throw Exception("no this person")
    }

    @GetMapping()
    fun getTextOrHtmlPerson(): String {
        return "/person/index.html"
    }

    @PutMapping
    @ResponseBody
    fun addPerson(
            @Valid
            person: Person,
            bindingResult: BindingResult
    ): MutableList<Person> {
        if (bindingResult.hasErrors()) {
            throw Exception("name is not null")
        }
        persons.add(person)
        return persons
    }
}