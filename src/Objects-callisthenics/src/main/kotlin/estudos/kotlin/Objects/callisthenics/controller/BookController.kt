package estudos.kotlin.Objects.callisthenics.controller

import estudos.kotlin.Objects.callisthenics.domain.Book
import estudos.kotlin.Objects.callisthenics.domain.dto.BookRequestDto
import estudos.kotlin.Objects.callisthenics.repository.BookRepository
import estudos.kotlin.Objects.callisthenics.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService,
) {
    @GetMapping
    fun getAllBooks(): List<Book> {
        val books = bookService.getAllBooks()
        println("Books from DB: $books") // Verifique no console se os dados estão corretos
        return books
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long) = bookService.getBookById(id)

    @PostMapping("/create")
    fun createBook(@RequestBody book: BookRequestDto) = bookService.createBook(book)

    @PutMapping("/update")
    fun updateBook(@RequestBody updateBook : BookRequestDto) = bookService.updateBook(updateBook)

    @PutMapping("/updateRead/{id}")
    fun updateRead(@RequestParam id : Long, @RequestParam isRead : Boolean) = bookService.updateRead(id,isRead)

}

