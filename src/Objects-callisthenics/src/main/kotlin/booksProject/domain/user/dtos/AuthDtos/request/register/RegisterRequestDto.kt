package booksProject.domain.user.dtos.AuthDtos.request.register

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequestDto(

    @field:NotBlank(message = "Username não pode ser nulo.")
    val username: String,

    @field:Email(message = "Email deve ser válido.")
    @field:NotBlank(message = "Email não pode ser nulo.")
    val email: String,

    @field:NotBlank(message = "Password não pode ser nulo.")
    @field:Size(min = 6, message = "Password deve ter pelo menos 6 caracteres.")
    val password: String,
) {
}
