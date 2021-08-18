package com.example.movies.ui.util

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.details.DetailsScreen
import com.example.movies.ui.details.DetailsViewModel
import com.example.movies.ui.discover.DiscoverScreen
import com.example.movies.ui.discover.DiscoverViewModel
import com.example.movies.ui.home.HomeScreen
import com.example.movies.ui.home.HomeViewModel
import com.example.movies.ui.person.PersonScreen
import com.example.movies.ui.person.PersonViewModel
import com.example.movies.ui.search.SearchScreen
import com.example.movies.ui.search.SearchViewModel
import com.example.movies.ui.splash.SplashScreen

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
            HomeScreenComposable(navController)
        }
        composable(Screen.DetailsScreen.route + "/{id}") {
            DetailsScreenComposable(navController, it)
        }
        composable(Screen.PersonScreen.route + "/{id}") {
            PersonScreenComposable(navController, it)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreenComposable(navController)
        }
        composable(Screen.DiscoverScreen.route + "/{id}") {
            DiscoverScreenComposable(navController, it)
        }
    }
}

@Composable
private fun HomeScreenComposable(navController: NavHostController) {
    val homeViewModel: HomeViewModel = hiltViewModel()

    HomeScreen(
        onMovieClick = { id ->
            navController.navigate(Screen.DetailsScreen.route + "/$id")
        }, onSearchClick = {
            navController.navigate(Screen.SearchScreen.route)
        }, onGenreClick = { id ->
            navController.navigate(Screen.DiscoverScreen.route + "/$id")
        }, viewModel = homeViewModel
    )
}

@Composable
private fun DetailsScreenComposable(
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

@Composable
private fun PersonScreenComposable(
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
        }
    )
}

@Composable
fun DiscoverScreenComposable(navController: NavHostController, navBackStack: NavBackStackEntry) {
    val id = navBackStack.arguments?.getString("id")!!.toInt()
    val viewModel: DiscoverViewModel = hiltViewModel()

    DiscoverScreen(
        id,
        viewModel,
        onItemClick = {
            navController.navigate(Screen.DetailsScreen.route + "/$it")
        }
    )
}

