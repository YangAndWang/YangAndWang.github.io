package com.learnwy.system.controllers

import com.learnwy.system.commom.Response
import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.Path
import com.learnwy.system.services.PathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession

@RestController()
@RequestMapping(path = arrayOf("/system/path"))class PathController {
	@Autowired
	lateinit var pathService: PathService

	@GetMapping(path = arrayOf("/query"))
	fun getPaths(httpSession: HttpSession, page: ResquestPage): Response<Path> {
		val ret: Response<Path> = Response<Path>()
		ret.rows = pathService.selectAll(page)
		ret.setPage(page)
		ret.success = true
		return ret
	}}