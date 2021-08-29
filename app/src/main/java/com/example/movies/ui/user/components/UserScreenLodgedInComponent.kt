package com.example.movies.ui.user.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.ImagePainter
import com.example.movies.data.models.Result
import com.example.movies.ui.discover.components.DiscoverList
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.example.movies.ui.user.UserViewModel
import com.google.firebase.auth.FirebaseUser

@Composable
fun UserScreenLodgedInComponent(
    viewModel: UserViewModel,
    painter: ImagePainter,
    currentUser: FirebaseUser,
    favoriteList: List<Result>?,
    onItemClick: (id: Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.medium)
    ) {
        Box(Modifier.align(Alignment.End)) {
            TextButton(
                onClick = {
                    viewModel.signOut()
                }) {
                Text(text = "Log out")
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter,
                "User",
                modifier = Modifier
                    .fillMaxWidth(.3f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(Padding.large))
            Column {
                Text(text = currentUser.displayName.toString(), style = Typography.h5)
                Spacer(modifier = Modifier.height(Padding.medium))
                Text(text = currentUser.email.toString(), style = Typography.body2)
            }
        }
        Column {
            favoriteList?.let {
                Text(
                    text = "Favorite List",
                    style = Typography.h5,
                    modifier = Modifier.padding(
                        horizontal = Padding.large,
                        vertical = Padding.medium
                    )
                )
                DiscoverList(
                    results = it,
                    onItemClick = onItemClick,
                    onEndItem = {}
                )
            }
        }
    }
}