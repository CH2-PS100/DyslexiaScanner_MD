package com.example.dyslexiascanner.view.chat

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dyslexiascanner.R

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    }
}