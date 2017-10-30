package com.learnwy.kotlinSpringBoot.system.filters

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.annotation.WebFilter

@Component
@ServletComponentScan
@WebFilter(urlPatterns = arrayOf("/api/*"), filterName = "RouterFilter")
class RouterFilter:Filter {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(RouterFilter::class.java);
    }

    override fun destroy() {
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        logger.info(request?.localAddr);
        println(request?.localAddr)
    }

    override fun init(filterConfig: FilterConfig?) {
    }
}