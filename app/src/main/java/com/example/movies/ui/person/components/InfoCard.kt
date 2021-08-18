package com.example.movies.ui.person.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography

@Composable
fun InfoCard(title: String, body: String?) {
    body?.let {
        Text(
            text = title,
            style = Typography.h5,
            modifier = Modifier
                .padding(start = Padding.medium, Padding.large)
        )
        Text(
            text = it,
            modifier = Modifier
                .padding(start =Padding.large, top = Padding.medium)
        )
    }
}