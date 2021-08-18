package com.example.movies.ui.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Shapes

@Composable
fun GenreChip(
    text: String,
    id: Int ,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface
) {
    Card(
        modifier = modifier
            .padding(end = Padding.mediumPadding)
            .clip(shape = Shapes.small)
            .clickable { onItemClick(id) },
        backgroundColor = backgroundColor
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = Padding.smallPadding, horizontal = Padding.largePadding)
        )
    }
}

