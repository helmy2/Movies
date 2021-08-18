package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.movies.api.MovieApi
import com.example.movies.models.Image
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography

@Composable
fun ImageList(imageList: List<Image>, title: String) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Column(Modifier.padding(16.dp)) {
        Text(
            text = title,
            style = Typography.h5,
            modifier = Modifier
                .padding(vertical = Padding.large)
        )
        LazyRow {
            items(items = imageList) {
                ImageItem(
                    MovieApi.IMAGE_URL + it.filePath, it.aspectRatio.toFloat(),
                    Modifier
                        .height(screenHeight * .25f)
                )
            }
        }
    }
}