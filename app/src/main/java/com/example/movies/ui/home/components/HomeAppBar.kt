package com.example.movies.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movies.ui.theme.Padding

@Composable
fun HomeAppBar(
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
) {
    TopAppBar(
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,

        ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Padding.medium),

            ) {
            IconButton(onClick = onMenuClick) {
                Icon(
                    Icons.Filled.Menu,
                    "Menu",
                )
            }
            IconButton(onClick = onSearchClick) {
                Icon(
                    Icons.Filled.Search,
                    "Search",
                )
            }
        }
    }
}
