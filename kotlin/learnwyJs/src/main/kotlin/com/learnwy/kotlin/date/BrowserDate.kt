package com.learnwy.kotlin.date

import kotlin.js.Date


public external interface BrowserDate {
    fun getFullYear(): Number;
    fun geMonth(): Number;
    fun getDate(): Number;
    fun getTime(): Number;
    fun getDay(): Number;
    fun getSecond(): Number;
}
