package com.learnwy.kotlin.jkid

import org.junit.Test
import kotlin.reflect.memberProperties

class Serialize {

}
@Test
fun serialize(obj: Any): String {
    val sb = StringBuffer()
    with(sb) {
        val kClass = obj.javaClass.kotlin
        val properties = kClass.memberProperties
    }
    return sb.toString()
}