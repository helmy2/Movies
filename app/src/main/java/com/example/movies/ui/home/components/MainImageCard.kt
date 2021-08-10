package com.example.movies.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.movies.ui.util.Ratingbar
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun MainImageCard(
    posterUrl: String,
    backgroundUrl: String,
    rating: Float,
    title: String,
    modifier: Modifier = Modifier,
) {
    var placeholder = true

    val posterPainter = rememberImagePainter(
        posterUrl,
        builder = {
            crossfade(true)
        },
    )
    val backgroundPainter = rememberImagePainter(
        backgroundUrl,
        builder = {
            crossfade(true)
        },
    )

    if (posterPainter.state is ImagePainter.State.Success)
        placeholder = false

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = backgroundPainter,
            contentDescription = title,
            modifier = modifier
                .fillMaxHeight(.7f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Image(
                painter = posterPainter,
                contentDescription = title,
                modifier = modifier
                    .fillMaxHeight(.7f)
                    .aspectRatio(.7f)
                    .padding(start = 16.dp)
                    .placeholder(placeholder)
                    .shadow(elevation = 10.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = modifier.fillMaxHeight(.43f))
                Text(
                    text = title,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .placeholder(placeholder)
                )
                Spacer(modifier = modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(.7f)
                ) {
                    Ratingbar(
                        "%.1f".format(rating).toFloat(),
                        modifier = Modifier
                            .weight(7f)
                            .placeholder(placeholder)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = rating.toString(),
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(2f)
                            .placeholder(placeholder),
                    )
                }
            }
        }
    }
}