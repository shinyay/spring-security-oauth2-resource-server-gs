package com.google.shinyay.resource.service

import com.google.shinyay.resource.logger
import com.google.shinyay.resource.model.Employee
import com.google.shinyay.resource.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeService(val repository: EmployeeRepository) {

    fun findAll(): MutableIterable<Employee> = repository.findAll()

    fun findEmployeeById(id: Long): Optional<Employee> {
        logger.info("Employee ID: $id")
        return repository.findById(id)
    }

    fun saveEmployee(employee: Employee): Employee {
        logger.info("Employee: $employee")
        return repository.save(employee)
    }

    fun removeEmployee(id: Long) {
        logger.info("Employee ID: $id")
        return repository.deleteById(id)
    }
}