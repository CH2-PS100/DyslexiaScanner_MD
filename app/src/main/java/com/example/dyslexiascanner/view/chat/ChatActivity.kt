package com.example.dyslexiascanner.view.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dyslexiascanner.MainActivity
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.adapter.ChatAdapter
import com.example.dyslexiascanner.databinding.ActivityChatBinding
import com.example.dyslexiascanner.model.ChatData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.Locale

class ChatActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var chatList: ArrayList<ChatData>
    private lateinit var mAdapter: ChatAdapter
    private lateinit var binding: ActivityChatBinding
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)

        chatList = ArrayList()
        mAdapter = ChatAdapter(this, chatList)

        binding.recyclerChat.layoutManager = LinearLayoutManager(this)
        binding.recyclerChat.setHasFixedSize(true)
        binding.recyclerChat.adapter = mAdapter

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

        getChatData()
        initializeUI()
    }

    private fun filterList(query: String?){
        if (query != null){
            val filteredList = ArrayList<ChatData>()
            for(i in chatList){
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
    private fun getChatData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("Chat")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (chatSnapshot in snapshot.children) {
                        val chat = chatSnapshot.getValue(ChatData::class.java)
                        if (chat != null) {
                            chatList.add(chat)
                        }
                    }
                    mAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@ChatActivity,
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