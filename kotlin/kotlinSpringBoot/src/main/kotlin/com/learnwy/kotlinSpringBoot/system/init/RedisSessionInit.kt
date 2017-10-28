package com.learnwy.kotlinSpringBoot.system.init

import com.learnwy.kotlinSpringBoot.system.config.RedisSessionConfig
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer


class RedisSessionInit : AbstractHttpSessionApplicationInitializer(RedisSessionConfig::class.java) {
};