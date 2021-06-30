package com.google.shinyay.resource.service

import com.google.shinyay.resource.model.Employee
import com.google.shinyay.resource.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(val repository: EmployeeRepository) {

    fun findEmployeeById(id: Long) = repository.findById(id)

    fun saveEmployee(employee: Employee) = repository.save(employee)

    fun removeEmployee(id: Long) = repository.deleteById(id)
}