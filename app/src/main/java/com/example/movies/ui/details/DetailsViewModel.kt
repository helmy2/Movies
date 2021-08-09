package com.example.movies.ui.details

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
class DetailsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var results: MutableState<Result?> = mutableStateOf(null)
        private set

    fun getPopularMovies(id: Int) = viewModelScope.launch {
        try {
            val response = repository.getMovieDetails(id)
            if (response.isSuccessful) {
                results.value = response.body()
                Log.i(TAG, "getPopularMovies: ${results.value}")
            } else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

}