package booksProject.controller.book

import booksProject.domain.Book.dto.BookRequestDto
import booksProject.domain.Book.dto.BookResponseDto
import booksProject.service.book.BookService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService,
) {
    @GetMapping
    @Operation(summary = "Get all books")
    fun getAllBooks(): List<BookResponseDto> {
        val books = bookService.getAllBooks()
        println("Books from DB: $books")
        return books
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID")
    fun getBookById(@PathVariable id: Long) = bookService.getBookById(id)

    @PostMapping("/create")
    @Operation(summary = "Create a new book")
    fun createBook(@RequestBody book: BookRequestDto) = bookService.createBook(book)

    @PutMapping("/update")
    @Operation(summary = "Update an existing book")
    fun updateBook(@RequestParam id : Long, @RequestBody updateBook : BookRequestDto) = bookService.updateBook(id,updateBook)

    @PutMapping("/updateRead/{id}")
    @Operation(summary = "Update the read status of a book")
    fun updateRead(@RequestParam id : Long, @RequestParam isRead : Boolean) = bookService.updateRead(id,isRead)

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Delete a book by ID")
    fun deleteBook(@RequestParam id : Long) = bookService.deleteBookById(id)

}

