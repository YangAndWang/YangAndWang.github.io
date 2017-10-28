package com.learnwy.kotlinSpringBoot.system.controllers

import com.learnwy.kotlinSpringBoot.Request
import com.learnwy.kotlinSpringBoot.Response
import com.learnwy.kotlinSpringBoot.system.data.User
import com.learnwy.kotlinSpringBoot.system.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/system/user"))
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository;

    @RequestMapping(path = arrayOf("/query"))
    fun query(req: Request<User>): Response<User> {
        return Response<User>().setData(userRepository.findAll(req.getPage()))
    }
}