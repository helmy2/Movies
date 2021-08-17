package com.example.movies.ui.search.components

import androidx.compose.runtime.Composable
import com.example.movies.models.Cast
import com.example.movies.models.Result
import com.example.movies.util.Type

@Composable
fun SearchScreenComponents(
    searchResults: List<Result>?,
    onMovieClick: (id: Int) -> Unit,
    personResults: List<Cast>?,
    onCastClick: (id: Int) -> Unit,
    onEndItem: () -> Unit,
    type: Type
) {
    when (type) {
        Type.Movie -> {
            searchResults?.let {
                if (it.isNotEmpty())
                    SearchMovieList(
                        results = it,
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