package com.example.usecasesexample.domain.usecase

import com.example.usecasesexample.domain.model.Username
import com.example.usecasesexample.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): Username {
        return userRepository.getName()
    }
}