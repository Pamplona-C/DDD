package estudos.kotlin.Objects.callisthenics.controller

import estudos.kotlin.Objects.callisthenics.domain.Book
import estudos.kotlin.Objects.callisthenics.domain.dto.BookRequestDto
import estudos.kotlin.Objects.callisthenics.repository.BookRepository
import estudos.kotlin.Objects.callisthenics.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService
) {

    @GetMapping
    fun getAllBooks() = bookService.getAllBooks()

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long) = bookService.getBookById(id)

    @PostMapping("/create")
    fun createBook(book: BookRequestDto) = bookService.createBook(book)

}

