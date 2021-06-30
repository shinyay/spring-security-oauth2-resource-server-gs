package com.google.shinyay.resource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSecurityOauth2ResourceServerGsApplication

fun main(args: Array<String>) {
	runApplication<SpringSecurityOauth2ResourceServerGsApplication>(*args)
}
