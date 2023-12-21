package com.example.dyslexiascanner.view.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.retrofit.DyslexiaDataItem

class HistoryAdapter(historyFragment: HistoryFragment) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private var dataList: MutableList<DyslexiaDataItem?> = mutableListOf()

    fun updateData(newData: List<DyslexiaDataItem?>?) {
        newData?.let {
            dataList.addAll(0, it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList?.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val confidenceTextView: TextView = itemView.findViewById(R.id.confidenceTextView)
        private val diagnosisTextView: TextView = itemView.findViewById(R.id.diagnosisTextView)


        fun bind(item: DyslexiaDataItem?) {
            item?.let {
                val confidence = item.confidence as? Double
                val confidencePercentage = confidence?.times(100)

                val formattedConfidence = String.format("%.2f%%", confidencePercentage)
                val diagnosis = item.diagnosis
                confidenceTextView.text = "Result: $formattedConfidence"
                diagnosisTextView.text = "Diagnosis: $diagnosis"

            }
        }
    }
}