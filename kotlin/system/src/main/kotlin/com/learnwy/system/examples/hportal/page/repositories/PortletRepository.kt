package com.learnwy.system.user.repositories

import com.learnwy.system.examples.hportal.page.dto.Portlet
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface PortletRepository : CrudRepository<Portlet, Long> {
    fun findAll(pageRequest: Pageable): Page<Portlet>;
    fun findAllByPageId(pageId: Long): List<Portlet>;
}