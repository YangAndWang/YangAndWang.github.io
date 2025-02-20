package com.learnwy.system.examples.hello

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockServletContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.hamcrest.Matchers.equalTo

@RunWith(SpringRunner::class)
@SpringBootTest
class HelloControllerTest {
    private var mvc: MockMvc? = null
    @Before
    @Throws(Exception::class)
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(HelloController()).build()
    }

    @Test
    fun hello() {
        mvc
                ?.perform(MockMvcRequestBuilders
                        .get("/hello?name=1")
                        .accept(MediaType.APPLICATION_JSON))
                ?.andExpect(status().isOk())
                ?.andExpect(content().string(equalTo("hello,1")));

    }

}