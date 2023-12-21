package com.example.dyslexiascanner.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.dyslexiascanner.R
import androidx.recyclerview.widget.RecyclerView
import com.example.dyslexiascanner.databinding.ItemListBinding
import com.example.dyslexiascanner.model.ArticleData
import com.example.dyslexiascanner.view.article.DetailActivity

class ArticleAdapter(
    var context: Context,
    var articleList: ArrayList<ArticleData>
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val v: ItemListBinding) : RecyclerView.ViewHolder(v.root)

    fun setFilteredList(articleList: ArrayList<ArticleData>){
        this.articleList = articleList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(
            inflater, R.layout.item_list, parent,
            false
        )
        return ArticleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val newList = articleList[position]
        holder.v.isArticle = articleList[position]
        holder.v.root.setOnClickListener {
            val img = newList.img
            val name = newList.name
            val info = newList.info?.replace("\\n", "\n")
            val dateTime = newList.dateTime

            val mIntent = Intent(context, DetailActivity::class.java)
            mIntent.putExtra("img", img)
            mIntent.putExtra("name", name)
            mIntent.putExtra("info", info)
            mIntent.putExtra("dateTime", dateTime)
            context.startActivity(mIntent)

        }
    }



}