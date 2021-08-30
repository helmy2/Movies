package com.example.movies.ui.discover

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.movies.ui.discover.components.DiscoverList
import com.example.movies.ui.util.NoConnectionScreen

@Composable
fun DiscoverScreen(
    id: Int,
    onItemClick: (id: Int) -> Unit,
    viewModel: DiscoverViewModel
) {
    LaunchedEffect(key1 = true) {
        viewModel.getMovieGenres(id)
    }
    val results by viewModel.results

    if (viewModel.connection.value)
        results?.let {
            DiscoverList(
                results = it,
                onItemClick = onItemClick,
                onEndItem = {
                    viewModel.getMovieGenres(id)
                }
            )
        }
    else
        NoConnectionScreen()
}

