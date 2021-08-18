package com.example.movies.ui.discover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.movies.ui.discover.components.DiscoverList

@Composable
fun DiscoverScreen(id: Int, viewModel: DiscoverViewModel, onItemClick: (id: Int) -> Unit) {
    LaunchedEffect(key1 = true) {
        viewModel.getMovieGenres(id)
    }
    val results by viewModel.results

    results?.let {
        DiscoverList(
            results = it,
            onItemClick = onItemClick,
            onEndItem = {
                viewModel.getMovieGenres(id)
            }
        )
    }
}

