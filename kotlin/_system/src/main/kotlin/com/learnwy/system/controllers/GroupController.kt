package com.learnwy.system.controllers;

import com.learnwy.system.commom.Response
import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.Group
import com.learnwy.system.services.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpSession



@RestController()
@RequestMapping(path = arrayOf("/system/group"))
class GroupController {
    @Autowired
    lateinit var groupService: GroupService

    @CrossOrigin(origins = arrayOf("*"))
    @GetMapping(path = arrayOf("/query"))
    fun getGroups(httpSession: HttpSession, page: ResquestPage): Response<Group> {
        val ret: Response<Group> = Response<Group>();
        ret.rows = groupService.selectAll(page);
        ret.setPage(page);
        ret.success = true;
        return ret;
    }
}