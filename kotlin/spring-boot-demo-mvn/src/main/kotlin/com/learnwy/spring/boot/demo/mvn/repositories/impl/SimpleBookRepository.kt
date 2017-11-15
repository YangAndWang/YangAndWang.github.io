package com.learnwy.spring.boot.demo.mvn.repositories.impl

import com.learnwy.spring.boot.demo.mvn.dtos.Book
import com.learnwy.spring.boot.demo.mvn.repositories.BookRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component


@Component
class SimpleBookRepository : BookRepository {
    @Cacheable("books")
    override fun getByIsbn(isbn: String): Book {
        simulateSlowService()
        return Book(isbn, "Some book")
    }

    // Don't do this at home
    private fun simulateSlowService() {
        try {
            val time = 3000L
            Thread.sleep(time)
        } catch (e: InterruptedException) {
            throw IllegalStateException(e)
        }

    }

}