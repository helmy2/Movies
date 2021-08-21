package com.example.movies.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.home.components.HomeScreenComponent


@Composable
fun HomeScreen(
    onMovieClick: (id: Int) -> Unit,
    onGenreClick: (id: Int) -> Unit,
    onSearchClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val popularResults by remember { viewModel.popularResults }
    val topRatedResults by remember { viewModel.topRatedResults }
    val nowPlayingResults by remember { viewModel.nowPlayingResults }
    val upcomingResults by remember { viewModel.upcomingResults }
    val animationResults by remember { viewModel.animationResults }
    val genreListResults by remember { viewModel.genreListResults }

    HomeScreenComponent(
        onSearchClick,
        genreListResults,
        onGenreClick,
        nowPlayingResults,
        onMovieClick,
        animationResults,
        upcomingResults,
        topRatedResults,
        popularResults
    )
}


