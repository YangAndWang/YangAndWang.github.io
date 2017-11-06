package com.learnwy.system.services.impl

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.Path
import com.learnwy.system.repositories.PathRepository
import com.learnwy.system.services.BaseServiceQuery
import com.learnwy.system.services.PathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PathServiceImpl(@Autowired override val repository: PathRepository) : PathService, BaseServiceQuery<Path, Long> {
	override fun selectAll(page: ResquestPage): List<Path> {
		val pageRequest: PageRequest = PageRequest.of(page.page, page.pageSize)
		val pages: Page<Path> = repository.findAll(pageRequest)
		page.totalPages = pages.totalPages
		page.total = pages.numberOfElements
		return pages.content
	}
}