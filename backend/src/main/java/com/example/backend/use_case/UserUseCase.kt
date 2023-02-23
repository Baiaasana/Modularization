package com.example.backend.use_case

import com.example.backend.data.UserModel
import com.example.backend.repository.UserRepository

class UserUseCase(private val userRepository: UserRepository) {

    fun invoke(): List<UserModel> {

        return userRepository.getUserList()

    }
}