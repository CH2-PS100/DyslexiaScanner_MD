package com.example.dyslexiascanner.view.login

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.dyslexiascanner.MainActivity
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityLoginBinding
import com.example.dyslexiascanner.view.hide
import com.example.dyslexiascanner.view.show
import com.example.dyslexiascanner.view.signup.SignupActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var myEditEmail: EditText
    private lateinit var myEditPassword: EditText

    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser!=null)
            startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        myEditEmail = findViewById(R.id.email)
        myEditPassword = findViewById(R.id.password_toggle)

        binding.progressBar.hide()

        binding.createAccount.setOnClickListener{
            startActivity(Intent(this,SignupActivity::class.java))
            finish()
        }

        binding.login.setOnClickListener{
            if (myEditEmail.text.isNotEmpty() && myEditPassword.text.isNotEmpty()){
                Login()
            }else{
                val errorMessage = getString(R.string.login_fill_required)
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()            }
        }


    }

    private fun Login(){
        val email = myEditEmail.text.toString()
        val password_toggle = myEditPassword.text.toString()

        binding.progressBar.show()

        firebaseAuth.signInWithEmailAndPassword(email, password_toggle)
        .addOnSuccessListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        .addOnFailureListener { error ->
            Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
        }
        .addOnCompleteListener {
            binding.progressBar.hide()
        }
    }

}