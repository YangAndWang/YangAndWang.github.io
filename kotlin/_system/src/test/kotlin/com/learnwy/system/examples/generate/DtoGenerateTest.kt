package com.learnwy.system.examples.generate

import com.learnwy.system.commom.ColumnInfo
import com.learnwy.system.commom.GenerateInfo
import com.learnwy.system.commom.TableInfo
import com.learnwy.system.commom.utils.Generator.Companion.genController
import com.learnwy.system.commom.utils.Generator.Companion.genCreateSql
import com.learnwy.system.commom.utils.Generator.Companion.genDtoCode
import com.learnwy.system.commom.utils.Generator.Companion.genRepository
import com.learnwy.system.commom.utils.Generator.Companion.genService
import org.junit.Assert.*
import org.junit.Test

class DtoGenerateTest {

    @Test
    fun createAll() {
        val tableInfo: TableInfo = TableInfo();
        tableInfo.tableName = "file";
        tableInfo.columns.add(ColumnInfo.ID)
        tableInfo.columns.add(ColumnInfo.NAME)
        tableInfo.columns.add(ColumnInfo("description", ColumnInfo.ColumnType.STRING, maxLen = 1024))
        tableInfo.columns.add(ColumnInfo("displayName", ColumnInfo.ColumnType.STRING, maxLen = 1024, comment = "is displayName is null,the name will use"))
        tableInfo.columns.add(ColumnInfo("userPermission", ColumnInfo.ColumnType.LONG, comment = "user permission"))
        tableInfo.columns.add(ColumnInfo("groupPermission", ColumnInfo.ColumnType.LONG, comment = "group permission"))
        tableInfo.columns.add(ColumnInfo("otherPermission", ColumnInfo.ColumnType.LONG, comment = "other permission"))
        tableInfo.columns.add(ColumnInfo.LONG.copy(name = "ownUserId", comment = "ownUserId"))
        tableInfo.columns.add(ColumnInfo.LONG.copy(name = "ownGroupId", comment = "ownGroupId"))
        val generateInfo: GenerateInfo = GenerateInfo("/learnwy/git/learnwy/kotlin/_system", "com.learnwy.system")
        print(genDtoCode(tableInfo, generateInfo));
        print(genRepository(tableInfo, generateInfo))
        print(genController(tableInfo, generateInfo))
        print(genService(tableInfo, generateInfo))
        print(genCreateSql(tableInfo));
    }
}