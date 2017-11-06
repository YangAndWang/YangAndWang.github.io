package com.learnwy.system.examples.with

import org.junit.Test
import com.learnwy.system.examples.with.WithExample.Companion.genPassword
import org.junit.Assert.*

class WithExampleTest {
    @Test
    fun genPasswordTest() {
        repeat(100, {
            println(genPassword(12));
        })
    }

}