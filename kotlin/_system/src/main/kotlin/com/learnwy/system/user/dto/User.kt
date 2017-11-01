package com.learnwy.system.user.dto

import com.learnwy.system.commom.SystemConfig
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

const val TABLE_NAME = SystemConfig.PREFIX + SystemConfig.DELIMITER + "user";

@Entity(name = TABLE_NAME)
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
) {
}