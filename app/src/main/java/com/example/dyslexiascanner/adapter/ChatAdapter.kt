package com.example.dyslexiascanner.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.databinding.ItemListChatBinding
import com.example.dyslexiascanner.model.ChatData
import com.example.dyslexiascanner.view.chat.RoomChatActivity

class ChatAdapter(
    var context: Context,
    var chatList: ArrayList<ChatData>
    ) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

        inner class ChatViewHolder(val v: ItemListChatBinding) : RecyclerView.ViewHolder(v.root)

        fun setFilteredList(chatList: ArrayList<ChatData>){
            this.chatList = chatList
            notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val v = DataBindingUtil.inflate<ItemListChatBinding>(
                inflater, R.layout.item_list_chat, parent,
                false
            )
            return ChatViewHolder(v)
        }

        override fun getItemCount(): Int {
            return chatList.size
        }

        override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
            val newList = chatList[position]
            holder.v.isChat = chatList[position]
            holder.v.root.setOnClickListener {
                val img = newList.img
                val name = newList.name
                val info = newList.info
                val years = newList.years
                val price = newList.price

                val mIntent = Intent(context, RoomChatActivity::class.java)
                mIntent.putExtra("img", img)
                mIntent.putExtra("name", name)
                mIntent.putExtra("info", info)
                mIntent.putExtra("years", years)
                mIntent.putExtra("price", price)
                context.startActivity(mIntent)

            }
        }
}