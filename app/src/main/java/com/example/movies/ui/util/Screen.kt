package com.example.movies.ui.util

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details_screen")
    object PersonScreen : Screen("person_screen")
    object SearchScreen : Screen("search_screen")
}
