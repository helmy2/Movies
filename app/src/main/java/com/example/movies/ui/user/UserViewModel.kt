package com.example.movies.ui.user

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.DetailsRepository
import com.example.movies.data.repository.repository.UserRepository
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val detailsRepository: DetailsRepository,
) : ViewModel() {

    var currentUser: MutableState<FirebaseUser?> = mutableStateOf(null)
        private set
    var favoriteLast: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    private fun getCurrentUser() = viewModelScope.launch {
        userRepository.currentUser {
            currentUser.value = it
            if (it == null)
                favoriteLast.value = null
            else
                getFavoriteList()

        }
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        userRepository.loginWithGoogle(idToken)
    }

    fun signOut() {
        userRepository.signOut()
    }

    private fun getFavoriteList() = viewModelScope.launch {
        val list = userRepository.getFavoriteList()
        val movieList: MutableList<Result> = mutableListOf()

        list?.forEach {
            detailsRepository.getMovieDetails(it)?.let { movieList.add(it) }
        }
        if (movieList.isEmpty())
            favoriteLast.value = null
        else
            favoriteLast.value = movieList
    }

    init {
        getCurrentUser()
    }
}