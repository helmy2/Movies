package com.example.movies.ui.person

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movies.models.Image
import com.example.movies.models.Person
import com.example.movies.models.Result
import com.example.movies.ui.details.components.ImageList
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.person.components.PersonInf

@Composable
fun PersonScreen(
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    viewModel: PersonViewModel = viewModel()
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

@Composable
fun PersonScreenComponent(
    person: Person?,
    creditResult: List<Result>?,
    Images: List<Image>?,
    onMovieClick: (id: Int) -> Unit,
) {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        person?.let {
            PersonInf(person = person)
        }
        Images?.let {
            if (Images.isNotEmpty())
                ImageList(imageList = it, title = "Tagged Image",height = 250.dp)
        }
        creditResult?.let {
            MoviesList(
                results = it,
                title = "Movies",
                onItemClick = onMovieClick,
                modifier = Modifier.height(360.dp)
            )
        }
    }
}

