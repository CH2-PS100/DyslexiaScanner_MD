package com.example.dyslexiascanner.view.camera

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.dyslexiascanner.MainActivity
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityResultBinding
import com.example.dyslexiascanner.view.chat.ChatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private lateinit var confidenceTextView: TextView
    private lateinit var diagnosisTextView: TextView
    private lateinit var photoView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        confidenceTextView = findViewById(R.id.detail_result)
        diagnosisTextView = findViewById(R.id.recommendation)

        val imageUriString = intent.getStringExtra("imageUri")
        val confidence = intent.getDoubleExtra("confidence", 0.0)
        val diagnosis = intent.getStringExtra("diagnosis") ?: "No diagnosis"
        photoView = findViewById(R.id.photoView)

        binding.chat.setOnClickListener{
            startActivity(Intent(this, ChatActivity::class.java))
            finish()
        }

        showResult(confidence, diagnosis)
        showImage(imageUriString)
        initializeUI()

    }

    private fun showResult(confidence: Double, diagnosis: String) {
        val formattedConfidence = String.format("%.2f%%", confidence * 100)
        confidenceTextView.text = formattedConfidence
        diagnosisTextView.text = "$diagnosis"
    }


    private fun showImage(imageUriString: String?) {
        imageUriString?.let {
            val imageUri = Uri.parse(it)
            photoView.setImageURI(imageUri)
        }
    }

    private fun initializeUI() {
        val backButton: LinearLayout = findViewById(R.id.back)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}


