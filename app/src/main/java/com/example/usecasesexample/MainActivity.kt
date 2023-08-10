package com.example.usecasesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.usecasesexample.data.repository.UserRepositoryImpl
import com.example.usecasesexample.databinding.ActivityMainBinding
import com.example.usecasesexample.domain.model.SaveUsername
import com.example.usecasesexample.domain.repository.UserRepository
import com.example.usecasesexample.domain.usecase.GetUserNameUseCase
import com.example.usecasesexample.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userRepository by lazy { UserRepositoryImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getDataButton.setOnClickListener {
           val name = getUserNameUseCase.execute()

            binding.dataTextView.text = "${name.firstName} ${name.lastName}"
        }

        binding.sendDataButton.setOnClickListener {
            val name = binding.editText.text.toString()
            val result = saveUserNameUseCase.execute(SaveUsername(name = name))
            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
        }
    }
}