package com.learnwy.system.po

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.*

const val TABLE_NAME_GROUP = SystemConfig.PREFIX + SystemConfig.DELIMITER + "group";

@Entity(name = TABLE_NAME_GROUP)
data class Group(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @Column(updatable = false)
        var name: String = "guest",
        var permissionPath: Long = 7,
        var permissionFile: Long = 6,
        var description: String = "$name's group",


        var createDate: Date,
        var updateDate: Date
) {
}