package com.example.testnewsapp.viewmodel

sealed class ScreenState {

    data object InProgress : ScreenState()
    data class Error(val errorMessage: String) : ScreenState()
    data object Success : ScreenState()
    data object Normal : ScreenState()

}