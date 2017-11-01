package com.learnwy.system.user.services.impl

import com.learnwy.system.commom.ResquestPage
import com.learnwy.system.user.dto.User
import com.learnwy.system.user.repositories.UserRepository
import com.learnwy.system.user.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserServiceImpl() : UserService {
    @Autowired
    lateinit var userRepository: UserRepository;

    override fun selectAll(page: ResquestPage): List<User> {
        var pageRequest: PageRequest = PageRequest.of(page.page, page.pageSize);
        var pages: Page<User> = userRepository.findAll(pageRequest);
        page.totalPages = pages.totalPages;
        page.total = pages.numberOfElements;
        return pages.content;
    };
}