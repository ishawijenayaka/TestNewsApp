package com.example.testnewsapp

import com.example.testnewsapp.domain.ApiService
import com.example.testnewsapp.model.NewsResponse
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiServiceTest {

    @Test
    fun testGetAllArticles() = runBlocking {
        // Explicitly specify the ApiService type in the mock method
        val apiService: ApiService = mock(ApiService::class.java)

        val dummyResponse = NewsResponse("ok", 0, listOf())

        `when`(apiService.getAllArticles("apple", "2024-07-06", "2024-07-06", "popularity", "API_KEY"))
            .thenReturn(Response.success(dummyResponse))

        val response = apiService.getAllArticles("apple", "2024-07-06", "2024-07-06", "popularity", "API_KEY")

        assert(response.isSuccessful)
        assert(response.body()?.status == "ok")
    }
}