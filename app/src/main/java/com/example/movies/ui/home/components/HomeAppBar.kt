package com.example.movies.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.rememberImagePainter
import com.example.movies.R
import com.example.movies.ui.theme.Padding
import com.google.firebase.auth.FirebaseUser

@Composable
fun HomeAppBar(
    onSearchClick: () -> Unit,
    onUserClick: () -> Unit,
    currentUser: FirebaseUser?,
) {
    val painter = rememberImagePainter(
        currentUser?.photoUrl ?: "",
        builder = {
            crossfade(true)
            error(R.drawable.ic_placeholder_user)
        },
    )

    TopAppBar(
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Padding.medium),

            ) {
            IconButton(onClick = onUserClick) {
                Image(
                    painter,
                    "User",
                    modifier = Modifier.fillMaxSize().padding(Padding.small).clip(CircleShape)
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
