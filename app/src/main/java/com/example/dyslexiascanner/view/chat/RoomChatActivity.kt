package com.example.dyslexiascanner.view.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityRoomChatBinding
import com.example.dyslexiascanner.model.ChatData
import com.example.dyslexiascanner.uitel.getProgessDrawable
import com.example.dyslexiascanner.uitel.loadImage

class RoomChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_chat)

        val chatIntent = intent
        val chatName = chatIntent.getStringExtra("name")
        val chatInfo = chatIntent.getStringExtra("info")
        val chatImg = chatIntent.getStringExtra("img")
        val chatPrice = chatIntent.getStringExtra("price")
        val chatYears = chatIntent.getStringExtra("years")

        val chatData = ChatData(
            name = chatName.orEmpty(),
            info = chatInfo.orEmpty(),
            img = chatImg.orEmpty(),
            price = chatPrice.orEmpty(),
            years = chatYears.orEmpty()
        )

        binding.isChatData = chatData

        if (chatImg != null) {
            binding.ivMessenger.loadImage(chatImg, getProgessDrawable(this))
        } else {
            binding.ivMessenger.setImageResource(R.mipmap.ic_launcher)
        }

        initializeUI()
    }

    private fun initializeUI() {
        val backButton: ImageView = findViewById(R.id.back)
        backButton.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}