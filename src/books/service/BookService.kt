package books.service

import books.domain.BookRequestDto
import books.repository.BookRepository

class BookService {

    val repository = BookRepository()

    fun criaBook(dto : BookRequestDto){

        repository.addBook(dto)

    }

    fun getAllBooks(){
        repository.getAll()
    }
}
