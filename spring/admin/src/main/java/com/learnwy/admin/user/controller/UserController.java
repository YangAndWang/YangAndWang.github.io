package com.learnwy.admin.user.controller;

import com.learnwy.admin.user.constant.Const;
import com.learnwy.admin.user.model.User;
import com.learnwy.admin.user.repository.UserRepository;
import com.learnwy.admin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * date 2017/8/25
 * create by learnwy
 * lis is GPL-3.0
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/add", method = {RequestMethod.POST})
    public User addNewUser(@RequestParam String name, @RequestParam String password) {
        User user = new User();
        Date date = new Date();
        user.setName(name);
        user.setPassword(password);
        user.setCreateDate(date);
        user.setLastUpdateDate(date);
        user.setStatus(Const.ACTIVE);
        userService.save(user);
        return user;
    }

    @RequestMapping(path = "/all", method = {RequestMethod.GET})
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }
}
