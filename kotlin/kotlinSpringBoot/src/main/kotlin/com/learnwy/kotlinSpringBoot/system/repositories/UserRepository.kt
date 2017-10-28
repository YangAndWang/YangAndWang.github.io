package com.learnwy.kotlinSpringBoot.system.repositories

import com.learnwy.kotlinSpringBoot.system.data.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findAll(pageable: Pageable): Page<User>;
}