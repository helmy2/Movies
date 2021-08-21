package com.example.movies.ui.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.movies.models.Cast
import com.example.movies.models.Result
import com.example.movies.util.Type

@Composable
fun SearchScreenComponents(
    searchResults: List<Result>?,
    titles: List<Type>,
    index: Int,
    onTapItemClick: (id:Int) -> Unit,
    onMovieClick: (id: Int) -> Unit,
    personResults: List<Cast>?,
    onCastClick: (id: Int) -> Unit,
    onEndItem: () -> Unit,
    type: Type
) {
    Column {
        TabRow(
            selectedTabIndex = index,
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface
        ) {
            titles.forEachIndexed { it, title ->
                Tab(
                    text = { Text(title.name) },
                    selected = index == it,
                    onClick = { onTapItemClick(it) }
                )
            }
        }
        when (type) {
            Type.Movie -> {
                searchResults?.let {
                    if (it.isNotEmpty())
                        SearchMovieList(
                            results = it.filter { it.posterPath != null },
                            onItemClick = onMovieClick,
                            onEndItem = onEndItem,
                        )
                }
            }
            Type.Person -> {
                personResults?.let {
                    if (it.isNotEmpty())
                        SearchPersonList(
                            castList = it.filter { it.profilePath != null },
                            onItemClick = onCastClick,
                            onEndItem = onEndItem
                        )
                }
            }
        }
    }
}