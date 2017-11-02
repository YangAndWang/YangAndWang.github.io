package com.learnwy.system.filters

import javax.servlet.*
import javax.servlet.annotation.WebFilter

@WebFilter
class CssFilter : Filter {
    override fun destroy() {
    }

    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
    }

    override fun init(filterConfig: FilterConfig) {
    }
}