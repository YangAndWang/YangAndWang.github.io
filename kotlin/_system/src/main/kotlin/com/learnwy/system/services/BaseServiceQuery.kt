package com.learnwy.system.services

import org.springframework.data.repository.CrudRepository
import java.util.*

interface BaseServiceQuery<DTO, ID> {
    val repository: CrudRepository<DTO, ID>

    fun select(id: ID): DTO? {
        return repository.findById(id).orElse(null)
    }

    fun selectAll(): List<DTO> {
        return repository.findAll().toList()
    }

    fun update(dtos: List<DTO>) {
        repository.saveAll(dtos)
    }

    fun insert(dto: DTO): DTO {
        return repository.save(dto)
    }

    fun delete(dto: DTO) {
        repository.delete(dto)
    }

    fun deleteById(id: ID) {
        repository.deleteById(id)
    }
}