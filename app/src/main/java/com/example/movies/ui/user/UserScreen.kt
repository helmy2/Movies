package com.example.movies.ui.user

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.movies.R
import com.example.movies.data.models.Result
import com.example.movies.ui.user.components.UserScreenComponent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

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