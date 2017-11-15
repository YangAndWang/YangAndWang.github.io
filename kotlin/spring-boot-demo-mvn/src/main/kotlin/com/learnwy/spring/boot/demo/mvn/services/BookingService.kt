package com.learnwy.spring.boot.demo.mvn.services


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class BookingService(private val jdbcTemplate: JdbcTemplate) {

    @Transactional
    fun book(vararg persons: String?) {
        for (person in persons) {
            logger.info("Booking $person in a seat...")
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person)
        }
    }

    fun findAllBookings(): List<String> {
        return jdbcTemplate.query("select FIRST_NAME from BOOKINGS"
        ) { rs, rowNum -> rs.getString("FIRST_NAME") }
    }

    companion object {

        private val logger = LoggerFactory.getLogger(BookingService::class.java)
    }

}