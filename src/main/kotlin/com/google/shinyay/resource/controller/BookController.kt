package com.google.shinyay.resource.controller

import com.google.shinyay.resource.model.Book
import com.google.shinyay.resource.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class BookController(val repository: BookRepository) {

    @GetMapping
    fun info() = "Spring Data JPA for Books"

    @GetMapping("/books")
    fun findAllBooks(): ResponseEntity<MutableList<Book>> {
        val books = repository.findAll()
        if (books.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity(books, HttpStatus.OK)
    }

    @PostMapping("/books")
    fun addNewBook(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity(repository.save(book), HttpStatus.OK)
    }

}