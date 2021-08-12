package com.example.movies.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.home.components.PagerList
import com.google.accompanist.pager.ExperimentalPagerApi


private const val TAG = "HomeScreen"

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    onItemClick: (id: Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val popularResults by remember { viewModel.popularResults }
    val topRatedResults by remember { viewModel.topRatedResults }
    val nowPlayingResults by remember { viewModel.nowPlayingResults }
    val upcomingResults by remember { viewModel.upcomingResults }
    val animationResults by remember { viewModel.animationResults }

    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        nowPlayingResults?.let {
            PagerList(
                it,
                onItemClick,
                modifier = Modifier.height(300.dp)
            )
        }
        animationResults?.let {
            MoviesList(
                it,
                "Animation",
                onItemClick,
                modifier = Modifier.height(360.dp)
            )
        }
        upcomingResults?.let {
            MoviesList(
                it,
                "Upcoming",
                onItemClick,
                modifier = Modifier.height(360.dp)
            )
        }
        topRatedResults?.let {
            MoviesList(
                it,
                "Top Rated",
                onItemClick,
                modifier = Modifier.height(360.dp)
            )
        }
        popularResults?.let {
            MoviesList(
                it,
                "Popular",
                onItemClick,
                modifier = Modifier.height(360.dp)
            )
        }
    }
}




