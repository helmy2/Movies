package com.example.movies.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.movies.ui.home.components.HomeAppBar
import com.example.movies.ui.home.components.HomeContent
import com.example.movies.ui.util.NoConnectionScreen


@Composable
fun HomeScreen(
    onMovieClick: (id: Int) -> Unit,
    onGenreClick: (id: Int) -> Unit,
    onSearchClick: () -> Unit,
    onUserClick: () -> Unit,
    viewModel: HomeViewModel,
) {
    val popularResults by remember { viewModel.popularResults }
    val topRatedResults by remember { viewModel.topRatedResults }
    val nowPlayingResults by remember { viewModel.nowPlayingResults }
    val upcomingResults by remember { viewModel.upcomingResults }
    val animationResults by remember { viewModel.animationResults }
    val genreListResults by remember { viewModel.genreListResults }
    val currentUser by remember { viewModel.currentUser }


    if (viewModel.connection.value)
        Scaffold(
            topBar = {
                HomeAppBar(
                    onSearchClick = onSearchClick,
                    onUserClick = onUserClick,
                    currentUser
                )
            }
        ) {
            HomeContent(
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
    else
        NoConnectionScreen()

}


