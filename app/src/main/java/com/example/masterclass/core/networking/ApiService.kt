package com.example.masterclass.core.networking

import com.example.masterclass.core.networking.model.ArticlesResultResource
import retrofit2.http.GET

interface ApiService {

    @GET("everything?q=tesla&apiKey=c2ca555322e64eec85f9b7207949b998")
    suspend fun getArticles(): ArticlesResultResource
}
