package com.example.dyslexiascanner.view.article

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dyslexiascanner.MainActivity
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.adapter.ArticleAdapter
import com.example.dyslexiascanner.databinding.ActivityArticleBinding
import com.example.dyslexiascanner.model.ArticleData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale

class ArticleActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var articleList: ArrayList<ArticleData>
    private lateinit var mAdapter: ArticleAdapter
    private lateinit var binding: ActivityArticleBinding
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article)

        articleList = ArrayList()
        mAdapter = ArticleAdapter(this, articleList)

        binding.recyclerArticle.layoutManager = LinearLayoutManager(this)
        binding.recyclerArticle.setHasFixedSize(true)
        binding.recyclerArticle.adapter = mAdapter

        searchView = findViewById(R.id.searchView) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        getArticleData()
        initializeUI()
    }

    private fun filterList(query: String?){
        if (query != null){
            val filteredList = ArrayList<ArticleData>()
            for(i in articleList){
                if (i.name?.lowercase(Locale.ROOT)?.contains(query) == true){
                    filteredList.add(i)
                }
            }

            if(filteredList.isEmpty()){
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
            }else{
                mAdapter.setFilteredList(filteredList)
            }
        }
    }
    private fun getArticleData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("Article")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (articleSnapshot in snapshot.children) {
                        val article = articleSnapshot.getValue(ArticleData::class.java)
                        if (article != null) {
                            articleList.add(article)
                        }
                    }
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@ArticleActivity,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }
        })
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
