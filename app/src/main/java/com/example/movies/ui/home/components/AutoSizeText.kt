package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun RatingAutoSizeText(
    text: String,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        val size = maxWidth.value
        val fontSize: Float = size / text.length * 5.4f
        Text(
            text = text,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            fontSize = LocalDensity.current.run { fontSize.toSp() },
            textAlign = TextAlign.Center,
        )
    }
}


@Preview
@Composable
fun RatingAutoSizeTextPreview() {
    Box(Modifier.fillMaxSize()) {
        RatingAutoSizeText("8.7", modifier = Modifier.fillMaxWidth(.5f))
    }
}
