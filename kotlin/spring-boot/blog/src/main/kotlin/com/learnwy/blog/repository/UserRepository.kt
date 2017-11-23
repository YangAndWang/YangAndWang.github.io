package com.learnwy.blog.repository

import com.learnwy.blog.pos.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

}