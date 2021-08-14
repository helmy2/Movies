package com.example.movies.ui.person

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.movies.api.MovieApi
import com.example.movies.models.Image
import com.example.movies.models.Person
import com.example.movies.models.Result
import com.example.movies.ui.details.components.ImageList
import com.example.movies.ui.home.components.MoviesList
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.util.DemoMovieDataProvider

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
            Overview(person = person)
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

@Composable
fun Overview(
    person: Person,
    modifier: Modifier = Modifier
) {
    val painter = rememberImagePainter(
        MovieApi.IMAGE_URL_ORIGINAL + person.profilePath,
        builder = {
            crossfade(true)
        },
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(.8f),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painter,
                contentDescription = person.name,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            .3f to Color.Transparent,
                            .9f to MaterialTheme.colors.background,
                        )
                    )
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = person.name,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
        InfoCard(title = "Known For Acting", body = person.knownForDepartment)
        InfoCard(title = "Birthday", body = person.birthday)
        InfoCard(title = "Place of Birth", body = person.placeOfBirth)
        InfoCard(title = "Biography", body = person.biography)
    }
}

@Composable
fun InfoCard(title: String, body: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp)
    )
    Text(
        text = body,
        modifier = Modifier
            .padding(start = 16.dp, top = 8.dp)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OverviewPreview() {
    MoviesTheme(darkTheme = true) {
        Overview(person = DemoMovieDataProvider.person)
    }
}