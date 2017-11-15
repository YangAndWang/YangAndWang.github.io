package com.learnwy.spring.boot.demo.mvn.dtos


import javax.validation.constraints.NotNull

data class Person(
        var firstName: String,
        var lastName: String,
        @NotNull
        var name: String? = null
)
