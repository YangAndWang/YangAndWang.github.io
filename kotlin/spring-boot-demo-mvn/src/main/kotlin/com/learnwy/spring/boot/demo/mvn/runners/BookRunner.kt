package com.learnwy.spring.boot.demo.mvn.runners

import com.learnwy.spring.boot.demo.mvn.services.BookingService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.util.Assert

@Component
internal class BookRunner(private val bookingService: BookingService) : CommandLineRunner {

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        bookingService.book("Alice", "Bob", "Carol")
        Assert.isTrue(bookingService.findAllBookings().size == 3,
                "First booking should work with no problem")
        logger.info("Alice, Bob and Carol have been booked")
        try {
            bookingService.book("Chris", "Samuel")
        } catch (e: RuntimeException) {
            logger.info("v--- The following exception is expect because 'Samuel' is too " + "big for the DB ---v")
            logger.error(e.message)
        }

        for (person in bookingService.findAllBookings()) {
            logger.info("So far, $person is booked.")
        }
        logger.info("You shouldn't see Chris or Samuel. Samuel violated DB constraints, " + "and Chris was rolled back in the same TX")
        Assert.isTrue(bookingService.findAllBookings().size == 3,
                "'Samuel' should have triggered a rollback")

        try {
            bookingService.book("Buddy", null)
        } catch (e: RuntimeException) {
            logger.info("v--- The following exception is expect because null is not " + "valid for the DB ---v")
            logger.error(e.message)
        }

        for (person in bookingService.findAllBookings()) {
            logger.info("So far, $person is booked.")
        }
        logger.info("You shouldn't see Buddy or null. null violated DB constraints, and " + "Buddy was rolled back in the same TX")
        Assert.isTrue(bookingService.findAllBookings().size == 3,
                "'null' should have triggered a rollback")
    }

    companion object {

        private val logger = LoggerFactory.getLogger(BookRunner::class.java)
    }

}