package com.learnwy.system.repositories

import com.learnwy.system.pos.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}