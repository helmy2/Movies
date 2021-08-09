package com.example.movies.ui.details

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = viewModel(),
    id: Int
) {
    SideEffect {
        viewModel.getPopularMovies(id)
    }
    val result by remember {
        viewModel.results
    }

    Text(text = result.toString())
}