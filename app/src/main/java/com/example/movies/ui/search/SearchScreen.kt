package com.example.movies.ui.search

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.movies.ui.search.components.EmptySearchScreenComponents
import com.example.movies.ui.search.components.SearchAppBar
import com.example.movies.ui.search.components.SearchScreenComponents
import com.example.movies.data.util.Type

@Composable
fun SearchScreen(
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit,
    viewModel: SearchViewModel
) {
    var searchText by remember { viewModel.searchText }
    var indexState by remember { viewModel.indexState }
    val titles = listOf(Type.Movie, Type.Person)

    LaunchedEffect(searchText) {
        viewModel.search()
    }

    val movieResults by viewModel.movieResults
    val personResults by viewModel.personResults

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchAppBar(
            value = searchText,
            onValueChange = {
                searchText = it
            }
        )

        Crossfade(targetState = searchText) {
            when (it) {
                "" -> {
                    EmptySearchScreenComponents()
                }
                else ->
                    SearchScreenComponents(
                        searchResults = movieResults,
                        titles = titles,
                        index = indexState,
                        onTapItemClick = { indexState = it },
                        onMovieClick = onMovieClick,
                        personResults = personResults,
                        onCastClick = onCastClick,
                        onEndItem = if (titles[indexState] == Type.Movie) {
                            { viewModel.addSearchMovie() }
                        } else {
                            { viewModel.addSearchPerson() }
                        },
                        type = titles[indexState],
                    )
            }
        }
    }
}


