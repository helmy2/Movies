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
    onNavigationClick: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    Icons.Filled.Menu,
                    null,
                )
            }
        },
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