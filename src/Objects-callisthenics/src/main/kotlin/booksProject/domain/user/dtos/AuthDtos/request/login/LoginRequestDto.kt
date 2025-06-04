package booksProject.domain.user.dtos.AuthDtos.request.login

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LoginRequestDto(

    @field:NotBlank(message = "Username cannot be blank")
    val username: String,

    @field:NotBlank(message = "Password cannot be blank")
    @field:Size(min = 6, message = "Password deve ter pelo menos 6 carcateres.")
    val password: String
)
