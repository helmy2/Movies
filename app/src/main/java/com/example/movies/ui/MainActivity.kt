package com.example.movies.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.movies.data.database.Authentication
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.util.ConnectionLiveData
import com.example.movies.ui.util.Navigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var connectionLiveData: ConnectionLiveData
    private val authentication = Authentication(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(connectionLiveData = connectionLiveData, authentication)
                }
            }
        }
    }
}

