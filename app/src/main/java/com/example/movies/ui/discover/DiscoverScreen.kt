package com.example.movies.ui.discover

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import com.example.movies.ui.home.components.MovieItem

@Composable
fun DiscoverScreen(id: Int, viewModel: DiscoverViewModel, onItemClick: (id: Int) -> Unit) {
    LaunchedEffect(key1 = true) {
        viewModel.getMovieGenres(id)
    }
    val results by viewModel.results

    results?.let {
        GenreList(
            results = it,
            onItemClick = onItemClick,
            onEndItem = {
                viewModel.getMovieGenres(id)
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GenreList(
    results: List<Result>,
    onItemClick: (id: Int) -> Unit,
    onEndItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(8.dp)) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 128.dp),
        ) {
            itemsIndexed(items = results) { index, result ->
                MovieItem(
                    url = MovieApi.IMAGE_URL + result.posterPath,
                    title = result.title,
                    rating = result.voteAverage.toFloat(),
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onItemClick(result.id) }
                )
                if (index == results.size - 1)
                    onEndItem()
            }
        }
    }
}