package com.example.movies.ui.util

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.details.DetailsScreen
import com.example.movies.ui.details.DetailsViewModel
import com.example.movies.ui.home.HomeViewModel
import com.example.movies.ui.home.HomeScreen
import com.example.movies.ui.splash.SplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation(
    homeViewModel: HomeViewModel = viewModel(),
    detailsViewModel: DetailsViewModel = viewModel()
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(onItemClick = { id ->
                navController.navigate(Screen.DetailsScreen.route + "/$id")
            }, homeViewModel)
        }
        composable(Screen.DetailsScreen.route + "/{id}") { navBackStack ->
            val id = navBackStack.arguments?.getString("id")!!.toInt()
            DetailsScreen(viewModel = detailsViewModel, id = id)
        }
    }
}