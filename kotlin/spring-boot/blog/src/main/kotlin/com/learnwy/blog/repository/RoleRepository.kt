package com.learnwy.blog.repository

import com.learnwy.blog.pos.Role
import org.springframework.data.repository.CrudRepository

interface RoleRepository : CrudRepository<Role, Long> {

}