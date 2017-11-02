package com.learnwy.system.examples.hportal.page.controllers

import com.learnwy.system.commom.Response
import com.learnwy.system.examples.hportal.page.dto.Portlet
import com.learnwy.system.examples.hportal.page.service.PortletService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = arrayOf("/portlet"))
class PageController {
    var objectVersionNumber: Long = 1;
    @Autowired
    lateinit var portletService: PortletService

    @GetMapping(path = arrayOf("/query"))
    fun queryAllPortletByPageId(@RequestParam(name = "pageId") pageId: Long): Response<Portlet> {
        val ret = Response<Portlet>()
        ret.rows = portletService.findAll(pageId);
        ret.total = ret.rows.size;
        ret.success = true;
        return ret;
    }

    @PostMapping(path = arrayOf("/submit"))
    fun submit(@RequestBody rows: MutableList<Portlet>): MutableList<Portlet> {
        return portletService.save(rows);
    }


}