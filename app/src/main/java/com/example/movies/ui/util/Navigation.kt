package com.example.movies.ui.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.details.DetailsScreen
import com.example.movies.ui.details.DetailsViewModel
import com.example.movies.ui.home.HomeScreen
import com.example.movies.ui.home.HomeViewModel
import com.example.movies.ui.person.PersonScreen
import com.example.movies.ui.person.PersonViewModel
import com.example.movies.ui.search.SearchScreen
import com.example.movies.ui.search.SearchViewModel
import com.example.movies.ui.splash.SplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()

            HomeScreen(
                onMovieClick = { id ->
                    navController.navigate(Screen.DetailsScreen.route + "/$id")
                }, onSearchClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }, homeViewModel
            )
        }
        composable(Screen.DetailsScreen.route + "/{id}") { navBackStack ->
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
                }
            )
        }
        composable(Screen.PersonScreen.route + "/{id}") { navBackStack ->
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
        composable(Screen.SearchScreen.route) { navBackStack ->
            val viewModel: SearchViewModel = hiltViewModel()

            SearchScreen(
                viewModel = viewModel,
                onMovieClick = {
                    navController.navigate(Screen.DetailsScreen.route + "/$it")
                }
            )
        }
    }
}

