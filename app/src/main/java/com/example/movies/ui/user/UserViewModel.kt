package com.example.movies.ui.user

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
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    var currentUser: MutableState<FirebaseUser?> = mutableStateOf(null)

    private fun getCurrentUser() = viewModelScope.launch {
        currentUser.value = userRepository.getCurrentUser()
    }

    fun firebaseAuthWithGoogle(idToken: String) {
        userRepository.loginWithGoogle(idToken)
    }

    fun signOut() {
        userRepository.signOut()
    }

    init {
        getCurrentUser()
    }
}