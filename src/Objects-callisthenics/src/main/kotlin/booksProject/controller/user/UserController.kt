package booksProject.controller.user

import booksProject.domain.user.dtos.UserRequestDto
import booksProject.service.user.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

//     Endpoint to create a new user
     @PostMapping("/create")
     fun createUser(@RequestBody user: UserRequestDto) = userService.createUser(user)

//     Endpoint to get all users
     @GetMapping
     fun getAllUsers() = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long) = userService.getUserById(id)

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)

    @PutMapping("/update/{id}")
    fun updateUserActive(@PathVariable id : Long) = userService.updateUserActive(id)
}
