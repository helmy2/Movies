package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography

@Composable
fun MoviesList(
    results: List<Result>,
    title: String,
    onItemClick: (id: Int) -> Unit,
) {
    val screenHeight  = LocalConfiguration.current.screenHeightDp.dp

    Column(Modifier.padding(Padding.medium).height(screenHeight * .35f)) {
        Text(
            text = title,
            style = Typography.h5,
            modifier = Modifier
                .padding(Padding.medium)
                .padding(bottom = Padding.medium)
        )
        LazyRow {
            items(items = results) { result ->
                if (result.posterPath != "")
                    MovieItem(
                        url = MovieApi.IMAGE_URL + result.posterPath,
                        title = result.title,
                        rating = result.voteAverage.toFloat(),
                        id = result.id,
                        onItemClick = onItemClick,
                        modifier = Modifier
                            .padding(horizontal = Padding.medium)
                    )
            }
        }
    }
}