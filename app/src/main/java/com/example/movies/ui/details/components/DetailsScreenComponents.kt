package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.models.Cast
import com.example.movies.models.Image
import com.example.movies.models.Result
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.example.movies.util.DemoMovieDataProvider

@Composable
fun DetailsScreenComponents(
    result: Result?,
    castList: List<Cast>?,
    recommendationsList: List<Result>?,
    collectionList: List<Result>?,
    imageList: List<Image>?,
    onMovieClick: (id: Int) -> Unit,
    onCastClick: (id: Int) -> Unit,
    onGenreClick: (id: Int) -> Unit,
) {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        result?.let {
            TopComponent(result = it, onGenreClick)

            Column(modifier = Modifier.padding(horizontal = Padding.largePadding)) {
                Text(
                    text = "STORYLINE",
                    style = Typography.h5,
                    modifier = Modifier.padding(bottom = Padding.mediumPadding)
                )
                Text(text = it.overview, style = Typography.caption)
            }
        }
        castList?.let {
            CastList(it, onCastClick)
        }
        collectionList?.let {
            MoviesList(
                results = it,
                title = "Collection",
                onItemClick = onMovieClick,
                modifier = Modifier.height(360.dp)
            )
        }
        imageList?.let {
            ImageList(it, "Image")
        }
        recommendationsList?.let {
            if (it.isNotEmpty())
                MoviesList(
                    results = it,
                    title = "Recommendations",
                    onItemClick = onMovieClick,
                    modifier = Modifier.height(360.dp)
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenComponentsPreview() {
    MoviesTheme(darkTheme = true) {
        DetailsScreenComponents(
            result = DemoMovieDataProvider.movie,
            castList = DemoMovieDataProvider.castList,
            recommendationsList = DemoMovieDataProvider.movies,
            collectionList = DemoMovieDataProvider.movies,
            imageList = null,
            onMovieClick = {},
            onCastClick = {},
            onGenreClick = {},
        )
    }
}