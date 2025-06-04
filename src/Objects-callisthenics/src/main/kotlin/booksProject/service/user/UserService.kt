package booksProject.service.user

import booksProject.domain.user.User
import booksProject.domain.user.dtos.UserRequestDto
import booksProject.domain.user.dtos.UserResponseDto
import booksProject.repository.user.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(user : UserRequestDto) : ResponseEntity<User> {

        val userName = user.username ?: throw IllegalArgumentException("Username is required")

        val userExist = userRepository.findByUsername(userName)

        if (userExist == true) {
            return throw IllegalArgumentException("Usuário ja existe")
        }
        val newUser = User(
            username = user.username ?: throw IllegalArgumentException("Username is required"),
            email = user.email ?: throw IllegalArgumentException("Email is required"),
            password = user.password ?: throw IllegalArgumentException("Password is required")
        )
        userRepository.save(newUser)
        return ResponseEntity.ok(newUser)
    }

    fun getAllUsers(): List<UserResponseDto> {
        return userRepository.findAll()
            .sortedBy { it.id }
            .map { user -> UserResponseDto(
                id = user.id ?: throw IllegalArgumentException("ID não pode ser nulo"),
                username = user.username ?: throw IllegalArgumentException("Username não pode ser nulo"),
                email = user.email ?: throw IllegalArgumentException("Email não pode ser nulo"),
                isActive = user.isActive ?: throw IllegalArgumentException("isActive não pode ser nulo")
            ) }
    }

    fun getUserById(id: Long): User? {
        if (id <= 0) {
            throw IllegalArgumentException("ID must be greater than 0")
        }
        return userRepository.findById(id).orElse(null).also {
            if (it == null) {
                println("Usuário com ID $id não encontrado.")
            } else {
                return it
            }
        }
    }

    fun deleteUser(id : Long): User? {
        if (id <= 0) {
            throw IllegalArgumentException("ID must be greater than 0")
        }
        return userRepository.findById(id).orElse(null)?.also {
            userRepository.delete(it)
            println("Usuário com ID $id deletado com sucesso.")
        } ?: throw IllegalArgumentException("Usuário com ID $id não encontrado.")
    }

    fun updateUserActive(id : Long): UserResponseDto? {
        if (id <= 0) {
            throw IllegalArgumentException("ID must be greater than 0")
        }
        val user = userRepository.findById(id).orElse(null) ?: throw IllegalArgumentException("Usuário com ID $id não encontrado.")

        user.isActive = !user.isActive

        val updatedUser = userRepository.save(user)

        return UserResponseDto(
            id = updatedUser.id ?: throw IllegalArgumentException("ID não pode ser nulo"),
            username = updatedUser.username ?: throw IllegalArgumentException("Username não pode ser nulo"),
            email = updatedUser.email ?: throw IllegalArgumentException("Email não pode ser nulo"),
            isActive = updatedUser.isActive
        )

    }
}
