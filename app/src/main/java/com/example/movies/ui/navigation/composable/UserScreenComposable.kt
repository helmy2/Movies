package com.example.movies.ui.navigation.composable

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movies.ui.navigation.Screen
import com.example.movies.ui.user.UserScreen
import com.example.movies.ui.user.UserViewModel

@Composable
fun UserScreenComposable(navController: NavHostController) {
    val viewModel: UserViewModel = hiltViewModel()
    UserScreen(viewModel) {
        navController.navigate(Screen.DetailsScreen.route + "/$it")
    }
}