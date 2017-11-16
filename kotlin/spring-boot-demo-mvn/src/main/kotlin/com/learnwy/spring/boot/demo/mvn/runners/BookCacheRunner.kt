package com.learnwy.spring.boot.demo.mvn.runners

import com.learnwy.spring.boot.demo.mvn.repositories.BookRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class BookCacheRunner(private val bookRepository: BookRepository) : CommandLineRunner {

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        logger.info(".... Fetching books")
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"))
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"))
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"))
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"))
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"))
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"))
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"))
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"))
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"))
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"))
    }

    companion object {

        private val logger = LoggerFactory.getLogger(BookCacheRunner::class.java)
    }

}