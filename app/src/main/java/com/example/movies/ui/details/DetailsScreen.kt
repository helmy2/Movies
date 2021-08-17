package com.example.movies.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.details.components.DetailsScreenComponents

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = viewModel(),
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit,
    onGenreClick: (id: Int) -> Unit,
) {
    LaunchedEffect(key1 = true) {
        viewModel.getDetails(id)
    }

    val result by viewModel.results
    val castList by viewModel.castList
    val recommendationsList by viewModel.recommendationsList
    val collectionList by viewModel.collectionList
    val imageList by viewModel.imageList

    DetailsScreenComponents(
        result,
        castList,
        recommendationsList,
        collectionList,
        imageList,
        onMovieClick,
        onCastClick,
        onGenreClick
    )
}

