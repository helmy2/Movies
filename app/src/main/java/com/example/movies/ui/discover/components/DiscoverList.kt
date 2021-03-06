package com.example.movies.ui.discover.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.data.models.Result
import com.example.movies.ui.home.components.MovieItem
import com.example.movies.ui.theme.Padding
import com.example.movies.data.util.Constants.IMAGE_URL

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DiscoverList(
    results: List<Result>,
    onItemClick: (id: Int) -> Unit,
    onEndItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(Padding.medium)) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 128.dp),
        ) {
            itemsIndexed(items = results) { index, result ->
                MovieItem(
                    url = IMAGE_URL + result.posterPath,
                    title = result.title,
                    rating = result.voteAverage.toFloat(),
                    id = result.id,
                    onItemClick = onItemClick,
                    modifier = Modifier
                        .padding(Padding.medium)
                )
                if (index == results.size - 1)
                    onEndItem()
            }
        }
    }
}