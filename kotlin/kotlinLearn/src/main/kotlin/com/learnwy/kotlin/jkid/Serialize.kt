package com.learnwy.kotlin.jkid

import com.learnwy.kotlin.jkid.annotation.CustomSerializer
import com.learnwy.kotlin.jkid.annotation.JsonExclude
import com.learnwy.kotlin.jkid.annotation.JsonName
import com.learnwy.kotlin.jkid.utils.reflect.getSerializer
import com.learnwy.kotlin.jkid.utils.strings.joinToStringBuffer
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

class Serialize {

}


fun serialize(obj: Any): String {
    val sb = StringBuffer()
    with(sb) {
        val kClass = obj.javaClass.kotlin
        val properties = kClass.memberProperties.filter { it.findAnnotation<JsonExclude>() == null }
        properties.joinToStringBuffer(prefix = "{", postfix = "}", transform = {
            val value = it.get(obj)
            serializeString(it.findAnnotation<JsonName>()?.name ?: it.name)
            append(":")
            serializePropertyValue(it.getSerializer()?.toJsonValue(value) ?: value)

        }return sb . toString ()
    }