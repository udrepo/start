package com.monday.start.controllers

import com.monday.start.domain.entities.User
import com.monday.start.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    val userRepository: UserRepository
) {

    // Create a new user
    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = userRepository.save(user)
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    // Get all users
    @GetMapping
    fun getAllUsers(): ResponseEntity<MutableList<User?>> {
        val users = userRepository.findAll()
        return ResponseEntity(users, HttpStatus.OK)
    }

    // Get a user by ID
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            ResponseEntity(user.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // Update a user
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody updatedUser: User): ResponseEntity<User> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            val existingUser = user.get()
            existingUser.name = updatedUser.name
            existingUser.password = updatedUser.password
            val savedUser = userRepository.save(existingUser)
            ResponseEntity(savedUser, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    // Delete a user
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Void> {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
