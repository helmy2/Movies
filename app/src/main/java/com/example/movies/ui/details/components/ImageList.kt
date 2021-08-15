package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies.api.MovieApi
import com.example.movies.models.Image

@Composable
fun ImageList(imageList: List<Image>, title: String, height: Dp = 150.dp) {
    Column(Modifier.padding(16.dp)) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 8.dp)
        )
        LazyRow {
            items(items = imageList) {
                ImageItem(
                    MovieApi.IMAGE_URL + it.filePath, it.width / it.height.toFloat(),
                    Modifier
                        .height(height)
                )
            }
        }
    }
}