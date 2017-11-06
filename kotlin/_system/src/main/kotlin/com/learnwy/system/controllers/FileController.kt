package com.learnwy.system.controllers

import com.learnwy.system.commom.Response
import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.File
import com.learnwy.system.services.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

@RestController()
@RequestMapping(path = arrayOf("/system/file"))
class FileController {
	@Autowired
	lateinit var fileService: FileService

	@GetMapping(path = arrayOf("/query"))
	fun getFiles(httpSession: HttpSession, page: ResquestPage): Response<File> {
		val ret: Response<File> = Response<File>()
		ret.rows = fileService.selectAll(page);
		ret.setPage(page);
		ret.success = true;
		return ret;
	}}