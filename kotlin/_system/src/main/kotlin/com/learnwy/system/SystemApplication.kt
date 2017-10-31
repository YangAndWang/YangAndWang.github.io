package com.learnwy.system

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SystemApplication

fun main(args: Array<String>) {
    SpringApplication.run(SystemApplication::class.java, *args)
}
