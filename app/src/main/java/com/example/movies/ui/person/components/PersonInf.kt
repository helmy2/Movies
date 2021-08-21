package com.example.movies.ui.person.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.movies.models.Person
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography
import com.example.movies.util.Constants.IMAGE_URL_ORIGINAL
import com.example.movies.util.DemoMovieDataProvider

@Composable
fun PersonInf(
    person: Person,
    modifier: Modifier = Modifier
) {
    val painter = rememberImagePainter(
        IMAGE_URL_ORIGINAL + person.profilePath,
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
                .aspectRatio(.7f),
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
                    style = Typography.h5,
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PersonInfPreview() {
    MoviesTheme(darkTheme = true) {
        PersonInf(person = DemoMovieDataProvider.person)
    }
}