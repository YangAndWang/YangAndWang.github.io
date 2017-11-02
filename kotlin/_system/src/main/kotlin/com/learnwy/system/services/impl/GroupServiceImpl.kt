package com.learnwy.system.services.impl

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.dto.Group
import com.learnwy.system.repositories.GroupRepository
import com.learnwy.system.services.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class GroupServiceImpl() : GroupService {
    @Autowired
    lateinit var groupRepository: GroupRepository;

    override fun selectAll(page: ResquestPage): List<Group> {
        var pageRequest: PageRequest = PageRequest.of(page.page, page.pageSize);
        var pages: Page<Group> = groupRepository.findAll(pageRequest);
        page.totalPages = pages.totalPages;
        page.total = pages.numberOfElements;
        return pages.content;
    };
}