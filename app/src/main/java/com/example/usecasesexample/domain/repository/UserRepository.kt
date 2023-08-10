package com.example.usecasesexample.domain.repository

import com.example.usecasesexample.domain.model.SaveUsername
import com.example.usecasesexample.domain.model.Username

interface UserRepository {
    fun saveName(saveParam: SaveUsername): Boolean
    fun getName() : Username
}