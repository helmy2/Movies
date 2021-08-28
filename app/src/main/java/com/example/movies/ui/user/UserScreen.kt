package com.example.movies.ui.user

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import com.example.movies.R
import com.example.movies.data.models.Result
import com.example.movies.ui.discover.components.DiscoverList
import com.example.movies.ui.theme.Padding
import com.example.movies.ui.theme.Typography
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseUser

private const val TAG = "UserScreen"

@Composable

fun UserScreen(
    viewModel: UserViewModel, onMovieClick: (id: Int) -> Unit,
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val data: Intent? = result.data
                data?.let {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                    val exception = task.exception
                    if (task.isSuccessful) {
                        try {
                            // Google Sign In was successful, authenticate with Firebase
                            val account = task.getResult(ApiException::class.java)!!
                            Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                            viewModel.firebaseAuthWithGoogle(account.idToken!!)
                        } catch (e: ApiException) {
                            // Google Sign In failed, update UI appropriately
                            Log.w(TAG, "Google sign in failed ${e.message}")
                        }
                    } else {
                        Log.w(TAG, exception.toString())
                    }
                }
            }
        }
    )

    val currentUser = remember { viewModel.currentUser }
    val favoriteList: List<Result>? by viewModel.favoriteLast
    LaunchedEffect(key1 = favoriteList, block = {
        Log.i(TAG, "UserScreen: $favoriteList")
    })

    val id = stringResource(id = R.string.default_web_client_id)
    val context = LocalContext.current
    UserScreenComponent(
        currentUser.value,
        favoriteList,
        id,
        context,
        launcher,
        onMovieClick,
        viewModel
    )
}

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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(Padding.medium)
    ) {
        if (currentUser == null) {
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
        } else {
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
        }

        favoriteList?.let {
            Text(
                text = "Favorite List",
                style = Typography.h5,
                modifier = Modifier.padding(vertical = Padding.medium)
            )
            DiscoverList(
                results = it,
                onItemClick = onItemClick,
                onEndItem = {}
            )
        }
    }
}