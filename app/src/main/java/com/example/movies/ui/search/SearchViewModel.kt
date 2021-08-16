package com.example.movies.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.models.Cast
import com.example.movies.models.Result
import com.example.movies.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var searchResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set
    var personResults: MutableState<List<Cast>?> = mutableStateOf(null)
        private set

    private fun searchMovie(query: String) = viewModelScope.launch {
        searchResults.value = repository.searchMovie(query)
    }

    private fun searchPerson(query: String) = viewModelScope.launch {
        personResults.value = repository.searchPerson(query)
    }

    fun search(value: String) {
            searchMovie(value)
            searchPerson(value)

    }
}