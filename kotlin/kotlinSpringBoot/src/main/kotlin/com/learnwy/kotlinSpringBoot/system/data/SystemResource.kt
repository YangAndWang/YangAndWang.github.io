package com.learnwy.kotlinSpringBoot.system.data

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.stereotype.Component
import java.util.*
import javax.persistence.*

@Entity
data class SystemResource(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @Column(columnDefinition = "comment = 'catalog'")
        var type: String = "catalog",



        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        var createDate: Date = Date(),
        var createUserId: Long = 0L
) {
}