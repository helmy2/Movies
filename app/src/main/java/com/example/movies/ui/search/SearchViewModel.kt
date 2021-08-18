package com.example.movies.ui.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.models.Cast
import com.example.movies.models.Result
import com.example.movies.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
) : ViewModel() {

    var movieResults: MutableStateFlow<List<Result>> = MutableStateFlow(emptyList())
        private set

    var personResults: MutableStateFlow<List<Cast>> = MutableStateFlow(emptyList())
        private set

    var searchText = mutableStateOf("")
    var indexState = mutableStateOf(0)

    private val moviePageNumber = mutableStateOf(1)
    private val personPageNumber = mutableStateOf(1)

    private fun searchMovie() = viewModelScope.launch {
        val response = repository.searchMovie(searchText.value)
        response?.let {
            movieResults.value = it
        }
    }

    fun addSearchMovie() = viewModelScope.launch {
        val response: MutableList<Result> = movieResults.value as MutableList<Result>
        repository.searchMovie(searchText.value, moviePageNumber.value)?.let {
            response.addAll(it)
            moviePageNumber.value++
        }
        movieResults.value = response
    }

    private fun searchPerson() = viewModelScope.launch {
        val response = repository.searchPerson(query = searchText.value)
        response?.let {
            personResults.value = it
        }
    }

    fun addSearchPerson() = viewModelScope.launch {
        val response: MutableList<Cast> = personResults.value as MutableList<Cast>
        repository.searchPerson(searchText.value, personPageNumber.value)?.let {
            response.addAll(it)
            personPageNumber.value++
        }
        personResults.value = response
    }


    fun search() {
        searchMovie()
        searchPerson()
    }

}