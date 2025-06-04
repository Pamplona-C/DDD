package booksProject.domain.Book

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var year: Int? = null,
    var isRead : Boolean? = false,
)
