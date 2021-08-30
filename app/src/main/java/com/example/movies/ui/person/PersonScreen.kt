package com.example.movies.ui.person

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.ui.person.components.PersonScreenComponent
import com.example.movies.ui.util.NoConnectionScreen

@Composable
fun PersonScreen(
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    viewModel: PersonViewModel
) {
    LaunchedEffect(key1 = true) {
        viewModel.getData(id)
    }
    val personResult by viewModel.personResult
    val creditResult by viewModel.creditsResult
    val personImagesResult by viewModel.personImagesResult

    if (viewModel.connection.value)
        PersonScreenComponent(personResult, creditResult, personImagesResult, onMovieClick)
    else
        NoConnectionScreen()
}

