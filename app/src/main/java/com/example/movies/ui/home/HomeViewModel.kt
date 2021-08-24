package com.example.movies.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.database.Authentication
import com.example.movies.data.models.Genre
import com.example.movies.data.models.Result
import com.example.movies.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    var popularResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var topRatedResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var upcomingResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var nowPlayingResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var animationResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var genreListResults: MutableState<List<Genre>?> = mutableStateOf(null)
        private set

    var authentication: MutableState<Authentication?> = mutableStateOf(null)

    private fun getPopularMovies() = viewModelScope.launch {
        popularResults.value = repository.getPopularMovies()
    }

    private fun getUpcomingMovies() = viewModelScope.launch {
        upcomingResults.value = repository.getUpcomingMovies()
    }

    private fun getNowPlayingMovies() = viewModelScope.launch {
        nowPlayingResults.value = repository.getNowPlayingMovies()
    }

    private fun getTopRatedMovies() = viewModelScope.launch {
        topRatedResults.value = repository.getTopRatedMovies()
    }

    private fun getAnimationMovies() = viewModelScope.launch {
        animationResults.value = repository.getAnimationMovies()
    }
    private fun getGenreListMovies() = viewModelScope.launch {
        genreListResults.value = repository.getGenreListMovies()
        Log.i("TAG", "getGenreListMovies: ${genreListResults.value}")
    }

    fun getAuthentication(authentication: Authentication) {
            this.authentication.value = authentication
    }


    init {
        getPopularMovies()
        getTopRatedMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getAnimationMovies()
        getGenreListMovies()
    }
}