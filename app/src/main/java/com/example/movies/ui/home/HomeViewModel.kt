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
import kotlin.random.Random

private const val TAG = "DetailsViewModel"

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var result: MutableState<Result?> = mutableStateOf(null)
        private set

    var popularResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    fun getPopularMovies() = viewModelScope.launch {
        try {
            val response = repository.getPopularMovies()
            if (response.isSuccessful){
                popularResults.value = response.body()?.results
            }else {
                Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            }
        } catch (e :Exception){
            Log.i(TAG, "getPopularMovies: ${e.message}")
        }
    }

    init {
        val list = listOf(436969, 497698, 451048, 337404, 729720)
        getPopularMovies()
    }
}