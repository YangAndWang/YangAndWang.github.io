package com.learnwy.system.commom.utils

import com.learnwy.system.commom.ColumnInfo
import com.learnwy.system.commom.GenerateInfo
import com.learnwy.system.commom.TableInfo

class Generator {
    companion object {
        fun genDtoCode(tableInfo: TableInfo, generateInfo: GenerateInfo): String {
            val packageName = "${generateInfo.parentPackageName}.dto"
            val fileName: String =
                    (generateInfo.projectPath ?: "") +
                            "/src/main/kotlin/${StringUtils.toOtherDelimiter(packageName, '.', '/')}/${StringUtils.toUpperCase(tableInfo.tableName)}.kt"
            val content: String
            val dtoCode = StringBuffer()
            val columns = mutableListOf<ColumnInfo>()
            val baseColumns = tableInfo.columns
            val tableName = tableInfo.tableName
            columns.addAll(baseColumns)
            columns.addAll(TableInfo.commomColumns)
            dtoCode.append("package $packageName\n\n")
                    .append("import com.learnwy.system.commom.SystemConfig\n")
                    .append("import java.util.*\n")
                    .append("import javax.persistence.*\n\n")
                    .append("const val TABLE_NAME_${tableName.toUpperCase()} = SystemConfig.PREFIX + SystemConfig.DELIMITER + \"$tableName\"\n\n")
                    .append("@Entity(name = TABLE_NAME_${tableName.toUpperCase()})\n")
                    .append("data class ${StringUtils.toUpperCase(tableName)}(\n")
            for (index in 0..(columns.size - 1)) {
                dtoCode.append(TableInfo.genColumnDtoCode(columns.get(index)))
                if (index != (columns.size - 1)) {
                    dtoCode.append(',').append('\n')
                }
            }


            dtoCode.append("\n) {\n")
                    .append("}")
            content = dtoCode.toString()
            if (FileUtils.createFileIfNoExists(fileName)) {
                FileUtils.writeFile(fileName, content)
            } else {
                return "generate error"
            }
            return ""
        }

        fun genCreateSql(tableInfo: TableInfo): String {
            val retColumns = mutableListOf<ColumnInfo>()
            retColumns.addAll(tableInfo.columns)
            retColumns.addAll(TableInfo.commomColumns)
            retColumns.addAll(TableInfo.appendColumns)
            val createSQL = StringBuffer(128)
            createSQL.append("CREATE TABLE `${tableInfo.tableName}`(\n")
            for (index in 0..(retColumns.size - 1)) {
                createSQL.append(TableInfo.genColumnCreateSql(retColumns.get(index)))
                if (index != (retColumns.size - 1)) {
                    createSQL.append(',').append('\n')
                }
            }
            createSQL.append("\n)")
            return createSQL.toString()
        }

        fun genRepository(tableInfo: TableInfo, generateInfo: GenerateInfo): String {
            val parentPackageName = generateInfo.parentPackageName
            val packageName = "${parentPackageName}.repositories"
            val tableName = tableInfo.tableName
            val klassName = StringUtils.toUpperCase(tableName)
            val repositoryCode = StringBuffer()
            val fileName: String =
                    (generateInfo.projectPath ?: "") +
                            "/src/main/kotlin/${StringUtils.toOtherDelimiter(packageName, '.', '/')}/${StringUtils.toUpperCase(tableInfo.tableName)}Repository.kt"
            val content: String
            repositoryCode.append("package $packageName\n\n")
                    .append("import $parentPackageName.dto.$klassName\n")
                    .append("import org.springframework.data.domain.Page\n")
                    .append("import org.springframework.data.domain.Pageable\n")
                    .append("import org.springframework.data.repository.CrudRepository\n\n")
                    .append("interface ${klassName}Repository : CrudRepository<$klassName, ${tableInfo.columns[0].type.javaType}> {\n")
                    .append("\tfun findAll(pageRequest: Pageable): Page<$klassName>\n")
                    .append("}")
            content = repositoryCode.toString()
            if (FileUtils.createFileIfNoExists(fileName)) {
                FileUtils.writeFile(fileName, content)
            } else {
                return "generate error"
            }
            return ""
        }

        fun genService(tableInfo: TableInfo, generateInfo: GenerateInfo): String {
            val parentPackageName = generateInfo.parentPackageName
            val packageName = "${parentPackageName}.repositories"
            val tableName = tableInfo.tableName
            val klassName = StringUtils.toUpperCase(tableName)
            val repositoryCode = StringBuffer()
            val fileName: String =
                    (generateInfo.projectPath ?: "") +
                            "/src/main/kotlin/${StringUtils.toOtherDelimiter(packageName, '.', '/')}/${StringUtils.toUpperCase(tableInfo.tableName)}Repository.kt"
            val content: String
            repositoryCode.append("package $parentPackageName.services\n")
                    .append("import com.learnwy.system.commom.ResquestPage\n")
                    .append("import $parentPackageName.dto.$klassName\n")
                    .append("\n")
                    .append("interface ${klassName}Service {\n")
                    .append("\tfun selectAll(page: ResquestPage): List<$klassName>;\n")
                    .append("}")
            content = repositoryCode.toString()
            if (FileUtils.createFileIfNoExists(fileName)) {
                FileUtils.writeFile(fileName, content)
            } else {
                return "generate error"
            }
            return ""
        }

        fun genServiceImpl(tableInfo: TableInfo, generateInfo: GenerateInfo): String {
            val parentPackageName = generateInfo.parentPackageName
            val packageName = "${parentPackageName}.repositories"
            val tableName = tableInfo.tableName
            val klassName = StringUtils.toUpperCase(tableName)
            val repositoryCode = StringBuffer()
            val fileName: String =
                    (generateInfo.projectPath ?: "") +
                            "/src/main/kotlin/${StringUtils.toOtherDelimiter(packageName, '.', '/')}/${StringUtils.toUpperCase(tableInfo.tableName)}Repository.kt"
            val content: String
            repositoryCode.append("package $parentPackageName.services\n")
                    .append("import com.learnwy.system.commom.ResquestPage\n")
                    .append("import $parentPackageName.dto.$klassName\n")
                    .append("\n")
                    .append("interface ${klassName}Service {\n")
                    .append("\tfun selectAll(page: ResquestPage): List<$klassName>;\n")
                    .append("}")
            content = repositoryCode.toString()
            if (FileUtils.createFileIfNoExists(fileName)) {
                FileUtils.writeFile(fileName, content)
            } else {
                return "generate error"
            }
            return ""
        }

        fun genController(tableInfo: TableInfo, generateInfo: GenerateInfo): String {
            val parentPackageName = generateInfo.parentPackageName
            val packageName = "${parentPackageName}.controllers"
            val tableName = tableInfo.tableName
            val klassName = StringUtils.toUpperCase(tableName)
            val repositoryCode = StringBuffer()
            val fileName: String =
                    (generateInfo.projectPath ?: "") +
                            "/src/main/kotlin/${StringUtils.toOtherDelimiter(packageName, '.', '/')}/${StringUtils.toUpperCase(tableInfo.tableName)}Controller.kt"
            val content: String
            repositoryCode.append("package $packageName\n\n")
                    .append("import com.learnwy.system.commom.Response\n")
                    .append("import com.learnwy.system.commom.ResquestPage\n")
                    .append("import $parentPackageName.dto.$klassName\n")
                    .append("import $parentPackageName.services.${klassName}Service\n")
                    .append("import org.springframework.beans.factory.annotation.Autowired\n")
                    .append("import org.springframework.web.bind.annotation.CrossOrigin\n")
                    .append("import org.springframework.web.bind.annotation.GetMapping\n")
                    .append("import org.springframework.web.bind.annotation.RequestMapping\n")
                    .append("import javax.servlet.http.HttpSession\n\n")
                    .append("class ${klassName}Controller {\n")
                    .append("\t@Autowired\n")
                    .append("\tlateinit var ${tableName}Service: ${klassName}Service\n\n")
                    .append("\t@GetMapping(path = arrayOf(\"/query\"))\n")
                    .append("\tfun get${klassName}s(httpSession: HttpSession, page: ResquestPage): Response<$klassName> {\n")
                    .append("\t\tval ret: Response<$klassName> = Response<$klassName>()\n")
                    .append("\t\tret.rows = ${tableName}Service.selectAll(page);\n")
                    .append("\t\tret.setPage(page);\n")
                    .append("\t\tret.success = true;\n")
                    .append("\t\treturn ret;\n")
                    .append("\t}")
                    .append("}")
            content = repositoryCode.toString()
            if (FileUtils.createFileIfNoExists(fileName)) {
                FileUtils.writeFile(fileName, content)
            } else {
                return "generate error"
            }
            return ""
        }
    }
}