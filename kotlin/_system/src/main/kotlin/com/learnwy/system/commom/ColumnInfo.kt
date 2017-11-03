package com.learnwy.system.commom


data class ColumnInfo(
        var name: String,
        var type: ColumnType,
        var default: String? = null,
        var notNull: Boolean = true,
        var autoInc: Boolean = false,
        var unique: Boolean = false,
        var pk: Boolean = false,
        var comment: String = "",
        var minLen: Long = 0L,
        var maxLen: Long = 255,
        var precision: Int = 0,
        var scale: Int = 0,
        var insertable: Boolean = true,
        var updatable: Boolean = true,
        var table: String = ""
) {

    data class ColumnType(
            var javaType: String,
            var sqlType: String
    ) {
        companion object {
            val STRING: ColumnType = ColumnType(
                    "String",
                    "NVARCHAR"
            );
            val LONG: ColumnType = ColumnType(
                    "Long",
                    "BIGINT"
            );
            val INT: ColumnType = ColumnType(
                    javaType = "Int",
                    sqlType = "INT"
            );
            val DATETIME: ColumnType = ColumnType(
                    javaType = "Date",
                    sqlType = "DATETIME"
            );
            val DATE: ColumnType = ColumnType(
                    javaType = "Date",
                    sqlType = "DATE"
            );
        }
    }

    companion object {
        var DEFAULT: ColumnInfo = ColumnInfo(name = "default", type = ColumnType.STRING)
        val ID: ColumnInfo = ColumnInfo(
                name = "id",
                type = ColumnType.LONG.copy(),
                autoInc = true,
                pk = true,
                comment = "table primary key"
        );
        val NAME: ColumnInfo = ColumnInfo(
                name = "name",
                type = ColumnType.STRING.copy(),
                maxLen = 256,
                comment = "path name"
        );
        val LONG: ColumnInfo = ColumnInfo(
                name = "long columns",
                type = ColumnType.LONG.copy(),
                comment = ""
        );
    }
}