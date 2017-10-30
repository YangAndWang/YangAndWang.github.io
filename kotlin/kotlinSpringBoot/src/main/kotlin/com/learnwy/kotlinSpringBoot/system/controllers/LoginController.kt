package com.learnwy.kotlinSpringBoot.system.controllers

import com.learnwy.kotlinSpringBoot.Request
import com.learnwy.kotlinSpringBoot.system.data.User
import com.learnwy.kotlinSpringBoot.system.services.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView
import javax.servlet.http.HttpSession
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path = arrayOf("/login"))
class LoginController {
    companion object {
        var logger: Logger = LoggerFactory.getLogger(LoginController::class.java);
    }

    @Autowired
    lateinit var loginService: LoginService;

    @RequestMapping(path = arrayOf(), method = arrayOf(RequestMethod.POST))
    fun login(httpSession: HttpSession, @RequestBody req: Request<User>) {
        if (loginService.login(req.data, httpSession)) {
//            RedirectView("/index")
        } else {
//            RedirectView("/login");
        };
    }

    @RequestMapping(path = arrayOf(), method = arrayOf(RequestMethod.GET))
    fun loginView(httpSession: HttpSession): String {
        return "login";
    }
}