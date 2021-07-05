package com.google.shinyay.resource.repository

import com.google.shinyay.resource.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long>