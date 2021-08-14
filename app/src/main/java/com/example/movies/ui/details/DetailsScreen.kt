package com.example.movies.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.models.Image
import com.example.movies.models.Cast
import com.example.movies.models.Result
import com.example.movies.ui.details.components.CastList
import com.example.movies.ui.details.components.ImageList
import com.example.movies.ui.details.components.TopComponent
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.util.DemoMovieDataProvider

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = viewModel(),
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit
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
        onCastClick
    )
}

@Composable
fun DetailsScreenComponents(
    result: Result?,
    castList: List<Cast>?,
    recommendationsList: List<Result>?,
    collectionList: List<Result>?,
    imageList: List<Image>?,
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit
) {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        result?.let {
            TopComponent(result = result)

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = "STORYLINE", fontWeight = FontWeight.Bold)
                Text(text = result.overview)
            }
        }
        castList?.let {
            CastList(castList,onCastClick)
        }
        collectionList?.let {
            MoviesList(
                results = collectionList,
                title = "Collection",
                onItemClick = onMovieClick,
                modifier = Modifier.height(360.dp)
            )
        }
        imageList?.let {
            ImageList(it,"Image")
        }
        recommendationsList?.let {
            MoviesList(
                results = recommendationsList,
                title = "Recommendations",
                onItemClick = onMovieClick,
                modifier = Modifier.height(360.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    MoviesTheme(darkTheme = true) {
        DetailsScreenComponents(
            result = DemoMovieDataProvider.movie,
            castList = DemoMovieDataProvider.castList,
            recommendationsList = DemoMovieDataProvider.movies,
            collectionList = DemoMovieDataProvider.movies,
            imageList = null,
            onMovieClick = {},
            onCastClick = {}
        )
    }
}
