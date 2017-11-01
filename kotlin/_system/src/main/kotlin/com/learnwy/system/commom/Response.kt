package com.learnwy.system.commom


data class Response<T>(
        var success: Boolean = false,
        var rows: List<T> = listOf<T>(),
        var errorNo: Int = 0
) : ResquestPage() {
    fun setPage(page: ResquestPage): Response<T> {
        this.total = page.total;
        this.totalPages = page.totalPages;
        return this;
    }
}