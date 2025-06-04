package booksProject.domain.user.dtos

data class UserRequestDto(
    val username: String? = null,
    val email: String? = null,
    val password: String? = null
) {
}
