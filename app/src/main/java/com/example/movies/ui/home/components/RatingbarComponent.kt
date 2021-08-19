package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.util.Ratingbar

@Composable
fun RatingbarComponent(rating: Float) {
    Box(Modifier.padding(vertical = Padding.medium)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Padding.medium)
        ) {
            Ratingbar(
                rating,
                modifier = Modifier
                    .weight(7f)
                    .padding(vertical = Padding.small)
            )
            Spacer(modifier = Modifier.weight(1f))
            RatingAutoSizeText(
                text = "%.1f".format(rating),
                modifier = Modifier
                    .weight(2f)
            )
        }
    }
}

