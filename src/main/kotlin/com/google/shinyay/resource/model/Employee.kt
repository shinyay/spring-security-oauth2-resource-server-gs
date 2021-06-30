package com.google.shinyay.resource.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Employee(
    @Id
    val id: Long,
    val name: String
)