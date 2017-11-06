package com.learnwy.system.services.impl

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.po.File
import com.learnwy.system.repositories.FileRepository
import com.learnwy.system.services.BaseServiceQuery
import com.learnwy.system.services.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FileServiceImpl(@Autowired override val repository: FileRepository) : FileService, BaseServiceQuery<File, Long> {
	override fun selectAll(page: ResquestPage): List<File> {
		val pageRequest: PageRequest = PageRequest.of(page.page, page.pageSize)
		val pages: Page<File> = repository.findAll(pageRequest)
		page.totalPages = pages.totalPages
		page.total = pages.numberOfElements
		return pages.content
	}
}