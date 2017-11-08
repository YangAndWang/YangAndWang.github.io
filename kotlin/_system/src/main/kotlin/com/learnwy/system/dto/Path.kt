package com.learnwy.system.dto

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.*

const val TABLE_NAME_PATH = SystemConfig.PREFIX + SystemConfig.DELIMITER + "path";

@Entity(name = TABLE_NAME_PATH)
data class Path(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(nullable = false)
        var name: String? = null,
        var description: String? = null,
        @Column(nullable = false)
        var parentPathId: Long? = null,

        @Column(nullable = false)
        /**
         * permission is visit update and grant
         */
        var permissionUser: Long = 7,
        var permissionGroup: Long = 0,
        var permissionOther: Long = 0,
        @Column(nullable = false)
        var createDate: Date = Date(),
        @Column(nullable = false)
        var createUserId: Long = 1,

        var updateDate: Date = Date(),
        var updateUserId: Long = 1,

        @Column(nullable = false)
        var objectVersion: Long = 0

) {
}