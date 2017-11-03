package com.learnwy.system.commom.utils


class StringUtils {
    companion object {
        val SINGLE_UPPER_CASE_REGEX = "([A-Z])".toRegex();
        fun lowerCase(humpString: String, delimiter: Char = '_'): String {
            val lowerCaseString = StringBuffer(humpString.length);
            var ch = ' ';
            for (index in 0.until(humpString.length)) {
                ch = humpString.get(index);
                if (ch.isUpperCase()) {
                    if (index === 0) {
                        lowerCaseString.append(ch.toLowerCase())
                    } else {
                        lowerCaseString.append("$delimiter${ch.toLowerCase()}")
                    }
                } else {
                    lowerCaseString.append(ch)
                }
            }
            return lowerCaseString.toString()
        }

        fun toUpperCase(lowerCaseString: String, delimiter: Char = '_'): String {
            val upperCaseString = StringBuffer()
            for (str in lowerCaseString.split(delimiter)) {
                upperCaseString.append(str.get(0).toUpperCase()).append(str.substring(1))
            }

            return upperCaseString.toString()
        }

        fun toOtherDelimiter(str: String, lastDelimiter: Char, otherDelimiter: Char): String {
            return str.replace(lastDelimiter, otherDelimiter)
        }

    }
}