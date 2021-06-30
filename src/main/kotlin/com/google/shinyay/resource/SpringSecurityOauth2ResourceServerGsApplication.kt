package com.google.shinyay.resource

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSecurityOauth2ResourceServerGsApplication

fun main(args: Array<String>) {
	runApplication<SpringSecurityOauth2ResourceServerGsApplication>(*args)
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this::class.java)