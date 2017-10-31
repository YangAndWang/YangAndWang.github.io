package com.learnwy.kotlinSpringBoot.system.filters

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.Filter
import javax.servlet.annotation.WebFilter


@Component
@ServletComponentScan
@WebFilter(urlPatterns = arrayOf("/*"), filterName = "learnwyFilter")
class LearnwyFilter : Filter {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(LearnwyFilter::class.java);
    }


    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
//        logger.info(learnwyConfig.filter[0]);
        chain?.doFilter(request, response);
    }

    override fun init(filterConfig: FilterConfig?) {
    }

    override fun destroy() {
    }
}