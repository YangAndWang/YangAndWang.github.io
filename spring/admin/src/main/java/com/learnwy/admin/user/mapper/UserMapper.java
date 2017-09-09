package com.learnwy.admin.user.mapper;

import com.learnwy.admin.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date 2017/8/25
 * create by learnwy
 * lis is GPL-3.0
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user where id = #{id}")
    User selectUserById(long id);
}
