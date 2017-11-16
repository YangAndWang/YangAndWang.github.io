package com.learnwy.system.services

import com.learnwy.system.pos.User

interface UserService {
    fun findUserById(): User?
}