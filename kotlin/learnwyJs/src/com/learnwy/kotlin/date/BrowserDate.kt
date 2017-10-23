package com.learnwy.kotlin.date

import kotlin.js.Date


public external interface BrowserDate {
    public fun getFullYear(): Number;
    public fun geMonth(): Number;
    public fun getDate(): Number;
    public fun getTime(): Number;
}
