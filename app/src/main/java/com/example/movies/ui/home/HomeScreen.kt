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
    onItemClick: (id: Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val popularResults by remember { viewModel.popularResults }
    val topRatedResults by remember { viewModel.topRatedResults }
    val nowPlayingResults by remember { viewModel.nowPlayingResults }
    val nowPlayingArabicResults by remember { viewModel.nowPlayingArabicResults }
    val upcomingResults by remember { viewModel.upcomingResults }
    val animationResults by remember { viewModel.animationResults }

    LazyColumn {
        item {
            nowPlayingResults?.let {
                MainImageList(
                    it,
                    onItemClick,
                    modifier = Modifier.height(300.dp)
                )
            }
        }
//        item {
//            nowPlayingArabicResults?.let {
//                ImageList(
//                    it,
//                    "Playing Now Egypt",
//                    onItemClick,
//                    modifier = Modifier.height(360.dp)
//                )
//            }
//        }
        item {
            animationResults?.let {
                ImageList(
                    it,
                    "Animation",
                    onItemClick,
                    modifier = Modifier.height(360.dp)
                )
            }
        }
        item {
            upcomingResults?.let {
                ImageList(
                    it,
                    "Upcoming",
                    onItemClick,
                    modifier = Modifier.height(360.dp)
                )
            }
        }
        item {
            topRatedResults?.let {
                ImageList(
                    it,
                    "Top Rated",
                    onItemClick,
                    modifier = Modifier.height(360.dp)
                )
            }
        }
        item {
            popularResults?.let {
                ImageList(
                    it,
                    "Popular",
                    onItemClick,
                    modifier = Modifier.height(360.dp)
                )
            }
        }
    }
}




