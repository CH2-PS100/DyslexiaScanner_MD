package com.example.dyslexiascanner.view.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.dyslexiascanner.MainActivity
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityLoginBinding
import com.example.dyslexiascanner.databinding.ActivitySignupBinding
import com.example.dyslexiascanner.view.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private lateinit var myEditName: EditText
    private lateinit var myEditEmail: EditText
    private lateinit var myEditPassword: EditText
    private lateinit var myEditPasswordconf: EditText

    private var firebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser!=null)
            startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myEditName = findViewById(R.id.full_name)
        myEditEmail = findViewById(R.id.email)
        myEditPassword = findViewById(R.id.password_toggle)
        myEditPasswordconf = findViewById(R.id.password_conf)


        binding.login.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.signup.setOnClickListener {
            if(myEditName.text.isNotEmpty() && myEditEmail.text.isNotEmpty() && myEditPassword.text.isNotEmpty()){
                if (myEditPassword.text.toString() == myEditPasswordconf.text.toString()){
                    register()
                }else{
                    Toast.makeText(this, "Konfirmasi Kata Sandi Harus Sama!",   LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Silahkan Isi Semua Data!",   LENGTH_SHORT).show()

            }
        }
    }

    private fun register(){
        val full_name = myEditName.text.toString()
        val email = myEditEmail.text.toString()
        val password_toggle = myEditPassword.text.toString()

        firebaseAuth.createUserWithEmailAndPassword(email, password_toggle)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val userUpdateProfile = userProfileChangeRequest {
                        displayName = full_name
                    }
                    val user = task.result.user
                    user!!.updateProfile(userUpdateProfile)
                        .addOnSuccessListener {
                            startActivity(Intent(this, LoginActivity::class.java))
                        }
                        .addOnFailureListener { error2 ->
                            Toast.makeText(this, error2.localizedMessage, LENGTH_SHORT).show()

                        }
                }
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, LENGTH_SHORT).show()
            }

    }
}