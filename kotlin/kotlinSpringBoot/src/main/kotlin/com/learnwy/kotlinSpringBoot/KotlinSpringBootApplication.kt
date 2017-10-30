package com.learnwy.kotlinSpringBoot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringBootApplication::class.java, *args);
}
