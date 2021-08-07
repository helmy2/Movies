package com.example.movies.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.movies.ui.util.Ratingbar
import com.google.accompanist.placeholder.material.placeholder


@Composable
fun ImageCard(
    url: String,
    title: String,
    rating: Float,
    modifier: Modifier = Modifier,
) {
    var placeholder = true

    val painter = rememberImagePainter(
        url,
        builder = {
            crossfade(true)
        },
    )

    if (painter.state is ImagePainter.State.Success)
        placeholder = false

    Card(modifier = modifier.aspectRatio(.52f)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = title,
                modifier = Modifier
                    .aspectRatio(.7f)
                    .clip(RoundedCornerShape(10.dp))
                    .placeholder(placeholder),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp,end = 8.dp,top = 8.dp)
                    .placeholder(placeholder)
            )
            BoxWithConstraints(Modifier.padding(vertical = 8.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Ratingbar(
                        rating,
                        modifier = Modifier
                            .weight(7f)
                            .placeholder(placeholder)
                            .padding(vertical = 4.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = rating.toString(),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(2f)
                            .placeholder(placeholder),
                    )
                }
            }
        }
    }
}
