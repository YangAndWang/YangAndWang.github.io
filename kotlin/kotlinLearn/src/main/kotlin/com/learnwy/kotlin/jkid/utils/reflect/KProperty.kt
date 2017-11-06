package com.learnwy.kotlin.jkid.utils.reflect

import com.learnwy.kotlin.jkid.annotation.CustomSerializer
import com.learnwy.kotlin.jkid.description.ValueSerializer
import kotlin.reflect.KProperty
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation

fun KProperty<*>.getSerializer(): ValueSerializer<Any?>? {
    val customSerializerAnn = findAnnotation<CustomSerializer>() ?: return null
    val serializerClass = customSerializerAnn.serializerClass
    val valueSerializer = serializerClass.objectInstance ?: serializerClass.createInstance()
    return valueSerializer as ValueSerializer<Any?>
}

