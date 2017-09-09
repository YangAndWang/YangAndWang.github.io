package com.learnwy.admin.user.dao;

import com.learnwy.admin.user.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * date 2017/8/25
 * create by learnwy
 * lis is GPL-3.0
 */
@Component
public class UserDao {
    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> findAll() {
        return this.sqlSession.selectList("findAll");
    }

    public User selectCityById(long id) {
        return this.sqlSession.selectOne("selectUserById", id);
    }
}
