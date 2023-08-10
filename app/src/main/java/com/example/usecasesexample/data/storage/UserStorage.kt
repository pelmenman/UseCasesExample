package com.example.usecasesexample.data.storage

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}