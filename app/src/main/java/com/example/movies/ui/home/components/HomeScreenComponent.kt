package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.models.Genre
import com.example.movies.models.Result
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreenComponent(
    onSearchClick: () -> Unit,
    genreListResults: List<Genre>?,
    onGenreClick: (id: Int) -> Unit,
    nowPlayingResults: List<Result>?,
    onMovieClick: (id: Int) -> Unit,
    animationResults: List<Result>?,
    upcomingResults: List<Result>?,
    topRatedResults: List<Result>?,
    popularResults: List<Result>?
) {
    Scaffold(
        topBar = { HomeAppBar(onActionsClick = onSearchClick) }
    ) {
        Column(
            modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
        ) {
            genreListResults?.let {
                GenreList(it, onGenreClick)
            }

            nowPlayingResults?.let {
                PagerList(
                    it,
                    "Now Playing",
                    onMovieClick,
                )
            }
            animationResults?.let {
                PagerList(
                    it,
                    "Animation",
                    onMovieClick,
                )
            }
            upcomingResults?.let {
                PagerList(
                    it,
                    "Upcoming",
                    onMovieClick,
                )
            }
            topRatedResults?.let {
                PagerList(
                    it,
                    "Top Rated",
                    onMovieClick,
                )
            }
            popularResults?.let {
                PagerList(
                    it,
                    "Popular",
                    onMovieClick,
                )
            }
        }
    }
}