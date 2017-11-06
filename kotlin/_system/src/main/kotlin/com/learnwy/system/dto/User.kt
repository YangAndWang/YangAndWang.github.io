package com.learnwy.system.dto

import java.util.*


data class User(
        var id: Long,
        var name: String = "guest",
        var password: String,
        var encryptMethod: String = "MD5",
        var permissionPath: Long = 7,
        var permissionFile: Long = 6,
        var groups: List<Group>,

        var createDate: Date,
        var updateDate: Date,
        var expiredDate: Long,
        var forceUpdate: Boolean,
        var forceUpdateFirst: Boolean,
        var forceUpdateExpiredDate: Boolean
) {
}