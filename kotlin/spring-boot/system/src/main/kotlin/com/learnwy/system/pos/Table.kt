package com.learnwy.system.pos

import com.learnwy.system.utils.StringUtils.Companion.upperCaseCamel2CaseCamel


data class Table(var tableName: String, var columns: MutableList<SqlColumn> = mutableListOf(SqlColumn("id", SqlColumn.SqlTypeToJavaType.Long, "-1"))) {
    fun toKotlinClass(genTableName: () -> String = { "const val TABLE_NAME = \"${"$"}{SystemConst.tablePrefix}${"$"}{SystemConst.tableSeparator}${upperCaseCamel2CaseCamel(tableName)}\"" }): String {
        return StringBuffer().apply {
            append("import com.learnwy.system.SystemConst\n")
            append("data class ${tableName} (\n")
            for (col in columns) {
                append(col.toKotlinConstructorPro())
            }
            append(") {\n")
            append("\tcompanion object {\n")
            append("\t${genTableName()}\n")
            append("\t}")
            append("}")
        }.toString()
    }
}