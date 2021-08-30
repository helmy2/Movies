package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.movies.ui.details.DetailsScreen
import com.example.movies.ui.details.DetailsViewModel
import com.example.movies.ui.navigation.Screen

@Composable
fun DetailsScreenComposable(
    navController: NavHostController,
    navBackStack: NavBackStackEntry
) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val id = navBackStack.arguments?.getString("id")!!.toInt()

    DetailsScreen(
        viewModel = detailsViewModel,
        id = id,
        onMovieClick = {
            navController.navigate(Screen.DetailsScreen.route + "/$it")
        },
        onCastClick = {
            navController.navigate(Screen.PersonScreen.route + "/$it")
        },
        onGenreClick = {
            navController.navigate(Screen.DiscoverScreen.route + "/$it")
        }
    )
}