package com.example.movies.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Cast
import com.example.movies.data.models.Image
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.DetailsRepository
import com.example.movies.data.repository.repository.UserRepository
import com.example.movies.ui.util.ConnectionLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository,
    private val userRepository: UserRepository,
    private val connectionLiveData: ConnectionLiveData
) : ViewModel() {

    var connection: MutableState<Boolean> = mutableStateOf(false)
        private set

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

    var isFavorite: MutableState<Boolean?> = mutableStateOf(null)
        private set

    private fun getMovieDetails(id: Int) = viewModelScope.launch {
        results.value = detailsRepository.getMovieDetails(id)
        getMovieCollection()
    }

    private fun getMovieCast(id: Int) = viewModelScope.launch {
        castList.value = detailsRepository.getMovieCast(id)
    }

    private fun getMovieRecommendations(id: Int) = viewModelScope.launch {
        recommendationsList.value = detailsRepository.getMovieRecommendations(id)
    }

    private fun getMovieCollection() = viewModelScope.launch {
        val id = results.value?.belongsToCollection?.id ?: 0
        collectionList.value = detailsRepository.getMovieCollection(id)
    }

    private fun getMovieImages(id: Int) = viewModelScope.launch {
        imageList.value = detailsRepository.getMovieImages(id)
    }

    private fun getIsFavorite(id: Int) = viewModelScope.launch {
        isFavorite.value = userRepository.isFavorite(id)
    }

    fun addToFavoriteList(id: Int) = viewModelScope.launch {
        userRepository.addToFavoriteList(id)
        getIsFavorite(id)
    }

    fun deleteFromFavoriteList(id: Int) = viewModelScope.launch {
        userRepository.deleteFromFavoriteList(id)
        getIsFavorite(id)
    }


    fun getDetails(id: Int) {
        connectionLiveData.observeForever {
            if (it) {
                connection.value = true
                getMovieDetails(id)
                getMovieCast(id)
                getMovieRecommendations(id)
                getMovieImages(id)
                getIsFavorite(id)
            }
        }
    }
}