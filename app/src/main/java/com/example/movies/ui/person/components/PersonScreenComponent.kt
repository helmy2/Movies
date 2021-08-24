package com.example.movies.ui.person.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.data.models.Image
import com.example.movies.data.models.Person
import com.example.movies.data.models.Result
import com.example.movies.ui.details.components.ImageList
import com.example.movies.ui.home.components.MoviesList

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
                ImageList(imageList = it, title = "Tagged Image")
        }
        creditResult?.let {
            MoviesList(
                results = it,
                title = "Movies",
                onItemClick = onMovieClick,
            )
        }
    }
}