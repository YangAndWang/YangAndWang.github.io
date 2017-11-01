package com.learnwy.system.user.controllers

import com.learnwy.system.commom.FileMap
import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.commom.Response
import com.learnwy.system.user.dto.User
import com.learnwy.system.user.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpSession

@RestController()
@RequestMapping(path = arrayOf("/system/user"))
class UserController {

    @Autowired
    lateinit var userService: UserService;

    @CrossOrigin(origins = arrayOf("*"))
    @GetMapping(path = arrayOf("/query"))
    fun getUsers(httpSession: HttpSession, page: ResquestPage): Response<User> {
        val ret: Response<User> = Response<User>();
        ret.rows = userService.selectAll(page);
        ret.setPage(page);
        ret.success = true;
        return ret;
    }
}