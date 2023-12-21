package com.example.dyslexiascanner.view.history

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dyslexiascanner.R
import com.example.dyslexiascanner.retrofit.ApiConfig
import com.example.dyslexiascanner.retrofit.GetResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var historyAdapter: HistoryAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        recyclerView = view.findViewById(R.id.historyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL).apply {
            reverseLayout = true
        }

        historyAdapter = HistoryAdapter(this)
        recyclerView.adapter = historyAdapter

        fetchDataFromApi()

        return view
    }

    private fun fetchDataFromApi() {
        val apiService = ApiConfig.getApiService()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = apiService.getPrediction().enqueue(object : Callback<GetResponse> {
                    override fun onResponse(call: Call<GetResponse>, response: Response<GetResponse>) {
                        if (response.isSuccessful) {
                            historyAdapter.updateData(response.body()?.dyslexiaData)
                            recyclerView.post {
                                recyclerView.scrollToPosition(historyAdapter.itemCount - 1)
                            }
                        } else {
                        }
                    }

                    override fun onFailure(call: Call<GetResponse>, t: Throwable) {
                    }
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}