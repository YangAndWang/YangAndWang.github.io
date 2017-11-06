package com.learnwy.system.services
import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.Path

interface PathService {
	fun selectAll(page: ResquestPage): List<Path>
}