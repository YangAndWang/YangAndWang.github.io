package com.learnwy.system.examples.let

import com.learnwy.system.examples.let.LetExample.Companion.sendEmail
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class LetExampleTest {
    @Test
    fun sendEmailTest() {
        var email: String? = "121312"
        email?.let { sendEmail(it) }
    }
}