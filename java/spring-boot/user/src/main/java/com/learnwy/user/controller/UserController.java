package com.learnwy.user.controller;

import com.learnwy.user.com.learnwy.user.dao.UserRepository;
import com.learnwy.user.modal.UserModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = {"/add"}, method = {RequestMethod.POST})
    public Iterable<UserModal> add(@RequestBody List<UserModal> users) {
        return userRepository.save(users);
    }

    @RequestMapping(path = {"/update"}, method = {RequestMethod.PUT})
    public Iterable<UserModal> update(@RequestBody List<UserModal> users) {
        return userRepository.save(users);
    }

    @RequestMapping(path = {"/delete"}, method = {RequestMethod.DELETE})
    public Iterable<UserModal> delete(@RequestBody List<UserModal> users) {
        userRepository.delete(users);
        return users;
    }

    @RequestMapping(path = {"/get"}, method = {RequestMethod.GET})
    public Iterable<UserModal> get(@RequestBody UserModal user) {
        return userRepository.findAll();
    }
}
