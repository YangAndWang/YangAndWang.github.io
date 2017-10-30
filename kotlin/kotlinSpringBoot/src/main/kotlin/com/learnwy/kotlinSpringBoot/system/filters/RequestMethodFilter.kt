package com.learnwy.kotlinSpringBoot.system.filters

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
@ServletComponentScan
@WebFilter(urlPatterns = arrayOf("/*"), filterName = "RequestMethodFilter")
class RequestMethodFilter : Filter {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(RequestMethodFilter::class.java);
    }

    override fun destroy() {
    }

    /**
     * return:Boolean has been doFilter
     */
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        logger.info("pre Handle ${request?.localAddr}");
        println("pre Handle ${request?.localAddr}");
    }

    override fun init(filterConfig: FilterConfig?) {
    }

    private fun dealNothing(httpResuest: HttpServletRequest, httpResponse: HttpServletResponse, handler: Object) {
    }

    private fun dealGet(httpResuest: HttpServletRequest, httpResponse: HttpServletResponse, handler: Object) {
    }

}