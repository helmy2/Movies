package com.example.movies.ui.discover

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.DiscoverRepository
import com.example.movies.ui.util.ConnectionLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val repository: DiscoverRepository,
    private val connectionLiveData: ConnectionLiveData
) : ViewModel() {
    var connection: MutableState<Boolean> = mutableStateOf(false)
        private set

    var results: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    private val pageNumber = mutableStateOf(1)

    fun getMovieGenres(id: Int) = viewModelScope.launch {
        val response: MutableList<Result> = mutableListOf()

        results.value?.let { response.addAll(it) }
        repository.getMovieGenres(id, pageNumber.value)?.let {
            response.addAll(it)
            pageNumber.value++
        }

        results.value = response
    }

    init {
        connectionLiveData.observeForever {
            connection.value = it
        }
    }

}