package com.example.movies.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.movies.ui.details.components.DetailsScreenComponents
import com.example.movies.ui.util.NoConnectionScreen

@Composable
fun DetailsScreen(
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit,
    onGenreClick: (id: Int) -> Unit,
    viewModel: DetailsViewModel,
) {
    LaunchedEffect(key1 = true) {
        viewModel.getDetails(id)
    }

    val result by viewModel.results
    val castList by viewModel.castList
    val recommendationsList by viewModel.recommendationsList
    val collectionList by viewModel.collectionList
    val imageList by viewModel.imageList
    val isFavorite by viewModel.isFavorite

    if (viewModel.connection.value)
        DetailsScreenComponents(
            result,
            castList = castList,
            recommendationsList = recommendationsList,
            collectionList = collectionList,
            imageList = imageList,
            onMovieClick = onMovieClick,
            onCastClick = onCastClick,
            onGenreClick = onGenreClick,
            onFavoriteClick = { id ->
                isFavorite?.let {
                    if (it)
                        viewModel.deleteFromFavoriteList(id)
                    else
                        viewModel.addToFavoriteList(id)
                }
            },
            isFavorite = isFavorite,
        )
    else
        NoConnectionScreen()
}

