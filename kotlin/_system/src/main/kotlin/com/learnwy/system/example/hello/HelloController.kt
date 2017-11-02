package com.learnwy.system.example.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/hello"))
class HelloController {

    @GetMapping
    fun hello(@RequestParam(name = "name", defaultValue = "guest") name: String): String {
        return "hello,${name}";
    }
}