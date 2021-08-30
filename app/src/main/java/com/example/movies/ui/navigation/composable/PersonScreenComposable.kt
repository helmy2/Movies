package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.movies.ui.navigation.Screen
import com.example.movies.ui.person.PersonScreen
import com.example.movies.ui.person.PersonViewModel

@Composable
fun PersonScreenComposable(
    navController: NavHostController,
    navBackStack: NavBackStackEntry
) {
    val viewModel: PersonViewModel = hiltViewModel()
    val id = navBackStack.arguments?.getString("id")!!.toInt()

    PersonScreen(
        viewModel = viewModel,
        id = id,
        onMovieClick = {
            navController.navigate(Screen.DetailsScreen.route + "/$it")
        }
    )
}