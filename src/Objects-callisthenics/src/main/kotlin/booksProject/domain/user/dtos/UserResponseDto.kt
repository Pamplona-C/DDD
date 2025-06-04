package booksProject.domain.user.dtos


data class UserResponseDto(
    val id: Long,
    val username: String? = null,
    val email: String? = null,
    val isActive : Boolean?,
) {
}
