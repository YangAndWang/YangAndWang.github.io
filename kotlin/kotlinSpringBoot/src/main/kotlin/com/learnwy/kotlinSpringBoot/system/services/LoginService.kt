package com.learnwy.kotlinSpringBoot.system.services

import com.learnwy.kotlinSpringBoot.system.data.User
import com.learnwy.kotlinSpringBoot.system.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.SessionAttributes
import javax.servlet.http.HttpSession

@Service
class LoginService {
    @Autowired
    lateinit var userRepository: UserRepository;

    fun login(user: User?, session: HttpSession): Boolean {
        var u: User? = userRepository.findById(user?.id ?: -1).orElseGet { -> null };
        if (u === null) {
            return false;
        }
        if (u.name != (user?.name ?: null)) {
            return false;
        }
        session.setAttribute("user", u);
        return true;
    }
}