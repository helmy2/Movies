package com.example.movies.ui.home.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable

@Composable
fun HomeAppBar(
    onActionsClick: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {},
        actions = {
            IconButton(onClick = onActionsClick) {
                Icon(
                    Icons.Filled.Search,
                    null,
                )
            }
        },
        title = {},
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
    )
}