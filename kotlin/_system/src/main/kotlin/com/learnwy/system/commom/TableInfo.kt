package com.learnwy.system.commom

import com.learnwy.system.commom.utils.StringUtils

data class TableInfo(
        var tableName: String = "test",
        var columns: MutableList<ColumnInfo> = mutableListOf<ColumnInfo>()) {

    companion object {
        private val attributeColumn = ColumnInfo(
                "appendAttribute",
                type = ColumnInfo.ColumnType.STRING,
                maxLen = 128,
                comment = "appendAttribute",
                notNull = false)
        val appendColumns = listOf<ColumnInfo>(
                attributeColumn.copy(name = "attributeColumn1", comment = "attributeColumn1"),
                attributeColumn.copy(name = "attributeColumn2", comment = "attributeColumn2"),
                attributeColumn.copy(name = "attributeColumn3", comment = "attributeColumn3"),
                attributeColumn.copy(name = "attributeColumn4", comment = "attributeColumn4"),
                attributeColumn.copy(name = "attributeColumn5", comment = "attributeColumn5"),
                attributeColumn.copy(name = "attributeColumn6", comment = "attributeColumn6"),
                attributeColumn.copy(name = "attributeColumn7", comment = "attributeColumn7"),
                attributeColumn.copy(name = "attributeColumn8", comment = "attributeColumn8"),
                attributeColumn.copy(name = "attributeColumn9", comment = "attributeColumn9"),
                attributeColumn.copy(name = "attributeColumn10", comment = "attributeColumn10")
        )
        val commomColumns = listOf<ColumnInfo>(ColumnInfo(name = "createDate", type = ColumnInfo.ColumnType.DATETIME),
                ColumnInfo.LONG.copy(name = "createUserId", comment = "createUserId"),
                ColumnInfo.LONG.copy(name = "createGroupId", comment = "createGroupId"),
                ColumnInfo(name = "updateDate", type = ColumnInfo.ColumnType.DATETIME),
                ColumnInfo.LONG.copy(name = "updateUserId", comment = "updateUserId"),
                ColumnInfo.LONG.copy(name = "updateGroupId", comment = "updateGroupId"),
                ColumnInfo(name = "objectVersionNumber", type = ColumnInfo.ColumnType.LONG, comment = "objectVersionNumber")
        )
        private const val PK = " PRIMARY KEY "
        private const val AUTO_INC = " AUTO_INCREMENT "
        private const val NOT_NULL = " NOT NULL "
        private const val NULL = " NULL "
        private const val UNIQUE = " UNIQUE "
        fun genColumnCreateSql(column: ColumnInfo): String {
            val columnCreateSQL = StringBuffer(32)
            columnCreateSQL.append("\t`${StringUtils.lowerCase(column.name)}` ${column.type.sqlType}")
            if (column.type.javaType === "String") {
                columnCreateSQL.append("(${column.maxLen})")
            }
            if (column.pk) {
                columnCreateSQL.append(PK)
                if (column.autoInc) {
                    columnCreateSQL.append(AUTO_INC)
                }
            } else {
                if (column.notNull) {
                    columnCreateSQL.append(NOT_NULL)
                } else {
                    columnCreateSQL.append(NULL)
                }
                if (column.unique) {
                    columnCreateSQL.append(UNIQUE)
                }
            }
            columnCreateSQL.append(" COMMENT '${column.comment}'")
            return columnCreateSQL.toString()
        }


        private fun addComma(stringBuffer: StringBuffer, addAction: (stringBuffer: StringBuffer)
        -> Boolean = { sb -> sb.isNotEmpty() }): StringBuffer {
            if (addAction(stringBuffer)) {
                stringBuffer.append(',')
            }
            return stringBuffer
        }

        fun genColumnDtoCode(columnInfo: ColumnInfo): String {
            val column = StringBuffer()
            if (columnInfo.unique != ColumnInfo.DEFAULT.unique) {
                addComma(column).append(" unique = true ")
            }
            if (columnInfo.notNull != ColumnInfo.DEFAULT.notNull) {
                addComma(column).append(" nullable=false ")
            }
            if (columnInfo.insertable != ColumnInfo.DEFAULT.insertable) {
                addComma(column).append(" insertable=false ")
            }
            if (columnInfo.updatable != ColumnInfo.DEFAULT.updatable) {
                addComma(column).append(" updatable=false ")
            }
            if (columnInfo.table != ColumnInfo.DEFAULT.table) {
                addComma(column).append(" table=${columnInfo.table} ")
            }
            if (columnInfo.maxLen != ColumnInfo.DEFAULT.maxLen) {
                addComma(column).append(" length=${columnInfo.maxLen} ")
            }

            if (columnInfo.precision != ColumnInfo.DEFAULT.precision) {
                addComma(column).append(" precision=${columnInfo.precision} ")
            }

            if (columnInfo.scale != ColumnInfo.DEFAULT.scale) {
                addComma(column).append(" scale=${columnInfo.scale} ")
            }

            val columnDtoCode = StringBuffer()
            if (columnInfo.pk) {
                columnDtoCode.append("\t@Id\n")
                        .append("\t@GeneratedValue(strategy = GenerationType.IDENTITY)\n")
            }
            if (column.isNotEmpty()) {
                columnDtoCode.append("\t@Column(${column.toString()})\n")
            }

            columnDtoCode.append("\tvar ${columnInfo.name}: ${columnInfo.type.javaType}")
            if (columnInfo.default !== null) {
                when (columnInfo.type.javaType) {
                    "String" -> columnDtoCode.append(" = ${columnInfo.default}")
                    else -> {
                    }
                }
            }
            return columnDtoCode.toString();
        }
    }
}