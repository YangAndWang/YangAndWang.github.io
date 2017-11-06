package com.learnwy.system.dto

import java.util.*

data class Group(
        var id: Long,
        var name: String = "guest",
        var permissionPath: Long = 7,
        var permissionFile: Long = 6,
        var description: String = "$name's group",
        var users: List<User>,

        var createDate: Date,
        var updateDate: Date
) {
}