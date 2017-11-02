package com.learnwy.system.repositories

import com.learnwy.system.dto.Group
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface GroupRepository : CrudRepository<Group, Long> {
    fun findAll(pageRequest: Pageable): Page<Group>;
}