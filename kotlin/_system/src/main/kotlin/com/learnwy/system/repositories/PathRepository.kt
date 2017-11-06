package com.learnwy.system.repositories
import com.learnwy.system.dto.Path
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface PathRepository : CrudRepository<Path, Long>{
	fun findAll(pageRequest: Pageable): Page<Path>
}