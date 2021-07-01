package com.google.shinyay.resource.exception

class EmployeeNotFoundException : RuntimeException {
    constructor(id: Long) : super("Not Found Employee: $id")
}