package com.example.movies.data.database

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.movies.R
import com.example.movies.ui.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

private const val TAG = "Auth"

class Authentication(
    private val activity: MainActivity
) {
    private val auth: FirebaseAuth = Firebase.auth

    private var resultLauncher: ActivityResultLauncher<Intent>

    init {
        resultLauncher =
            activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
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
                                firebaseAuthWithGoogle(account.idToken!!)
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

    }

    fun addAuthStateListener(
        addAuthStateListener: (it: FirebaseAuth) -> Unit
    ) {
        auth.addAuthStateListener {
            addAuthStateListener(it)
        }
    }

    fun currentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun signInGoogle() {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(activity, gso)

        val signInIntent = googleSignInClient.signInIntent
        resultLauncher.launch(signInIntent)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    Toast.makeText(activity, "You are logged in successfully", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d(TAG, "signInWithCredential:failure")
                    Toast.makeText(activity, "Failure to logged in", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signUp(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.createUserWithEmailAndPassword(email, password).await()
                    Toast.makeText(
                        activity,
                        "You are Sing up successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                } catch (e: Exception) {
                    Log.i(TAG, "createUser: $e.message")
                    launch(Dispatchers.Main) {
                        Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun signIn(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email, password).await()
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            activity,
                            "You are sing In successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: Exception) {
                    Log.i(TAG, "singIn: ${e.message}")
                    launch(Dispatchers.Main) {
                        Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    fun signOut() {
        auth.signOut()
        Toast.makeText(activity, "You are logged out successfully", Toast.LENGTH_SHORT).show()
    }

}