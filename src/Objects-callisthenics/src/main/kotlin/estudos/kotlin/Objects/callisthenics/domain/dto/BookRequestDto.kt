package estudos.kotlin.Objects.callisthenics.domain.dto

data class BookRequestDto(
    val id : Long,
    val title: String? = null,
    val author: String? = null,
    val year: Int? = null,
    val isRead: Boolean? = false
)
