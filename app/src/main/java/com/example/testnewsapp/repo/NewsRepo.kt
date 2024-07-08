package com.example.testnewsapp.repo

import com.example.testnewsapp.domain.ApiService
import com.example.testnewsapp.model.Article
import com.example.testnewsapp.model.NewsResponse
import javax.inject.Inject

class NewsRepo @Inject constructor(private val apiService: ApiService) {

        suspend fun fetchNews( query: String): List<Article>? {
            val response = apiService.getAllArticles(
                query = query,
                fromDate = "2024-07-06",
                toDate = "2024-07-06",
                sortBy = "popularity",
                apiKey = "bf0ac71b41504e43baab439c7250b77f"
            )
            return if (response.isSuccessful) response.body()?.articles else null
        }

}