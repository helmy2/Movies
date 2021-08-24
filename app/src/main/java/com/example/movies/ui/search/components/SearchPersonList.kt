package com.example.movies.ui.search.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.data.models.Cast
import com.example.movies.ui.details.components.CastItem
import com.example.movies.ui.theme.Padding
import com.example.movies.data.util.Constants.IMAGE_URL

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
                    url = IMAGE_URL + result.profilePath,
                    name = result.name,
                    character = null,
                    id = result.id,
                    onItemClick = onItemClick,modifier = Modifier.padding(Padding.small))

                if (index == castList.size - 1)
                    onEndItem()
            }
        }
    }
}