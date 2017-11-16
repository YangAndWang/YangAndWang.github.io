package com.learnwy.system.repositories

import com.learnwy.system.pos.Path
import org.springframework.data.repository.CrudRepository

interface PathRepository : CrudRepository<Path, Long> {
}