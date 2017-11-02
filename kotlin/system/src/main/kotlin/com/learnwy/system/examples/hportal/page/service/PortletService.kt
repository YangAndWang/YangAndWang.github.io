package com.learnwy.system.examples.hportal.page.service

import com.learnwy.system.examples.hportal.page.dto.Portlet


interface PortletService {

    fun findAll(pageId: Long): List<Portlet>

    fun save(rows: MutableList<Portlet>): MutableList<Portlet>;
}
