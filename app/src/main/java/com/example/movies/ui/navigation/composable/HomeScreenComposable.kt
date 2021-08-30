package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movies.ui.home.HomeScreen
import com.example.movies.ui.home.HomeViewModel
import com.example.movies.ui.navigation.Screen

@Composable
fun HomeScreenComposable(navController: NavHostController) {
    val homeViewModel: HomeViewModel = hiltViewModel()

    HomeScreen(
        onMovieClick = { id ->
            navController.navigate(Screen.DetailsScreen.route + "/$id")
        },
        onSearchClick = {
            navController.navigate(Screen.SearchScreen.route)
        },
        onGenreClick = { id ->
            navController.navigate(Screen.DiscoverScreen.route + "/$id")
        },
        onUserClick = {
            navController.navigate(Screen.UserScreen.route)
        },
        viewModel = homeViewModel,
    )
}