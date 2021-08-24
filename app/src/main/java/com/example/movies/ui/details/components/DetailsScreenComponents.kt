package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.data.models.Cast
import com.example.movies.data.models.Image
import com.example.movies.data.models.Result
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.example.movies.data.util.DemoMovieDataProvider

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

            Column(modifier = Modifier.padding(horizontal = Padding.large)) {
                Text(
                    text = "STORYLINE",
                    style = Typography.h5,
                    modifier = Modifier.padding(bottom = Padding.medium)
                )
                Text(text = it.overview, style = Typography.caption)
            }
        }
        castList?.let {
            if (it.isNotEmpty())
                CastList(it, onCastClick)
        }
        collectionList?.let {
            if (it.isNotEmpty())
                MoviesList(
                    results = it,
                    title = "Collection",
                    onItemClick = onMovieClick,
                )
        }
        imageList?.let {
            if (it.isNotEmpty())
                ImageList(it, "Image")
        }
        recommendationsList?.let {
            if (it.isNotEmpty())
                MoviesList(
                    results = it,
                    title = "Recommendations",
                    onItemClick = onMovieClick,
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