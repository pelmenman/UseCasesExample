package com.example.usecasesexample.domain.usecase

import com.example.usecasesexample.domain.model.SaveUsername
import com.example.usecasesexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUsername): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }
        return userRepository.saveName(saveParam = param)
    }
}