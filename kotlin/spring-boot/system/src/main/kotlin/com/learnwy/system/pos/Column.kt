package com.learnwy.system.pos

data class Column(var name: String, var type: SqlTypeToJavaType) {

    data class SqlTypeToJavaType(
            var sqlType: String,
            var javaType: String,
            var length: Long? = null

    ) {
        companion object {
            var Long = SqlTypeToJavaType("bigint", "Long")
            var Int = SqlTypeToJavaType("int", "Int")
            var DateTime = SqlTypeToJavaType("datetime", "Date")
            var Date = SqlTypeToJavaType("date", "Date")
            var NVarchar32 = SqlTypeToJavaType("nvarchar", "String", 32)
            var NVarchar64 = SqlTypeToJavaType("nvarchar", "String", 64)
            var NVarchar128 = SqlTypeToJavaType("nvarchar", "String", 128)
            var NVarchar256 = SqlTypeToJavaType("nvarchar", "String", 256)
            var NVarchar512 = SqlTypeToJavaType("nvarchar", "String", 512)
            var NVarchar1024 = SqlTypeToJavaType("nvarchar", "String", 1024)
            var NVarchar2048 = SqlTypeToJavaType("nvarchar", "String", 2048)
            var Varchar32 = SqlTypeToJavaType("varchar", "String", 32)
            var Varchar64 = SqlTypeToJavaType("varchar", "String", 64)
            var Varchar128 = SqlTypeToJavaType("varchar", "String", 128)
            var Varchar256 = SqlTypeToJavaType("varchar", "String", 256)
            var Varchar512 = SqlTypeToJavaType("varchar", "String", 512)
            var Varchar1024 = SqlTypeToJavaType("varchar", "String", 1024)
            var Varchar2048 = SqlTypeToJavaType("varchar", "String", 2048)
        }
    }
}