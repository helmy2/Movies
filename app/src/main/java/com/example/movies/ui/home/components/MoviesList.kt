package com.example.movies.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies.api.MovieApi
import com.example.movies.models.Result


@Composable
fun MoviesList(
    results: List<Result>,
    title: String,
    onItemClick: (id: Int) -> Unit,
    modifier: Modifier
) {

    Column(modifier.padding(8.dp)) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 8.dp)
        )
        LazyRow {
            items(items = results) { result ->
                if (result.posterPath != null)
                    MovieItem(
                        url = MovieApi.IMAGE_URL + result.posterPath,
                        title = result.title,
                        rating = result.voteAverage.toFloat(),
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .clickable { onItemClick(result.id) }
                    )
            }
        }
    }
}