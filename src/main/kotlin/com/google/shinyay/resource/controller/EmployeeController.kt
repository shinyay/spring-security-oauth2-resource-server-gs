package com.google.shinyay.resource.controller

import com.google.shinyay.resource.exception.EmployeeNotFoundException
import com.google.shinyay.resource.model.Employee
import com.google.shinyay.resource.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class EmployeeController(val service: EmployeeService) {

    @GetMapping("/employees")
    fun findAll() = service.findAll()

    @GetMapping("/employees/{id}")
    fun findOne(@PathVariable id: Long): Employee = service.findEmployeeById(id).orElseThrow { EmployeeNotFoundException(id) }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerEmployee(@RequestBody employee: Employee) = service.saveEmployee(employee)
}