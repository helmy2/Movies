package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.data.models.Genre
import com.example.movies.data.models.Result

@Composable
fun HomeContent(
    genreListResults: List<Genre>?,
    onGenreClick: (id: Int) -> Unit,
    nowPlayingResults: List<Result>?,
    onMovieClick: (id: Int) -> Unit,
    animationResults: List<Result>?,
    upcomingResults: List<Result>?,
    topRatedResults: List<Result>?,
    popularResults: List<Result>?
) {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        genreListResults?.let {
            GenreList(it, onGenreClick)
        }

        nowPlayingResults?.let {
            MoviesList(
                it,
                "Now Playing",
                onMovieClick,
            )
        }
        animationResults?.let {
            MoviesList(
                it,
                "Animation",
                onMovieClick,
            )
        }
        upcomingResults?.let {
            MoviesList(
                it,
                "Upcoming",
                onMovieClick,
            )
        }
        topRatedResults?.let {
            MoviesList(
                it,
                "Top Rated",
                onMovieClick,
            )
        }
        popularResults?.let {
            MoviesList(
                it,
                "Popular",
                onMovieClick,
            )
        }
    }
}
