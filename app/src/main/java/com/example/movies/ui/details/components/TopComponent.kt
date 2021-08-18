package com.example.movies.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import com.example.movies.util.toHourFormat

@Composable
fun TopComponent(
    result: Result,
    onGenreClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val painter = rememberImagePainter(
        MovieApi.IMAGE_URL_ORIGINAL + result.backdropPath,
        builder = {
            crossfade(true)
        },
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Image(
            painter = painter,
            contentDescription = result.title,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.7f),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        .3f to Color.Transparent,
                        .7f to MaterialTheme.colors.background,
                    )
                )
                .fillMaxSize()
        )
        InformationBox(
            result.genres,
            title = result.title,
            runtime = result.runtime.toHourFormat(),
            voteCount = result.voteCount.toString(),
            releaseDate = result.releaseDate,
            voteAverage = result.voteAverage.toFloat(),
            onGenreClick = onGenreClick,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}