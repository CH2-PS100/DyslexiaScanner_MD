package com.example.dyslexiascanner.view.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ActivityDetailBinding
import com.example.dyslexiascanner.model.ArticleData
import com.example.dyslexiascanner.uitel.getProgessDrawable
import com.example.dyslexiascanner.uitel.loadImage

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val articleIntent = intent
        val articleName = articleIntent.getStringExtra("name")
        val articleInfo = articleIntent.getStringExtra("info")
        val articleImg = articleIntent.getStringExtra("img")
        val articleDateTime = articleIntent.getStringExtra("dateTime")

        val articleData = ArticleData(
            name = articleName,
            info = articleInfo,
            img = articleImg,
            dateTime = articleDateTime
        )

        binding.isData = articleData

        if (articleImg != null) {
            binding.img.loadImage(articleImg, getProgessDrawable(this))
        } else {
            binding.img.setImageResource(R.mipmap.ic_launcher)
        }
    }
}