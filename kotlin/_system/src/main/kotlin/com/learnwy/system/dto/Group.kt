package com.learnwy.system.dto

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

const val TABLE_NAME_GROUP = SystemConfig.PREFIX + SystemConfig.DELIMITER + "group";

@Entity(name = TABLE_NAME_GROUP)
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String = "guest",
        var permissionPath: Long = 7,
        var permissionFile: Long = 6,
        var description: String = "$name's group",


        var createDate: Date,
        var updateDate: Date
) {
}