package com.example.movies.ui.person

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.person.components.PersonScreenComponent

@Composable
fun PersonScreen(
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    viewModel: PersonViewModel
) {
    LaunchedEffect(key1 = true) {
        viewModel.getPersonDetails(id)
        viewModel.getMovieCredits(id)
        viewModel.getPersonImages(id)
    }
    val personResult by viewModel.personResult
    val creditResult by viewModel.creditsResult
    val personImagesResult by viewModel.personImagesResult

    PersonScreenComponent(personResult, creditResult, personImagesResult, onMovieClick)
}

