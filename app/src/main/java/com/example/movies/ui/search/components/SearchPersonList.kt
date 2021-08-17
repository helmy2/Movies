package com.example.movies.ui.search.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.api.MovieApi
import com.example.movies.models.Cast
import com.example.movies.ui.details.components.CastItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchPersonList(
    castList: List<Cast>,
    onItemClick: (id: Int) -> Unit,
    onEndItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 128.dp),
        ) {
            itemsIndexed(items = castList) { index, result ->
                CastItem(
                    url = MovieApi.IMAGE_URL + result.profilePath,
                    name = result.name,
                    character = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onItemClick(result.id) }
                )
                if (index == castList.size - 1)
                    onEndItem()
            }
        }
    }
}