package com.learnwy.system.po

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.*

const val TABLE_NAME_USER = SystemConfig.PREFIX + SystemConfig.DELIMITER + "user"

@Entity(name = TABLE_NAME_USER)
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @Column(nullable = false, unique = true, length = 256)
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