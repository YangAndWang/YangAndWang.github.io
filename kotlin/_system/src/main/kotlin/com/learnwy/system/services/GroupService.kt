package com.learnwy.system.services

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.Group

interface GroupService {
    fun selectAll(page: ResquestPage): List<Group>;
}