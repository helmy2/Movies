package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.movies.ui.navigation.Screen
import com.example.movies.ui.splash.SplashScreen

@Composable
fun SplashScreenComposable(navController: NavHostController) {
    SplashScreen(onSplashDone = {
        navController.popBackStack()
        navController.navigate(Screen.HomeScreen.route)
    })
}