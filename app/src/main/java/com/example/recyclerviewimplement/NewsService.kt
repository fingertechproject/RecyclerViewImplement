package com.example.recyclerviewimplement

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a633d3b17ab64f5fb4fc9d3bc5e26f69
const val BASE_URL = "https://newsapi.org"
const val API_KEY ="a633d3b17ab64f5fb4fc9d3bc5e26f69"

interface NewsInterface{
    @GET(value = "/v2/top-headlines?apiKey=$API_KEY")
    fun getNewsList(@Query("country")country:String,):Call<News>

    object NewsInstance{
        val newsInstance:NewsInterface
init {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    newsInstance = retrofit.create(NewsInterface::class.java)
}

    }
}