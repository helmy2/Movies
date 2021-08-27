package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.movies.data.models.Genre
import com.example.movies.ui.home.components.RatingAutoSizeText
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.example.movies.ui.util.Chip
import com.example.movies.ui.util.Ratingbar
import com.example.movies.data.util.toYearFormat

@Composable
fun InformationBox(
    id: Int,
    title: String,
    runtime: String,
    voteAverage: Float,
    voteCount: String,
    isFavorite: Boolean?,
    genres: List<Genre>,
    releaseDate: String,
    onFavoriteClick: (id: Int) -> Unit,
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
                RatingAutoSizeText(
                    text = voteAverage.toString(),
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = Padding.large,
                    top = Padding.medium,
                    end = Padding.medium
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = Typography.h5,
                maxLines = 2
            )
            isFavorite?.let {
                IconButton(onClick = { onFavoriteClick(id) }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }
        }
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


