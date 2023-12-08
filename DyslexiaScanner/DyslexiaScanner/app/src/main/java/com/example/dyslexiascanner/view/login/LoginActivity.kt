package com.example.dyslexiascanner.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityLoginBinding
import com.example.dyslexiascanner.view.signup.SignupActivity

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.createAccount?.setOnClickListener{
            startActivity(Intent(this,SignupActivity::class.java))
            finish()
        }

    }
}