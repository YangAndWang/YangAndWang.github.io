package com.learnwy.system

import com.learnwy.system.commom.SystemConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping(path = arrayOf("/"), method = arrayOf<RequestMethod>(
        RequestMethod.GET,
        RequestMethod.HEAD,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.PATCH,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.TRACE
))
class SystemController {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(SystemController::class.java);
    }

    @RequestMapping(path = arrayOf("*"), method = arrayOf(RequestMethod.GET,
            RequestMethod.HEAD,
            RequestMethod.POST,
            RequestMethod.PUT,
            RequestMethod.PATCH,
            RequestMethod.DELETE,
            RequestMethod.OPTIONS,
            RequestMethod.TRACE))
    fun root(httpServletRequest: HttpServletRequest, redirectAttributes: RedirectAttributes): String {
        var ls = arrayOfNulls<String?>(3);
        var _path = httpServletRequest.requestURI;

        logger.info("access Path : ${_path}");
        var mapPath: String? = null;
        for (fileMap in SystemConfig.fileMaps) {
            ls[0] = fileMap.mapSuffix(_path);
            ls[1] = fileMap.mapPrefix(_path);
            ls[2] = fileMap.map(_path);
            mapPath = ls.first { it -> it !== null };
        }
        if (mapPath != _path) {
            return "redirect:${mapPath}";
        } else {
            return "redirect:${_path}";
        }
    }
}