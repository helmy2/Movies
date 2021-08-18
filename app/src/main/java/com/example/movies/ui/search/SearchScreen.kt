package com.example.movies.ui.search

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.search.components.EmptySearchScreenComponents
import com.example.movies.ui.search.components.SearchAppBar
import com.example.movies.ui.search.components.SearchScreenComponents
import com.example.movies.util.Type

@Composable
fun SearchScreen(
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit,
    viewModel: SearchViewModel = viewModel()
) {
    var searchText by remember { viewModel.searchText }
    var indexState by remember { viewModel.indexState }
    val titles = listOf(Type.Movie, Type.Person)

    LaunchedEffect(searchText) {
        viewModel.search()
    }

    val movieResults by viewModel.movieResults.collectAsState()
    val personResults by viewModel.personResults.collectAsState()

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

        TabRow(selectedTabIndex = indexState) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title.name) },
                    selected = indexState == index,
                    onClick = { indexState = index }
                )
            }
        }

        Crossfade(targetState = searchText) {
            when (it) {
                "" -> {
                    EmptySearchScreenComponents()
                }
                else ->
                    SearchScreenComponents(
                        movieResults,
                        onMovieClick,
                        personResults,
                        onCastClick,
                        onEndItem = if (titles[indexState] == Type.Movie) {
                            { viewModel.addSearchMovie() }
                        } else {
                            { viewModel.addSearchPerson() }
                        },
                        titles[indexState],
                    )
            }
        }
    }
}


