package com.example.movies.ui.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter


@Composable
fun MovieItem(
    url: String,
    title: String,
    rating: Float,
    id: Int,
    onItemClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    val painter = rememberImagePainter(
        url,
        builder = {
            crossfade(true)
        },
    )

    MovieItemComponent(modifier, onItemClick, id, painter, title, rating)
}

