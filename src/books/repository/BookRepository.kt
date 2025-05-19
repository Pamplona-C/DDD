package books.repository

import books.domain.Book
import books.domain.BookRequestDto

class BookRepository {

    private val books = mutableListOf<Book>()

    fun addBook(book : BookRequestDto) : Book {
        val book = Book(book.nome, book.category)

        books.add(book)

        return book
    }

    fun getAll() {
        books.forEach {
            println(it)
        }
    }



}
