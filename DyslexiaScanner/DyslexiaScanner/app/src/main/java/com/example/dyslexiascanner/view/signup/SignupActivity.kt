package com.example.dyslexiascanner.view.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityLoginBinding
import com.example.dyslexiascanner.databinding.ActivitySignupBinding
import com.example.dyslexiascanner.view.login.LoginActivity

class SignupActivity : AppCompatActivity() {
    private var binding: ActivitySignupBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.login?.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}