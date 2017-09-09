package com.learnwy.login.controller;

import com.learnwy.UserMain;
import com.learnwy.response.Message;
import com.learnwy.user.modal.UserModal;
import com.learnwy.user.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(path = {""}, method = {RequestMethod.POST})
    public Message login(@RequestBody Map<String, String> nameAndPassword) {
        List<UserModal> users = userService.findByUserLoginNameAndUserPassword(nameAndPassword.get("userName"), nameAndPassword.get("password"));
        if (users.size() == 0) {
            return Message.successMessage("登录失败:用户名或密码错误");
        }
        return Message.successMessage("登录成功");
    }
}
