package estudos.kotlin.Objects.callisthenics.service

import estudos.kotlin.Objects.callisthenics.domain.Book
import estudos.kotlin.Objects.callisthenics.domain.dto.BookRequestDto
import org.springframework.stereotype.Service
import estudos.kotlin.Objects.callisthenics.repository.BookRepository
import jakarta.transaction.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    @Transactional
    fun createBook(book: BookRequestDto): Book {

        println("Livro recebido ${book.title} do autor ${book.author} no ano ${book.year}")

        val newBook = Book(
            title = book.title,
            author = book.author,
            year = book.year
        )
        val savedBook = bookRepository.save(newBook)
        println("Livro salvo com sucesso: ${savedBook}")
        return savedBook
    }

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book? {
        return bookRepository.findById(id).orElse(null)
    }
}
