package com.learnwy.system.po

import java.util.*

data class Path(
        var id: Long? = null,
        var name: String? = null,
        var description: String? = null,
        var parentPath: Path? = null,
        /**
         * path'name:Path
         */
        var children: MutableMap<String, Path> = mutableMapOf(),
        /**
         * permission is visit update and grant
         */
        var permissionUser: Long = 7,
        var permissionGroup: Long = 0,
        var permissionOther: Long = 0,
        var createDate: Date = Date(),
        var createUserId: Long = 1,

        var updateDate: Date = Date(),
        var updateUserId: Long = 1,

        var objectVersion: Long = 0
) {
}