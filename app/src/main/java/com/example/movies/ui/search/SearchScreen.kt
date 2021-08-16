package com.example.movies.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.details.components.CastList
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.search.components.SearchAppBar
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun SearchScreen(
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit,
    viewModel: SearchViewModel = viewModel()
) {
    var searchText by remember { mutableStateOf("") }

    LaunchedEffect(key1 = searchText) {
        viewModel.search(searchText)
    }

    val searchResults by viewModel.searchResults
    val personResults by viewModel.personResults

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        SearchAppBar(
            value = searchText,
            onValueChange = {
                searchText = it
            }
        )
        searchResults?.let {
            if (it.isNotEmpty())
                MoviesList(
                    results = it,
                    title = "Movies",
                    onItemClick = onMovieClick,
                    modifier = Modifier.height(360.dp)
                )
        }
        personResults?.let {
            if (it.isNotEmpty())
                CastList(castList = it, onCastClick = onCastClick)
        }
    }

    if (searchText == "") {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Start Searching",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = "Search all of Konsensus for Movies, Series, People," +
                        " Networks, Production Companies,  Lists and Users.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }

}

