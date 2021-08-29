package com.example.movies.ui.user.components

import android.content.Context
import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

@Composable
fun UserScreenNotLodgedInComponent(
    id: String,
    context: Context,
    launcher: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.medium)
    ) {
        TextButton(onClick = {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(id)
                .requestEmail()
                .build()

            val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, gso)

            val signInIntent = googleSignInClient.signInIntent
            launcher.launch(signInIntent)
        }) {
            Text(text = "Log In With Google", style = Typography.h5)
        }
    }
}