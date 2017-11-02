package com.learnwy.system.services

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.User

interface UserService {
    fun selectAll(page: ResquestPage): List<User>;
}