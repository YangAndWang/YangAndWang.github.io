package com.learnwy.system.user.services

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.user.dto.User

interface UserService {
    fun selectAll(page: ResquestPage): List<User>;
}