package com.learnwy.admin.user.service;

import com.learnwy.admin.user.model.User;
import com.learnwy.admin.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date 2017/8/25
 * create by learnwy
 * lis is GPL-3.0
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
