package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movies.models.Genre
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.example.movies.ui.util.Chip
import com.example.movies.ui.util.Ratingbar
import com.example.movies.util.toYearFormat

@Composable
fun InformationBox(
    genres: List<Genre>,
    title: String,
    runtime: String,
    releaseDate: String,
    voteAverage: Float,
    voteCount: String,
    onGenreClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = Padding.large)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Chip(
                text = releaseDate.toYearFormat(),
                modifier = Modifier.padding(bottom = Padding.medium)
            )

            Row(modifier = Modifier.fillMaxWidth(.6f), verticalAlignment = Alignment.Bottom) {
                Column(
                    Modifier
                        .fillMaxWidth(.6f)
                        .padding(bottom = Padding.medium)
                ) {
                    Ratingbar(
                        rating = voteAverage,
                        modifier = Modifier.fillMaxWidth(.7f)
                    )
                    Text(text = "$voteCount VOTES", style = Typography.caption)
                }
                Text(
                    text = voteAverage.toString(),
                    style = Typography.h3
                )
            }
        }
        Text(
            text = title,
            style = Typography.h5,
            maxLines = 2,
            modifier = Modifier.padding(bottom = Padding.large, top = Padding.medium)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = runtime, modifier = Modifier.padding(end = Padding.medium))
            LazyRow {
                items(items = genres) {
                    GenreChip(text = it.name, id = it.id, onItemClick = onGenreClick)
                }
            }
        }
    }
}


