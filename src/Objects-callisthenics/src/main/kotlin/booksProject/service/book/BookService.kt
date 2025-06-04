package booksProject.service.book

import booksProject.domain.Book.Book
import booksProject.domain.Book.dto.BookRequestDto
import booksProject.domain.Book.dto.BookResponseDto
import org.springframework.stereotype.Service
import booksProject.repository.Book.BookRepository
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    @Transactional
    fun createBook(book: BookRequestDto): Book {

        println("Livro recebido ${book.title} do autor ${book.author} no ano ${book.year}")

        val newBook = Book(
            title = book.title?: throw IllegalArgumentException("O título não pode ser nulo"),
            author = book.author?: throw IllegalArgumentException("O autor não pode ser nulo"),
            year = book.year?: throw IllegalArgumentException("O título não pode ser nulo"),
            isRead = book.isRead ?: false
        )
        val savedBook = bookRepository.save(newBook)
        println("Livro salvo com sucesso: ${savedBook}")
        return savedBook
    }

fun getAllBooks(): List<BookResponseDto> {
    return bookRepository.findAll().sortedBy { it.id }
        .map { Book ->
            BookResponseDto(
                id = Book.id ?: throw IllegalArgumentException("ID não pode ser nulo"),
                title = Book.title ?: throw IllegalArgumentException("Título não pode ser nulo"),
                author = Book.author ?: throw IllegalArgumentException("Autor não pode ser nulo"),
                year = Book.year ?: throw IllegalArgumentException("Ano não pode ser nulo"),
                isRead = Book.isRead ?: false
            )
        }
}

    fun getBookById(id: Long): Book? {
        if (id <= 0) {
            throw IllegalArgumentException("ID must be greater than 0")
        }
        return bookRepository.findById(id).orElse(null).also {
            if (it == null) {
                println("Livro com ID $id não encontrado.")
            } else {
                return it
            }
        }
    }

    fun deleteBookById(id: Long) : Book? {
        if (id <= 0) {
            throw IllegalArgumentException("ID precisa ser maior que 0")
        }
        if (!bookRepository.existsById(id)) {
            throw IllegalArgumentException("Livro não existe !")
        }

        val bookDeleted = bookRepository.findById(id).orElse(null)

        bookRepository.deleteById(id)

        return bookDeleted

    }

    fun updateBook(id : Long, book: BookRequestDto): Book {
        val existingBook = bookRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado") }

        existingBook.apply {
            title = book.title ?: title
            author = book.author ?: author
            year = book.year ?: year
            isRead = book.isRead ?: isRead
        }

        return bookRepository.save(existingBook)
    }

    fun updateRead(id:Long, read : Boolean) : Book? {
        val existingBook = bookRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado") }

        existingBook.apply {
            isRead = read
        }

        return bookRepository.save(existingBook)
    }
}
