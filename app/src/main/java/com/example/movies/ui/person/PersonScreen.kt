package com.example.movies.ui.person

import androidx.compose.foundation.layout.*
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
import com.example.movies.ui.details.components.PersonInf
import com.example.movies.ui.home.components.MoviesList

@Composable
fun PersonScreen(
    id: Int,
    onMovieClick: (id: Int) -> Unit,
    viewModel: PersonViewModel = viewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getPersonDetails(id)
        viewModel.getMovieCredits(id)
        viewModel.getTaggedImages(id)
    }
    val personResult by viewModel.personResult
    val creditResult by viewModel.creditsResult
    val taggedImagesResult by viewModel.taggedImagesResult

    PersonScreenComponent(personResult, creditResult, taggedImagesResult, onMovieClick)
}

@Composable
fun PersonScreenComponent(
    person: Person?,
    creditResult: List<Result>?,
    taggedImages: List<Image>?,
    onMovieClick: (id: Int) -> Unit,
) {
    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)
    ) {
        person?.let {
            PersonInf(person = person)
        }
        creditResult?.let {
            MoviesList(
                results = it,
                title = "Movies",
                onItemClick = onMovieClick,
                modifier = Modifier.height(360.dp)
            )
        }
        taggedImages?.let {
            if (taggedImages.isNotEmpty())
                ImageList(imageList = it, title = "Tagged Image")
        }
    }
}

