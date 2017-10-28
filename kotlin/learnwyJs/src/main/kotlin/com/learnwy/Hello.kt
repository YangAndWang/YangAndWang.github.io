package com.learnwy

import org.w3c.dom.HTMLObjectElement
import kotlin.reflect.KProperty


/**
 * Example main function. Started at script body.
 * At first time you have to run `mvn package`.
 * Open example index.html in browser once you compile it.
 */


fun main(args: Array<String>) {
    fun foo(vararg strings: String) { /* ... */
        console.log(strings)
    }
    foo(strings = *arrayOf("a", "b", "c"))
    var a: String = "a";
    var b: String = a;
    foo(strings = "a") // Not required for a single value
}
