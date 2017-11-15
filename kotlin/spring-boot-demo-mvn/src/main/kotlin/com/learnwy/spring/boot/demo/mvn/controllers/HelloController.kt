package com.learnwy.spring.boot.demo.mvn.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/hello"))
class HelloController {

    @GetMapping
    fun sayHello(name: String? = null): String {
        return "hello,${name ?: "strager"}"
    }
}