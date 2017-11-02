package com.learnwy.system.examples.hportal.page.service.impl

import com.learnwy.system.examples.hportal.page.dto.Portlet
import com.learnwy.system.examples.hportal.page.service.PortletService
import com.learnwy.system.user.repositories.PortletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PortletServiceImpl : PortletService {
    @Autowired
    lateinit var portletRepository: PortletRepository

    override fun findAll(pageId: Long): List<Portlet> {
        return portletRepository.findAllByPageId(pageId);
    }

    override fun save(rows: MutableList<Portlet>): MutableList<Portlet> {
        return portletRepository.save(rows) as MutableList<Portlet>;
    }
}