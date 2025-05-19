package books.controller

import books.domain.BookRequestDto
import books.service.BookService

class BookController {

    val bookService = BookService()

    fun criarBook(dto : BookRequestDto){

        bookService.criaBook(dto)
    }

    fun getAllBooks(){
        bookService.getAllBooks()
    }
}
