package com.example.testnewsapp.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.testnewsapp.model.Article
import com.example.testnewsapp.repo.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject
constructor(private val repository: NewsRepo) : ViewModel() {

    private val mainScope = MainScope()

    // UI State
    private val _screenState = mutableStateOf<ScreenState>(ScreenState.Normal)
    val screenState = _screenState

    @SuppressLint("MutableCollectionMutableState")
    private val _allNews = mutableStateOf(ArrayList<Article>())
    val allNews = _allNews

    //function for getting article
    fun fetchNews(query: String = "apple") {

        mainScope.launch {
            _screenState.value = ScreenState.InProgress
            runCatching {
                repository.fetchNews(query = query)
            }.onSuccess { result ->
                result.fold(
                    onSuccess = { articles ->
                        if (articles.isNotEmpty()) {
                            _allNews.value = ArrayList(articles)  // Convert List to ArrayList
                            _screenState.value = ScreenState.Success
                            println("get news ${_allNews.value}")
                        } else {
                            println("No articles found")
                            _screenState.value = ScreenState.Normal
                        }
                    },
                    onFailure = { exception ->
                        println("Error received: ${exception.message}")
                        _screenState.value = ScreenState.Error(exception.message ?: "Unknown error")
                    }
                )
            }.onFailure { exception ->
                println("get error${exception.cause}")
                _screenState.value = ScreenState.Error(exception.message ?: "Unknown error")
            }
        }

    }

    fun clearError() {
        _screenState.value = ScreenState.Normal
    }

}