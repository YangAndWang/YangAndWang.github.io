package com.learnwy.admin.user.repository;

import com.learnwy.admin.user.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * date 2017/8/25
 * create by learnwy
 * lis is GPL-3.0
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
