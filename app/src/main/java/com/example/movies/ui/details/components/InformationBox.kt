package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies.models.Genre
import com.example.movies.ui.util.Ratingbar

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
            modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
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