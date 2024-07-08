package com.example.testnewsapp.domain

import com.example.testnewsapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

        @GET("everything")
        suspend fun getAllArticles(
                @Query("q") query: String,
                @Query("from") fromDate: String,
                @Query("to") toDate: String,
                @Query("sortBy") sortBy: String,
                @Query("apiKey") apiKey: String
        ): Response<NewsResponse>

}
