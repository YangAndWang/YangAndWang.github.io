package com.learnwy.system.po

import com.learnwy.system.commom.SystemConfig
import java.util.*
import javax.persistence.*

const val TABLE_NAME_PATH = SystemConfig.PREFIX + SystemConfig.DELIMITER + "path"

@Entity(name = TABLE_NAME_PATH)
data class Path(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(length = 256)
        var name: String = "",
        @Column(length = 1024)
        var description: String = "",
        @Column(length = 1024)
        var displayName: String = "",
        var userPermission: Long = 7,
        var groupPermission: Long = 5,
        var otherPermission: Long = 5,
        var ownUserId: Long = 1,
        var ownGroupId: Long = 1,
        var createDate: Date = Date(),
        var createUserId: Long = 1,
        var createGroupId: Long = 1,
        var updateDate: Date = Date(),
        var updateUserId: Long = 1,
        var updateGroupId: Long = 1,
        var objectVersionNumber: Long = 0
) {
}