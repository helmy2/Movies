package com.example.movies.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.example.movies.ui.theme.Padding

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
            .padding(end = Padding.large)
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