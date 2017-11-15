package com.learnwy.spring.boot.demo.mvn.dtos


import javax.validation.constraints.NotNull

data class Person2(
        var firstName: String? = null,
        var lastName: String? = null
)
