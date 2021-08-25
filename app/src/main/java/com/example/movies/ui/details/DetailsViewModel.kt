package com.example.movies.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Cast
import com.example.movies.data.models.Image
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: DetailsRepository
) : ViewModel() {

    var results: MutableState<Result?> = mutableStateOf(null)
        private set

    var castList: MutableState<List<Cast>?> = mutableStateOf(null)
        private set

    var recommendationsList: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var collectionList: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var imageList: MutableState<List<Image>?> = mutableStateOf(null)
        private set

    private fun getMovieDetails(id: Int) = viewModelScope.launch {
        results.value = repository.getMovieDetails(id)
        getMovieCollection()
    }

    private fun getMovieCast(id: Int) = viewModelScope.launch {
        castList.value = repository.getMovieCast(id)
    }

    private fun getMovieRecommendations(id: Int) = viewModelScope.launch {
        recommendationsList.value = repository.getMovieRecommendations(id)
    }

    private fun getMovieCollection() = viewModelScope.launch {
        val id = results.value?.belongsToCollection?.id ?: 0
        collectionList.value = repository.getMovieCollection(id)
    }

    private fun getMovieImages(id: Int) = viewModelScope.launch {
        imageList.value = repository.getMovieImages(id)
    }

    fun getDetails(id: Int) {
        getMovieDetails(id)
        getMovieCast(id)
        getMovieRecommendations(id)
        getMovieImages(id)
    }
}