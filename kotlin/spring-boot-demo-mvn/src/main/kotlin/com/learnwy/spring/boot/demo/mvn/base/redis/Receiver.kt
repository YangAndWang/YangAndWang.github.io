package com.learnwy.spring.boot.demo.mvn.base.redis

import java.util.concurrent.CountDownLatch

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

class Receiver @Autowired
constructor(private val latch: CountDownLatch) {

    fun receiveMessage(message: String) {
        logger.info("Received <$message>")
        logger.info(latch.count.toString())
        latch.countDown()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(Receiver::class.java)
    }
}