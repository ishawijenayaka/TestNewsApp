package com.example.testnewsapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.testnewsapp.R
import com.example.testnewsapp.ui.commanComponents.AnimatedArticle
import com.example.testnewsapp.ui.commanComponents.AnimatedArticleWithImage
import com.example.testnewsapp.ui.commanComponents.ErrorAlertBox
import com.example.testnewsapp.ui.commanComponents.GeneralText
import com.example.testnewsapp.ui.commanComponents.ProgressView
import com.example.testnewsapp.ui.commanComponents.SectionTitle
import com.example.testnewsapp.viewmodel.NewsViewModel
import com.example.testnewsapp.viewmodel.ScreenState
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: NewsViewModel, topAppBar:@Composable ()->Unit){

    val query = remember { mutableStateOf("google") }
    val showAlert = remember { mutableStateOf(false) }

    fun onQueryChanged() {
        viewModel.fetchNews(query = query.value)
    }

    LaunchedEffect(Unit) {
        onQueryChanged()
        delay(1000)
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            topAppBar()
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                SearchBar(
                    modifier = Modifier
                        .padding(15.dp)
                        .height(70.dp),
                    query = query.value,
                    onQueryChange = {
                        query.value = it
                        onQueryChanged() },
                    onSearch = { onQueryChanged() },
                    active = true,
                    onActiveChange = {},
                    content = {},
                    placeholder = {
                        GeneralText(
                            title = "Search here",
                            align = TextAlign.Start,
                            textColor = Color.Gray
                        )},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            modifier = Modifier.size(25.dp),
                            tint = Color.Gray
                        )
                    }
                )

                // change screen according to viewmodel screen
                when (viewModel.screenState.value) {
                    is ScreenState.InProgress -> {
                        ProgressView(modifier = Modifier)
                    }

                    is ScreenState.Success -> {
                        LazyColumn(modifier = Modifier.padding(16.dp)) {
                            items(viewModel.allNews.value) { article ->

                                AnimatedArticleWithImage(
                                    article = article,
                                )
                            }
                        }
                    }

                    is ScreenState.Error -> {
                        ErrorAlertBox(
                            onDismiss = { viewModel.clearError() },
                            title = stringResource(id = R.string.error),
                            text = (viewModel.screenState.value as ScreenState.Error).errorMessage
                        )
                    }

                    else -> {
                        SectionTitle(
                            title = stringResource(id = R.string.empty_news),
                            align = TextAlign.Center
                        )
                    }
                }

                if (showAlert.value){
                    ErrorAlertBox(
                        onDismiss = { showAlert.value = false },
                        title = stringResource(id = R.string.error),
                        text = stringResource(id = R.string.empty_fields)
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    )
}
