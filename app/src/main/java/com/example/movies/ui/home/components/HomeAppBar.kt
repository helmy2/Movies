package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.movies.R
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography

@Composable
fun HomeAppBar(
    onActionsClick: () -> Unit,
) {
    TopAppBar(
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Padding.medium)
        ) {
            IconButton(onClick = onActionsClick) {
                Icon(
                    Icons.Filled.Search,
                    "Search",
                )
            }
        }
    }
}