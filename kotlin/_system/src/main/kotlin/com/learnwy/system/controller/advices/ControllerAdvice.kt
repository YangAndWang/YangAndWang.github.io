package com.learnwy.system.controller.advices

import com.learnwy.system.exceptions.SystemException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.HashMap
import org.springframework.web.bind.annotation.ResponseBody


@ControllerAdvice
class SystemControllerAdvice {
    @ResponseBody
    @ExceptionHandler(value = Exception::class)
    fun errorHandler(ex: Exception): Map<String, Any?> {
        return HashMap<String, Any?>().apply {
            put("code", 100)
            put("msg", ex.message)
        }
    }

    @ResponseBody
    @ExceptionHandler(value = SystemException::class)
    fun systemErrorHandler(ex: SystemException): Map<String, Any> {
        return HashMap<String, Any>().apply {
            put("code", ex.code)
            put("msg", ex.message)
        }
    }
}