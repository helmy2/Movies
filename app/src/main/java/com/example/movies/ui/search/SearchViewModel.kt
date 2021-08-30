package com.example.movies.ui.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Cast
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.SearchRepository
import com.example.movies.ui.util.ConnectionLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository,
    private val connectionLiveData: ConnectionLiveData
) : ViewModel() {
    var connection = mutableStateOf(false)
        private set

    var movieResults: MutableState<List<Result>?> = mutableStateOf(null)
        private set
    var personResults: MutableState<List<Cast>?> = mutableStateOf(null)
        private set

    var searchText = mutableStateOf("")
    var indexState = mutableStateOf(0)

    private val moviePageNumber = mutableStateOf(1)
    private val personPageNumber = mutableStateOf(1)


    private fun searchMovie() = viewModelScope.launch {
        movieResults.value = repository.searchMovie(searchText.value,1)
    }

    fun addSearchMovie() = viewModelScope.launch {
        val response: MutableList<Result> = mutableListOf()
        movieResults.value?.let { response.addAll(it) }

        repository.searchMovie(searchText.value, moviePageNumber.value)?.let {
            response.addAll(it)
            moviePageNumber.value++
        }
        movieResults.value = response
    }

    private fun searchPerson() = viewModelScope.launch {
        personResults.value = repository.searchPerson(query = searchText.value,1)
    }

    fun addSearchPerson() = viewModelScope.launch {
        val response: MutableList<Cast> = mutableListOf()
        personResults.value?.let { response.addAll(it) }

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

    init {
        connectionLiveData.observeForever {
            connection.value = it
        }
    }
}