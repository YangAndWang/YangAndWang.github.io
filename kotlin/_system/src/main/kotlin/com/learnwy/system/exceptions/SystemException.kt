package com.learnwy.system.exceptions

class SystemException(var code: Int = 500, override var message: String = "System Error") : RuntimeException() {
}