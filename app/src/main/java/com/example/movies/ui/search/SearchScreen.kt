package com.example.movies.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.search.components.SearchAppBar
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun SearchScreen(
    onMovieClick: (id: Int) -> Unit,
    viewModel: SearchViewModel = viewModel()
) {
    var searchText by remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 = searchText) {
        viewModel.search(searchText)
    }
    val searchResults by viewModel.searchResults
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        SearchAppBar(
            value = searchText,
            onValueChange = {
                searchText = it
            }
        )
        searchResults?.let {
            MoviesList(
                results = searchResults!!,
                title = "Movies",
                onItemClick = onMovieClick,
                modifier = Modifier.height(360.dp)
            )
        }
    }
}

