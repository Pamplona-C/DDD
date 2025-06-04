package booksProject.domain.Book.dto

data class BookResponseDto(
    val id: Long,
    val title: String?= null,
    val author: String?= null,
    val year: Int?= null,
    val isRead: Boolean? = false
) {
}
