package com.example.movies.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.home.components.ImageList
import com.example.movies.ui.home.components.MainImageList
import com.google.accompanist.pager.ExperimentalPagerApi


private const val TAG = "HomeScreen"

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val popularResults by remember { viewModel.popularResults }
    val topRatedResults by remember { viewModel.topRatedResults }
    val nowPlayingResults by remember { viewModel.nowPlayingResults }
    val nowPlayingArabicResults by remember { viewModel.nowPlayingArabicResults }
    val upcomingResults by remember { viewModel.upcomingResults }
    val animationResults by remember { viewModel.animationResults }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Movies", fontSize = 28.sp, fontWeight = FontWeight.Black)
            },
            backgroundColor = MaterialTheme.colors.background,
            actions = {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(end = 8.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(Icons.Default.Search, contentDescription = Icons.Default.Search.name)
                }
            }
        )
    }) {
        LazyColumn {
            item {
                nowPlayingArabicResults?.let {
                    MainImageList(it.subList(0, 5), "Playing Now In Egypt", modifier = Modifier.height(400.dp))
                }
            }
            item {
                nowPlayingResults?.let {
                    ImageList(it, "Playing Now In The World", modifier = Modifier.height(360.dp))
                }
            }
            item {
                animationResults?.let {
                    ImageList(it, "Animation", modifier = Modifier.height(360.dp))
                }
            }
            item {
                upcomingResults?.let {
                    ImageList(it, "Upcoming", modifier = Modifier.height(360.dp))
                }
            }
            item {
                topRatedResults?.let {
                    ImageList(it, "Top Rated", modifier = Modifier.height(360.dp))
                }
            }
            item {
                popularResults?.let {
                    ImageList(it, "Popular", modifier = Modifier.height(360.dp))
                }
            }
        }
    }
}



