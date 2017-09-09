package com.learnwy.user.com.learnwy.user.dao;

import com.learnwy.user.modal.UserModal;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * date 2017/9/4
 * create by learnwy
 * lis is GPL-3.0
 */
public interface UserRepository extends CrudRepository<UserModal, Long> {
    List<UserModal> findByUserLoginNameAndUserPassword(String userLoginName,String userPassword);
}
