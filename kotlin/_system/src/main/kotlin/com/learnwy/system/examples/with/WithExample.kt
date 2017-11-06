package com.learnwy.system.examples.with


class WithExample {
    companion object {
        var seeds: CharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_".toCharArray()
        fun genPassword(len: Int): String {
            var count = 0
            val passwordSB = StringBuffer(len);
            return passwordSB.apply {
                while (count < len) {
                    append(seeds[java.util.concurrent.ThreadLocalRandom.current().nextInt(63)])
                    count++
                }
            }.toString()
        }
    }


}