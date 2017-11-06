package com.learnwy.kotlin.jkid.utils.strings

fun <T> Collection<T>.joinToStringBuffer(
        stringBuilder: StringBuffer = StringBuffer(),
        separator: CharSequence = "",
        collection: Collection<T> = this,
        prefix: String = "",
        postfix: String = "",
        transform: ((T) -> CharSequence)? = null,
        limit: Int = -1,
        truncated: CharSequence = "..."
) {

}