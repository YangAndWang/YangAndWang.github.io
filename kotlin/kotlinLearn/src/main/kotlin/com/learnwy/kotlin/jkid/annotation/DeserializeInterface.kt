package com.learnwy.kotlin.jkid.annotation

import kotlin.reflect.KClass

annotation class DeserializeInterface(val targetClass: KClass<out Any>)