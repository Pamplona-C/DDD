package booksProject.domain.user.dtos.AuthDtos.response

import booksProject.domain.user.dtos.UserResponseDto

data class AuthReponseDto(
    val token : String,
    val type: String = "Bearer",
    val user : UserResponseDto
)
