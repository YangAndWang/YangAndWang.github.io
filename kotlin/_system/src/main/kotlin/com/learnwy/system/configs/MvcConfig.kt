package com.learnwy.system.configs

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MvcConfig : WebMvcConfigurer {
    override fun addViewControllers(viewControllerRegistry: ViewControllerRegistry) {
        viewControllerRegistry.addViewController("/").setViewName("root");
    }

    override fun addInterceptors(registry: InterceptorRegistry?) {
        super.addInterceptors(registry)
        registry?.addInterceptor(RoleInterceptor())?.addPathPatterns("/**");
        super.addInterceptors(registry)
    }
}