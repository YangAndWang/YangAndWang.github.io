package com.learnwy.kotlinSpringBoot.system.data

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "learnwy_group")
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0L,

        var name: String = "guest",


        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        var createDate: Date = Date(),
        var createUserId: Long = 0L
) {
}