package com.learnwy.kotlin.jkid

import com.learnwy.kotlin.jkid.annotation.CustomSerializer
import com.learnwy.kotlin.jkid.annotation.JsonExclude
import com.learnwy.kotlin.jkid.annotation.JsonName
import com.learnwy.kotlin.jkid.utils.reflect.getSerializer
import com.learnwy.kotlin.jkid.utils.strings.joinToStringBuilder
import java.lang.StringBuilder
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class Serialize {
}


fun serialize(obj: Any): String =
        buildString {
            when (obj) {
                obj is List<*> -> serializeList(obj as List<Any?>)
                obj is Map<*, *> -> {
                    serializeMap(obj as Map<*, *>)
                }
                else -> serializeObject(obj)
            }
        }

fun serializeMap(map: Map<*, *>) {

}

private fun StringBuilder.serializePropertyValue(value: Any?) {
    when (value) {
        null -> append("null")
        is String -> serializeString(value)
        is Number, is Boolean -> append(value.toString())
        is List<*> -> serializeList(value)
        else -> serializeObject(value)
    }
}

private fun StringBuilder.serializeString(s: String) {
    append('\"')
    s.forEach { append(it.escape()) }
    append('\"')
}

private fun StringBuilder.serializeList(data: List<Any?>) {
    data.joinToStringBuilder(this, prefix = "[", postfix = "]") {
        serializePropertyValue(it)
    }
}

private fun StringBuilder.serializeObject(obj: Any) {
    obj.javaClass.kotlin.memberProperties
            .filter { it.findAnnotation<JsonExclude>() == null }
            .joinToStringBuilder(this, prefix = "{", postfix = "}") {
                serializeProperty(it, obj)
            }
}

private fun StringBuilder.serializeProperty(
        prop: KProperty1<Any, *>, obj: Any
) {
    val jsonNameAnn = prop.findAnnotation<JsonName>()
    val propName = jsonNameAnn?.name ?: prop.name
    serializeString(propName)
    append(": ")

    val value = prop.get(obj)
    val jsonValue = prop.getSerializer()?.toJsonValue(value) ?: value
    serializePropertyValue(jsonValue)
}

private fun Char.escape(): Any =
        when (this) {
            '\\' -> "\\\\"
            '\"' -> "\\\""
            '\b' -> "\\b"
            '\u000C' -> "\\f"
            '\n' -> "\\n"
            '\r' -> "\\r"
            '\t' -> "\\t"
            else -> this
        }
