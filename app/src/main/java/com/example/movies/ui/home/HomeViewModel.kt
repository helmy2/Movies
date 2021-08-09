package com.example.movies.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.models.Result
import com.example.movies.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DetailsViewModel"

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var popularResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var topRatedResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var upcomingResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var nowPlayingResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var nowPlayingArabicResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var animationResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    fun getPopularMovies() = viewModelScope.launch {
        try {
            val response = repository.getPopularMovies()
            if (response.isSuccessful) {
                popularResults.value = response.body()?.results
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

    fun getUpcomingMovies() = viewModelScope.launch {
        try {
            val response = repository.getUpcomingMovies()
            if (response.isSuccessful) {
                upcomingResults.value = response.body()?.results
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

    fun getNowPlayingMovies() = viewModelScope.launch {
        try {
            val response = repository.getNowPlayingMovies()
            if (response.isSuccessful) {
                nowPlayingResults.value = response.body()?.results
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }
    fun getNowPlayingArabicMovies() = viewModelScope.launch {
        try {
            val response = repository.getNowPlayingArabicMovies()
            if (response.isSuccessful) {
                nowPlayingArabicResults.value = response.body()?.results
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

    fun getTopRatedMovies() = viewModelScope.launch {
        try {
            val response = repository.getTopRatedMovies()
            if (response.isSuccessful) {
                topRatedResults.value = response.body()?.results
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

    fun getAnimationMovies() = viewModelScope.launch {
        try {
            val response = repository.getAnimationMovies()
            if (response.isSuccessful) {
                animationResults.value = response.body()?.results
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

    init {
        getNowPlayingArabicMovies()
        getPopularMovies()
        getTopRatedMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getAnimationMovies()
    }
}