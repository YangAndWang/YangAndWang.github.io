package com.learnwy.system.services
import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.po.File

interface FileService {
	fun selectAll(page: ResquestPage): List<com.learnwy.system.po.File>;
}