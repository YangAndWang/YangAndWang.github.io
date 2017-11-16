package com.learnwy.system.repositories

import com.learnwy.system.pos.Group
import org.springframework.data.repository.CrudRepository

interface GroupRepository : CrudRepository<Group, Long> {
}