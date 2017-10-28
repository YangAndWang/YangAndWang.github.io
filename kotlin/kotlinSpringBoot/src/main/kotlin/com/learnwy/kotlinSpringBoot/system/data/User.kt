package com.learnwy.kotlinSpringBoot.system.data

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "learnwy_user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0L,

        @Length(min = 6, max = 1024)
        var name: String = "guest",

        var email: String = "example@example.com",

        @Length(max = 16)
        var phone: String = "00000000000",

        @Length(min = 6, max = 1024)
        var password: String = "123456",

        var mainGroupId: Long = 0L,

        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        var createDate: Date = Date(),
        var createUserId: Long = 0L
);