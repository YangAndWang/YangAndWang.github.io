package com.learnwy.kotlinSpringBoot.system.config;

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisSentinelConfiguration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory


@EnableRedisHttpSession
public class RedisSessionConfig {

    @Bean
    fun connectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory();
    }
}