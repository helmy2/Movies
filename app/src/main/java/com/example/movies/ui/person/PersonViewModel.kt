package com.example.movies.ui.person

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.models.Image
import com.example.movies.data.models.Person
import com.example.movies.data.models.Result
import com.example.movies.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "PersonViewModel"

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val repository: PersonRepository
) : ViewModel() {

    var personResult: MutableState<Person?> = mutableStateOf(null)
        private set

    var creditsResult: MutableState<List<Result>?> = mutableStateOf(null)
        private set

    var personImagesResult: MutableState<List<Image>?> = mutableStateOf(null)
        private set


    fun getPersonDetails(id: Int) = viewModelScope.launch {
        personResult.value = repository.getPersonDetails(id)
        Log.i(TAG, "getPersonDetails: ${personResult.value.toString()}")
    }

    fun getMovieCredits(id: Int) = viewModelScope.launch {
        creditsResult.value = repository.getMovieCredits(id)
    }

    fun getPersonImages(id: Int) = viewModelScope.launch {
        personImagesResult.value = repository.getPersonImages(id)
    }

}