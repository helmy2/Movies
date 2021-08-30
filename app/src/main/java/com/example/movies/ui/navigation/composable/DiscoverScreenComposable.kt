package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.movies.ui.discover.DiscoverScreen
import com.example.movies.ui.discover.DiscoverViewModel
import com.example.movies.ui.navigation.Screen

@Composable
fun DiscoverScreenComposable(navController: NavHostController, navBackStack: NavBackStackEntry) {
    val id = navBackStack.arguments?.getString("id")!!.toInt()
    val viewModel: DiscoverViewModel = hiltViewModel()

    DiscoverScreen(
        id = id,
        viewModel = viewModel,
        onItemClick = {
            navController.navigate(Screen.DetailsScreen.route + "/$it")
        }
    )
}