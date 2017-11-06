package com.learnwy.system.dto

import java.util.*

data class File(
        var id: Long? = null,
        var name: String = "",
        var description: String = "",
        var displayName: String,
        var userPermission: Long,
        var groupPermission: Long,
        var otherPermission: Long,
        var ownUserId: Long,
        var ownGroupId: Long,
        var createDate: Date,
        var createUserId: Long,
        var createGroupId: Long,
        var updateDate: Date,
        var updateUserId: Long,
        var updateGroupId: Long,
        var objectVersionNumber: Long
) {

}