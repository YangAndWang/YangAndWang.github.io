package com.learnwy.blog.controllers

import com.learnwy.blog.pos.Role
import com.learnwy.blog.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(path = arrayOf("/role"))
class RoleController {
    @Autowired
    lateinit var roleRepository: RoleRepository

    @GetMapping(path = arrayOf("/query"))
    fun query(): List<Role> {
        return roleRepository.findAll() as List<Role>
    }

    @PutMapping(path = arrayOf("/submit"))
    fun submit(roles: MutableList<Role>): MutableList<Role> {
        return roleRepository.saveAll(roles) as MutableList<Role>
    }

    @GetMapping(path = arrayOf("/type"))
    fun type() :Map<String,String>{
        return Role.toTableColumns()
    }

}