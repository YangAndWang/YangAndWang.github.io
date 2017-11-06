package com.learnwy.system.dto

import com.learnwy.system.commom.SystemConfig
import java.util.*


data class Path(
        var id: Long? = null,
        var name: String = "",
        var description: String = "",
        var displayName: String = "",
        var userPermission: Long = 7,
        var groupPermission: Long = 5,
        var otherPermission: Long = 5,
        var ownUserId: Long = 1,
        var ownGroupId: Long = 1,
        var files: List<File>,


        var createDate: Date = Date(),
        var createUserId: Long = 1,
        var createGroupId: Long = 1,
        var updateDate: Date = Date(),
        var updateUserId: Long = 1,
        var updateGroupId: Long = 1,
        var objectVersionNumber: Long = 0
) {
}