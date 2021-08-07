package com.example.movies.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.util.Navigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
//                val systemUiController = rememberSystemUiController()
//                val color = MaterialTheme.colors.background
//                SideEffect {
//                    systemUiController.setStatusBarColor(color = color)
//                    systemUiController.setNavigationBarColor(color = color)
//                }

                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}
