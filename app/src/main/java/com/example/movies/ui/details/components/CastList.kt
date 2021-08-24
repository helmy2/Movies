package com.example.movies.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.data.models.Cast
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.example.movies.data.util.Constants.IMAGE_URL

@Composable
fun CastList(castList: List<Cast>, onCastClick: (id: Int) -> Unit) {
    Column(Modifier.padding(Padding.large)) {
        Text(
            text = "Cast",
            style = Typography.h5,
            modifier = Modifier
                .padding(vertical = Padding.medium)
        )
        LazyRow {
            items(items = castList.filter { it.profilePath != "" }) { cast ->
                CastItem(
                    url = IMAGE_URL + cast.profilePath,
                    name = cast.name,
                    character = cast.character,
                    id = cast.id,
                    onItemClick = onCastClick,
                    modifier = Modifier
                )
            }
        }
    }
}