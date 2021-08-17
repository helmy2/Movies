package com.example.movies.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.models.Result
import com.example.movies.repository.HomeRepository
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

    init {
        getPopularMovies()
        getTopRatedMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getAnimationMovies()
    }
}