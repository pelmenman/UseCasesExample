package com.example.usecasesexample.data.repository

import android.content.Context
import com.example.usecasesexample.domain.model.SaveUsername
import com.example.usecasesexample.domain.model.Username
import com.example.usecasesexample.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Default"
class UserRepositoryImpl(context: Context): UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUsername): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): Username {
       val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
       val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?:""

        return Username(firstName = firstName, lastName = lastName)
    }
}