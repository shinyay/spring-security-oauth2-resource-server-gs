package com.google.shinyay.resource.service

import com.google.shinyay.resource.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(val repository: EmployeeRepository) {
}