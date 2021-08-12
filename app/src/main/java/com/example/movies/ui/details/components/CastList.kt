package com.example.movies.ui.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies.api.MovieApi
import com.example.movies.models.Cast

@Composable
fun CastList(castList: List<Cast>, onCastClick: (id: Int) -> Unit) {
    Column(Modifier.padding(18.dp)) {
        Text(
            text = "Cast",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 8.dp)
        )
        LazyRow {
            items(items = castList.filter { it.profilePath != null }) { cast ->
                CastItem(
                    url = MovieApi.IMAGE_URL + cast.profilePath,
                    name = cast.name,
                    character = cast.character,
                    modifier = Modifier.width(130.dp).clickable {
                        onCastClick(cast.id)
                    }
                )
            }
        }
    }
}