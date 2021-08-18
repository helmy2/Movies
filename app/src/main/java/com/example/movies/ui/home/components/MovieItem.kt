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
    var placeholder = true

    val painter = rememberImagePainter(
        url,
        builder = {
            crossfade(true)
        },
    )
    if (painter.state is ImagePainter.State.Success)
        placeholder = false

    MovieItemComponent(modifier, onItemClick, id, painter, title, placeholder, rating)
}

