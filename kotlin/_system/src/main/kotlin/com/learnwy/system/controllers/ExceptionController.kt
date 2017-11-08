package com.learnwy.system.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ErrorProperties
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 重写BasicErrorController,主要负责系统的异常页面的处理以及错误信息的显示
 * @see org.springframework.boot.autoconfigure.web.BasicErrorController
 * @see org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration
 *
 * @author Jonathan
 * @version 2016/5/31 11:22
 * @since JDK 7.0+
 */
@Controller
@RequestMapping(value = "/error")
@EnableConfigurationProperties(value = ServerProperties::class)
class ExceptionController : ErrorController {

    private lateinit var errorAttributes: ErrorAttributes

    @Autowired
    private lateinit var serverProperties: ServerProperties


    /**
     * 初始化ExceptionController
     * @param errorAttributes
     */
    @Autowired
    constructor(errorAttributes: ErrorAttributes) {
        Assert.notNull(errorAttributes, "ErrorAttributes must not be null")
        this.errorAttributes = errorAttributes
    }


    /**
     * 定义404的ModelAndView
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(produces = arrayOf("text/html"), value = "404")
    fun errorHtml404(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        response.setStatus(getStatus(request).value())
        val model: Map<String, Any> = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML))
        return ModelAndView("/error/404.html", model)
    }

    /**
     * 定义404的JSON数据
     * @param request
     * @return
     */
    @RequestMapping(value = "404")
    @ResponseBody
    fun error404(request: HttpServletRequest): ResponseEntity<Map<String, Any>> {
        val body: Map<String, Any> = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML))
        val status: HttpStatus = getStatus(request)
        return ResponseEntity<Map<String, Any>>(body, status)
    }

    /**
     * 定义500的ModelAndView
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(produces = arrayOf("text/html"), value = "500")
    fun errorHtml500(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        response.setStatus(getStatus(request).value())
        val model: Map<String, Any> = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML))
        return ModelAndView("error/500", model)
    }


    /**
     * 定义500的错误JSON信息
     * @param request
     * @return
     */
    @RequestMapping(value = "500")
    @ResponseBody
    fun error500(request: HttpServletRequest): ResponseEntity<Map<String, Any>> {
        val body: Map<String, Any> = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.TEXT_HTML))
        val status: HttpStatus = getStatus(request)
        return ResponseEntity<Map<String, Any>>(body, status)
    }


    /**
     * Determine if the stacktrace attribute should be included.
     * @param request the source request
     * @param produces the media type produced (or {@code MediaType.ALL})
     * @return if the stacktrace attribute should be included
     */
    protected fun isIncludeStackTrace(request: HttpServletRequest,
                                      produces: MediaType): Boolean {
        val include: ErrorProperties.IncludeStacktrace = this.serverProperties.getError().getIncludeStacktrace()
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request)
        }
        return false
    }


    /**
     * 获取错误的信息
     * @param request
     * @param includeStackTrace
     * @return
     */
    private fun getErrorAttributes(request: HttpServletRequest, includeStackTrace: Boolean): Map<String, Any> {
        val requestAttributes: RequestAttributes = ServletRequestAttributes(request)
        return this.errorAttributes.getErrorAttributes(requestAttributes as WebRequest?,
                includeStackTrace)
    }

    /**
     * 是否包含trace
     * @param request
     * @return
     */
    private fun getTraceParameter(request: HttpServletRequest): Boolean {
        val parameter: String = request.getParameter("trace") ?: return false
        return !"false".equals(parameter.toLowerCase())
    }

    /**
     * 获取错误编码
     * @param request
     * @return
     */
    private fun getStatus(request: HttpServletRequest): HttpStatus {
        val statusCode: Int = request.getAttribute("javax.servlet.error.status_code") as Int ?: return HttpStatus.INTERNAL_SERVER_ERROR
        try {
            return HttpStatus.valueOf(statusCode)
        } catch (ex: Exception) {
            return HttpStatus.INTERNAL_SERVER_ERROR
        }
    }

    override fun getErrorPath(): String {
        return ""
    }

}