package com.learnwy.kotlinSpringBoot

import org.springframework.data.domain.PageRequest

data class Request<T>(var data: T? = null, var page: Int = 0, var pageSize: Int = 10) {
    fun getPage(): PageRequest {
        var page: Int = this.page ?: 0;
        var pageSize: Int = this.pageSize ?: 10;
        return PageRequest.of(page, pageSize);
    }
};
