package com.google.shinyay.resource.repository

import com.google.shinyay.resource.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

//interface EmployeeRepository : PagingAndSortingRepository<Employee, Long>
interface EmployeeRepository : JpaRepository<Employee, Long>