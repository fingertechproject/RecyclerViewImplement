package com.example.recyclerviewimplement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView = findViewById(R.id.rv)
        var newsList:List<Articles> = listOf(Articles("kk","kjj","jj"))
      //  btn.setOnClickListener {
        val news = NewsInterface.NewsInstance.newsInstance.getNewsList("in")
        news.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val allNews = response.body()

                if (allNews!=null) {
                    Log.d("KK",allNews.toString())
                    val adapter = ItemAdapter(this@MainActivity,allNews.articles)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("KK",t.toString())
            }
        })




    }

   // private fun getNews() {


  //  }

}