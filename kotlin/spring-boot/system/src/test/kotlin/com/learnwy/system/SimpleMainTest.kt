package com.learnwy.system

import com.learnwy.system.pos.Table
import org.junit.Test

class SimpleMainTest {
    @Test
    fun simpleMain() {
        val t = Table(tableName = "Temp")
        println(t.toKotlinClass())
    }
}