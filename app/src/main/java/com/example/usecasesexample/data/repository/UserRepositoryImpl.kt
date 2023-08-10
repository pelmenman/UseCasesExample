package com.example.usecasesexample.data.repository

import android.content.Context
import com.example.usecasesexample.data.storage.User
import com.example.usecasesexample.data.storage.UserStorage
import com.example.usecasesexample.domain.model.SaveUsername
import com.example.usecasesexample.domain.model.Username

import com.example.usecasesexample.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


    override fun saveName(saveParam: SaveUsername): Boolean {
        return userStorage.save(User(firstName = saveParam.name, lastName = ""))
    }

    override fun getName(): Username {
        val user = userStorage.get()

        return Username(firstName = user.firstName, lastName = user.lastName)
    }
}