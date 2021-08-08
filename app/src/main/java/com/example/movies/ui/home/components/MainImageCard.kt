package com.example.movies.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun MainImageCard(
    url: String,
    title: String,
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

    Image(
        painter = painter,
        contentDescription = title,
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .placeholder(placeholder),
        contentScale = ContentScale.Crop
    )
}