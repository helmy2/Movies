package com.example.movies.ui.user.components

import android.content.Context
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.Composable
import coil.compose.rememberImagePainter
import com.example.movies.R
import com.example.movies.data.models.Result
import com.example.movies.ui.user.UserViewModel
import com.google.firebase.auth.FirebaseUser

@Composable
fun UserScreenComponent(
    currentUser: FirebaseUser?,
    favoriteList: List<Result>?,
    id: String,
    context: Context,
    launcher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    onItemClick: (id: Int) -> Unit,
    viewModel: UserViewModel
) {
    val painter = rememberImagePainter(
        currentUser?.photoUrl ?: "",
        builder = {
            crossfade(true)
            error(R.drawable.ic_placeholder_user)
        },
    )

    if (currentUser == null) {
        UserScreenNotLodgedInComponent(id, context, launcher)
    } else {
        UserScreenLodgedInComponent(viewModel, painter, currentUser, favoriteList, onItemClick)
    }

}