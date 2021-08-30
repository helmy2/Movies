package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movies.ui.navigation.Screen
import com.example.movies.ui.search.SearchScreen
import com.example.movies.ui.search.SearchViewModel

@Composable
fun SearchScreenComposable(navController: NavHostController) {
    val viewModel: SearchViewModel = hiltViewModel()

    SearchScreen(
        viewModel = viewModel,
        onMovieClick = {
            navController.navigate(Screen.DetailsScreen.route + "/$it")
        },
        onCastClick = {
            navController.navigate(Screen.PersonScreen.route + "/$it")
        },
        onBackClick = {
            navController.popBackStack()
        }
    )
}