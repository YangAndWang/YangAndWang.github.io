package com.learnwy.spring.boot.demo.mvn.configs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(exceptionClasses = Exception::class)
    protected override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Autowired
    @Throws(exceptionClasses = Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth
                .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");
    }
}
