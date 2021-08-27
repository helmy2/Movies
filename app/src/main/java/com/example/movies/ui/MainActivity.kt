package com.example.movies.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.coroutineScope
import com.example.movies.data.repository.implementations.DatabaseRepositoryImpl
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.util.ConnectionLiveData
import com.example.movies.ui.util.Navigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(connectionLiveData = connectionLiveData)
                }
            }
        }
    }
}

