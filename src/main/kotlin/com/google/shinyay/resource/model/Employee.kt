package com.google.shinyay.resource.model

import javax.persistence.*

@Entity
@Table(name = "employee")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String
)