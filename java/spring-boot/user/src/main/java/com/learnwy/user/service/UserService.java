package com.learnwy.user.service;

import com.learnwy.user.modal.UserModal;
import org.springframework.data.repository.CrudRepository;

import javax.jws.WebService;
import java.util.List;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
public interface UserService {
    List<UserModal> findByUserLoginNameAndUserPassword(String userLoginName, String userPassword);
}
