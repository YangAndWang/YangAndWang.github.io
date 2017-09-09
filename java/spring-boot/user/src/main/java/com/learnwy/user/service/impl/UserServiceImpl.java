package com.learnwy.user.service.impl;

import com.learnwy.user.com.learnwy.user.dao.UserRepository;
import com.learnwy.user.modal.UserModal;
import com.learnwy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserModal> findByUserLoginNameAndUserPassword(String userLoginName, String userPassword) {
        return userRepository.findByUserLoginNameAndUserPassword(userLoginName, userPassword);
    }
}
