package com.example.dyslexiascanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import com.example.dyslexiascanner.databinding.ActivityLoginBinding
import com.example.dyslexiascanner.databinding.ActivityMainBinding
import com.example.dyslexiascanner.view.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    private lateinit var myEditName: EditText
//    private lateinit var myEditEmail: EditText

    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        myEditName = findViewById(R.id.full_name)
//        myEditEmail = findViewById(R.id.email)
//
//        val firebaseUser = firebaseAuth.currentUser
//
//        if (firebaseUser!=null){
//            myEditName.text = (firebaseUser?.displayName ?: "") as Editable?
//            myEditEmail.text = (firebaseUser?.email ?: "") as Editable?
//        }else{
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }

        binding.logout.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
                finish()
        }
    }
}