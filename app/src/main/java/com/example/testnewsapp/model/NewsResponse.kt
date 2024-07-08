package com.example.testnewsapp.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    val articles: List<Article>
)

