package com.learnwy.kotlin.jkid.annotation

import com.learnwy.kotlin.jkid.description.ValueSerializer
import kotlin.reflect.KClass

annotation class CustomSerializer(val serializerClass: KClass<out ValueSerializer<*>>)