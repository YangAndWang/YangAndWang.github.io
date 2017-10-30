package com.learnwy.kotlinSpringBoot.system.utils

import org.slf4j.Logger

interface Action {
    fun pre(logger: Logger, vararg objects: Any) {
        logger.info("pre${this::class.java.name}")
    }

    fun after(logger: Logger, vararg objects: Any) {
        logger.info("after${this::class.java.name}")
    }

    fun init(logger: Logger, vararg objects: Any) {
        logger.info("init${this::class.java.name}")
    }

    fun action(logger: Logger, vararg objects: Any) {
        logger.info("action${this::class.java.name}")
    }

    fun doAction(logger: Logger, vararg objects: Any) {
        pre(logger, *objects)
        action(logger, *objects)
        after(logger, *objects)
    }
}