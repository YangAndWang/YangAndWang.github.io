package com.learnwy.system.utils

class StringUtils {
    companion object {
        fun toCaseCamel(str: String, seq: Char = '_'): String {
            return StringBuffer().apply {
                val strs = str.split(seq)
                for (index in 0 until strs.size) {
                    if (index == 0) {
                        append(strs[index])
                    } else {
                        if (strs[index].length > 1) {
                            append("${strs[index][0].toUpperCase()}${strs[index].substring(1)}")
                        } else if (strs[index].length == 1) {
                            append(strs[index].toUpperCase())
                        }
                    }
                }
            }.toString()
        }

        fun toUpperCaseCamel(str: String, seq: Char = '_'): String {
            return StringBuffer().apply {
                val strs = str.split(seq)
                for (index in 0 until strs.size) {
                    if (strs[index].length > 1) {
                        append("${strs[index][0].toUpperCase()}${strs[index].substring(1)}")
                    } else if (strs[index].length == 1) {
                        append(strs[index].toUpperCase())
                    }
                }
            }.toString()
        }

        fun upperCaseCamel2CaseCamel(str: String): String {
            if (str.length > 1) {
                return "${str[0].toLowerCase()}${str.substring(1)}"
            } else if (str.length == 1) {
                return str.toUpperCase()
            }
            return str
        }

        fun caseCamel2UpperCaseCamel(str: String): String {
            if (str.length > 1) {
                return "${str[0].toUpperCase()}${str.substring(1)}"
            } else if (str.length == 1) {
                return str.toUpperCase()
            }
            return str
        }
    }
}