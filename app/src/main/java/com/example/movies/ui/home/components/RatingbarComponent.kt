package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.util.Ratingbar
import com.google.accompanist.placeholder.material.placeholder

@Composable
fun RatingbarComponent(rating: Float, placeholder: Boolean) {
    BoxWithConstraints(Modifier.padding(vertical = Padding.medium)) {
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
                    .placeholder(placeholder)
                    .padding(vertical = Padding.small)
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