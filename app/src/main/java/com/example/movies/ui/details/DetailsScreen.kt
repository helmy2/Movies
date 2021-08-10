package com.example.movies.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.movies.api.MovieApi
import com.example.movies.models.Genre
import com.example.movies.models.Result
import com.example.movies.ui.util.Ratingbar

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
    result?.let { DetailsScreenComponents(result = it) }

}

@Composable
fun DetailsScreenComponents(
    result: Result
) {
    LazyColumn {
        item {
            TopComponent(result = result)
        }
    }
}

@Composable
fun TopComponent(
    result: Result,
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
            voteAverage = "%.1f".format(result.voteAverage).toFloat(),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun InformationBox(
    genres: List<Genre>,
    title: String,
    runtime: String,
    releaseDate: String,
    voteAverage: Float,
    voteCount: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Chip(
                text = releaseDate
                    .substring(startIndex = 0, endIndex = 4),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(modifier = Modifier.fillMaxWidth(.6f), verticalAlignment = Alignment.Bottom) {
                Column(
                    Modifier
                        .fillMaxWidth(.6f)
                        .padding(bottom = 8.dp)
                ) {
                    Ratingbar(
                        rating = voteAverage,
                        modifier = Modifier.fillMaxWidth(.7f)
                    )
                    Text(text = "$voteCount VOTES", fontSize = 14.sp)
                }
                Text(
                    text = "%.1f".format(voteAverage),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = runtime, modifier = Modifier.padding(end = 8.dp))
            LazyRow {
                items(items = genres) {
                    Chip(text = it.name)
                }
            }
        }
    }
}

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface
) {
    Card(
        modifier = modifier
            .padding(end = 8.dp)
            .clip(shape = RoundedCornerShape(16.dp)),
        backgroundColor = backgroundColor
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
        )
    }
}

fun Int.toHourFormat(): String {
    var minute = this
    var hour = 0
    while (minute > 60) {
        minute -= 60
        hour++
    }
    if (hour == 0)
        return "${minute}min"
    return "${hour}h ${minute}min"
}