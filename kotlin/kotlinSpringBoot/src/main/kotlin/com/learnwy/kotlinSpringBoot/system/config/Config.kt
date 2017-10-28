package com.learnwy.kotlinSpringBoot.system.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "learnwy")
data class Config(var prefix: String = "learnwy", var delimiter: String = "_") {
    companion object {
        var config = Config();
    }
};
