package com.learnwy.kotlinSpringBoot

import com.learnwy.kotlinSpringBoot.system.data.User
import com.sun.org.apache.xpath.internal.operations.Bool
import org.springframework.data.domain.Page

data class Response<T>(var success: Boolean = true, var message: String = "ok", var rows: List<T> = listOf(), var total: Int = rows.size, var errorNo: Int = 0, var pages: Int = 0, var page: Int = 0, var pageSize: Int = 10) {
    fun setData(page: Page<T>): Response<T> {
        this.rows = page.content ?: (arrayListOf<T>() as List<T>);
        this.total = this.rows.size;
        this.pages = page.totalPages;
        return this;
    }

    class ResponseStatusCode {
        companion object {
            val OK: Int = 200;
            val FORBIDDEN: Int = 403;
            val NOT_FOUND: Int = 404;
        }
    }
};