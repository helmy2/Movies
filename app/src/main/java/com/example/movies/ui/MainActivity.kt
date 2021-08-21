package com.example.movies.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.util.ConnectionLiveData
import com.example.movies.ui.util.Navigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var connectionLiveData: ConnectionLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectionLiveData = ConnectionLiveData(this)
        setContent {
            MoviesTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation(connectionLiveData.observeAsState(false))
                }
            }
        }
        connectionLiveData.observeForever {
            Log.i("TAG", "onCreate: $it")
        }
    }
}
