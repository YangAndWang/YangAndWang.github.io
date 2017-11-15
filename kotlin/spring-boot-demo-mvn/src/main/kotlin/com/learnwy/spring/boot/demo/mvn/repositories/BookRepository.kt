package com.learnwy.spring.boot.demo.mvn.repositories

import com.learnwy.spring.boot.demo.mvn.dtos.Book
import org.springframework.cache.annotation.Cacheable

interface BookRepository {
    @Cacheable("books")
    fun getByIsbn(isbn: String): Book

}