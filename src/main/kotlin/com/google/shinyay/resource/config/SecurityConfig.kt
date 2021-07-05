package com.google.shinyay.resource.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http
            ?.cors()
            ?.and()
            ?.authorizeRequests { authz ->
                authz
                    .antMatchers(HttpMethod.GET, "/api/v1/employees/**").hasAuthority("SCOPE_read")
                    .antMatchers(HttpMethod.POST, "/api/v1/employees").hasAuthority("SCOPE_write")
                    .anyRequest().authenticated()
            }
            ?.oauth2ResourceServer { oauth2 -> oauth2.jwt() }
    }
}