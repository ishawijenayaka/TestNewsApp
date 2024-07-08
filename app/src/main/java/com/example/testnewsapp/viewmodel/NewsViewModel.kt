package com.example.testnewsapp.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
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
            }.onSuccess {
               if (it != null) {
                   _allNews.value = it as ArrayList<Article>
                   println("get news ${_allNews.value}")
                   _screenState.value = ScreenState.Success

               } else {
                   _screenState.value = ScreenState.Normal
               }

            }.onFailure { exception ->
                _screenState.value = ScreenState.Error(exception.message.toString())
            }
        }
    }

    fun clearError() {
        _screenState.value = ScreenState.Normal
    }

}