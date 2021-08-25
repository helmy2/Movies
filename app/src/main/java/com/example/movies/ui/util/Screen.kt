package com.example.movies.ui.util

import android.annotation.SuppressLint

sealed class Screen(val route: String) {
    @SuppressLint("CustomSplashScreen")
    object SplashScreen : Screen("splash_screen")
    object UserScreen : Screen("user_screen")
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details_screen")
    object PersonScreen : Screen("person_screen")
    object SearchScreen : Screen("search_screen")
    object DiscoverScreen : Screen("discover_screen")
}
