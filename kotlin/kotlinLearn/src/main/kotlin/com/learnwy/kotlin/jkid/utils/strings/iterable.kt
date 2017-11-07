package com.learnwy.kotlin.jkid.utils.strings

import java.lang.StringBuilder

fun <T> Iterable<T>.joinToStringBuilder(
        stringBuilder: StringBuilder,
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        limit: Int = -1,
        truncated: CharSequence = "...",
        callback: ((T) -> Unit)? = null): StringBuilder = joinTo(stringBuilder, separator, prefix, postfix, limit, truncated) { if (callback == null) return@joinTo it.toString(); callback(it); "" }