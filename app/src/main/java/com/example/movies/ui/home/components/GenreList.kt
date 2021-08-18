package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.models.Genre
import com.example.movies.ui.details.components.GenreChip
import com.example.movies.ui.theme.Padding

@Composable
fun GenreList(
    genreList: List<Genre>,
    onGenreClick: (id: Int) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(Padding.medium)
    ) {
        items(items = genreList) {
            GenreChip(text = it.name, id = it.id, onItemClick = onGenreClick)
        }
    }
}