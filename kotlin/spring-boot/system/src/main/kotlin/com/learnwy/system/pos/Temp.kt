package com.learnwy.system.pos

import com.learnwy.system.SystemConst

data class Temp(
        var id: Long = -1
) {
    companion object {
        const val TABLE_NAME = "${SystemConst.tablePrefix}${SystemConst.tableSeparator}temp"
    }
}