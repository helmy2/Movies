package com.example.movies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.navigation.composable.*

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreenComposable(navController)
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
        composable(Screen.UserScreen.route) {
            UserScreenComposable(navController)
        }
    }
}

