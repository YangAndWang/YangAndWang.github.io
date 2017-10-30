package com.learnwy.kotlinSpringBoot.system.config;

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "learnwy")
class LearnwyConfig {
    lateinit var filter: List<String>;

    constructor() {}
    constructor(filter: List<String>) {
        this.filter = filter;
    }
};