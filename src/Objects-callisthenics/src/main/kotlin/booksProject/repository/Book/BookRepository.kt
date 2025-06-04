package booksProject.repository.Book
import org.springframework.data.jpa.repository.JpaRepository;
import booksProject.domain.Book.Book

import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}
