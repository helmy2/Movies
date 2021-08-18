package com.example.movies.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.ImagePainter
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Shapes
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun MovieItemComponent(
    modifier: Modifier,
    onItemClick: (id: Int) -> Unit,
    id: Int,
    painter: ImagePainter,
    title: String,
    placeholder: Boolean,
    rating: Float
) {
    Card(
        modifier = modifier
            .aspectRatio(.52f)
            .clip(Shapes.medium)
            .clickable { onItemClick(id) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = title,
                modifier = Modifier
                    .aspectRatio(.7f)
                    .placeholder(placeholder),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Padding.medium, end = Padding.medium, top = Padding.medium)
                    .placeholder(placeholder)
            )
            RatingbarComponent(rating, placeholder)
        }
    }
}