package com.learnwy.spring.boot.demo.mvn

import com.learnwy.spring.boot.demo.mvn.base.redis.Receiver
import com.learnwy.spring.boot.demo.mvn.base.storage.FileSystemStorageService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.learnwy.spring.boot.demo.mvn.base.storage.StorageService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.connection.RedisConnectionFactory
import java.util.concurrent.CountDownLatch
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.data.redis.listener.PatternTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER
import org.springframework.cache.annotation.EnableCaching


@SpringBootApplication
@EnableCaching
class MvnApplication {

    companion object {
        val logger = LoggerFactory.getLogger(MvnApplication::class.java)!!
    }

    @Bean
    fun container(connectionFactory: RedisConnectionFactory,
                  listenerAdapter: MessageListenerAdapter): RedisMessageListenerContainer {

        val container = RedisMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.addMessageListener(listenerAdapter, PatternTopic("chat"))

        return container
    }

    @Bean
    fun listenerAdapter(receiver: Receiver): MessageListenerAdapter {
        return MessageListenerAdapter(receiver, "receiveMessage")
    }

    @Bean
    fun receiver(latch: CountDownLatch): Receiver {
        return Receiver(latch)
    }

    @Bean
    fun latch(): CountDownLatch {
        return CountDownLatch(4)
    }

    @Bean
    fun template(connectionFactory: RedisConnectionFactory): StringRedisTemplate {
        return StringRedisTemplate(connectionFactory)
    }

    @Bean
    fun init(): CommandLineRunner {
        val storageService: StorageService = FileSystemStorageService()
        return CommandLineRunner {
            storageService.deleteAll()
            storageService.init()
        }
    }
}

fun main(args: Array<String>) {
    val ctx: ApplicationContext = runApplication<MvnApplication>(*args)
    val template = ctx.getBean(StringRedisTemplate::class.java)
    val latch = ctx.getBean(CountDownLatch::class.java)

    MvnApplication.logger.info("Sending message...")
    template.convertAndSend("chat", "Hello from Redis1!")
    template.convertAndSend("chat", "Hello from Redis2!")
    template.convertAndSend("chat", "Hello from Redis3!")
    template.convertAndSend("chat", "Hello from Redis4!")
    template.convertAndSend("chat", "Hello from Redis5!")
    println("before await")
    latch.await()
    println("after await")
    println("before shutdown")
//    System.exit(0)
}
