package com.example.movies.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Ratio
import com.example.movies.ui.theme.Shapes
import com.example.movies.ui.theme.Typography

@Composable
fun CastItem(
    url: String,
    name: String,
    character: String?,
    id: Int,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val painter = rememberImagePainter(
        url,
        builder = {
            crossfade(true)
        },
    )
    Card(
        modifier = modifier
            .width(screenWidth * .35f)
            .padding(end = Padding.mediumPadding)
            .clip(Shapes.medium)
            .clickable {
                onItemClick(id)
            }
    ) {
        Column {
            Image(
                painter = painter,
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(Ratio.profile),
                contentScale = ContentScale.Crop
            )
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Typography.body1,
                modifier = Modifier.padding(Padding.mediumPadding),
            )
            character?.let {
                Text(
                    text = it,
                    style = Typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(
                        start = Padding.mediumPadding,
                        end = Padding.mediumPadding,
                        bottom = Padding.mediumPadding
                    )
                )
            }
        }
    }
}