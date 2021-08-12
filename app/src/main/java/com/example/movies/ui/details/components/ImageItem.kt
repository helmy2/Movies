package com.example.movies.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ImageItem(url: String, ratio: Float, modifier: Modifier) {
    val painter = rememberImagePainter(
        url,
        builder = {
            crossfade(true)
        },
    )
    Card(
        modifier = modifier
            .padding(end = 16.dp)
            .aspectRatio(ratio)
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}