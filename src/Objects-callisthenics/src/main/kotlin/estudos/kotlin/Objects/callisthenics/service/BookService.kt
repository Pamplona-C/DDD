package estudos.kotlin.Objects.callisthenics.service

import estudos.kotlin.Objects.callisthenics.domain.Book
import estudos.kotlin.Objects.callisthenics.domain.dto.BookRequestDto
import org.springframework.stereotype.Service
import estudos.kotlin.Objects.callisthenics.repository.BookRepository

@Service
class BookService {

    //modificador de visibilidade e inicializados ou marcados como lateinit se forem injetados pelo spring
    private lateinit var bookRepository: BookRepository

    fun createBook(book: BookRequestDto): Book {

        val book = Book(
            title = book.title,
            author = book.author,
            year = book.year
        )

        return bookRepository.save(book)
    }

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book? {
        return bookRepository.findById(id).orElse(null)
    }
}
