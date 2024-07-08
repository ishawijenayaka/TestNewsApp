package com.example.testnewsapp.repo

import com.example.testnewsapp.domain.ApiService
import com.example.testnewsapp.model.Article
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsRepo @Inject constructor(private val apiService: ApiService) {

   //call api service
     suspend fun fetchNews(query: String): Result<List<Article>> {

        return try {
            val response = apiService.getAllArticles(
                query = query,
                fromDate = "2024-07-06",
                toDate = "2024-07-06",
                sortBy = "popularity",
                apiKey = "bf0ac71b41504e43baab439c7250b77f"
            )

            if (response.isSuccessful) {
                val articles = response.body()?.articles ?: emptyList()
                Result.success(articles)
            } else {
                val errorBody = response.errorBody()?.string()
                val errorMessage = parseErrorMessage(errorBody)
                Result.failure(Exception(errorMessage))
            }
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: HttpException) {
            Result.failure(e)
        }
    }
}

private fun parseErrorMessage(jsonResponse: String?): String {
    return try {
        val jsonObject = jsonResponse?.let { JSONObject(it) }
        jsonObject!!.getString("message")  // error message is in 'message' field
    } catch (e: Exception) {
        "Unknown error occurred"
    }
}