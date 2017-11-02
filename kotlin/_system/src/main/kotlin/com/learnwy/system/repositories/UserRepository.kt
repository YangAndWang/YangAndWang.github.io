package com.learnwy.system.repositories

import com.learnwy.system.dto.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findAll(pageRequest: Pageable): Page<User>;
}