package com.example.movies.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Genre
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.HomeRepository
import com.example.movies.data.repository.repository.UserRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
    private val userRepository: UserRepository
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

    var currentUser: MutableState<FirebaseUser?> = mutableStateOf(null)

    private fun getPopularMovies() = viewModelScope.launch {
        popularResults.value = homeRepository.getPopularMovies()
    }

    private fun getUpcomingMovies() = viewModelScope.launch {
        upcomingResults.value = homeRepository.getUpcomingMovies()
    }

    private fun getNowPlayingMovies() = viewModelScope.launch {
        nowPlayingResults.value = homeRepository.getNowPlayingMovies()
    }

    private fun getTopRatedMovies() = viewModelScope.launch {
        topRatedResults.value = homeRepository.getTopRatedMovies()
    }

    private fun getAnimationMovies() = viewModelScope.launch {
        animationResults.value = homeRepository.getAnimationMovies()
    }

    private fun getGenreListMovies() = viewModelScope.launch {
        genreListResults.value = homeRepository.getGenreListMovies()
    }

    private fun getCurrentUser() = viewModelScope.launch {
        currentUser.value = userRepository.getCurrentUser()
    }


    init {
        getPopularMovies()
        getTopRatedMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
        getAnimationMovies()
        getGenreListMovies()
        getCurrentUser()
    }
}