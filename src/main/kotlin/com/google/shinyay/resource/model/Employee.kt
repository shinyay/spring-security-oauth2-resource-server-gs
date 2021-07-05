package com.google.shinyay.resource.model

import javax.persistence.*

@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var name: String
)