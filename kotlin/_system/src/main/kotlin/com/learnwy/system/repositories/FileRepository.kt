package com.learnwy.system.repositories

import com.learnwy.system.dto.File
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface FileRepository : CrudRepository<File, Long> {
    fun findAll(pageRequest: Pageable): Page<File>
}