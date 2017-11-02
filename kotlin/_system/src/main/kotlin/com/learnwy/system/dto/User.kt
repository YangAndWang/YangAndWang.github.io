package com.learnwy.system.dto

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

const val TABLE_NAME = SystemConfig.PREFIX + SystemConfig.DELIMITER + "user";

@Entity(name = TABLE_NAME)
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String = "guest",
        var password: String,
        var encryptMethod: String = "MD5",
        var permissionPath: Long = 7,
        var permissionFile: Long = 6,

        var createDate: Date,
        var updateDate: Date,
        var expiredDate: Long,
        var forceUpdate: Boolean,
        var forceUpdateFirst: Boolean,
        var forceUpdateExpiredDate: Boolean

) {
}