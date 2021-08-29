package com.example.movies.data.repository.implementations

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.movies.data.repository.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

private const val TAG = "UserRepositoryImpl"

class UserRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val db: FirebaseFirestore
) : UserRepository {

    override fun currentUser(onAuthChange: (FirebaseUser?) -> Unit) {
        firebaseAuth.addAuthStateListener {
            onAuthChange(it.currentUser)
        }
    }

    override fun loginWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d(TAG, "signInWithCredential:failure")
                }
            }
    }

    override fun signUp(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                } catch (e: Exception) {
                    Log.i(TAG, "createUser: $e.message")
                }
            }
        }
    }

    override fun signIn(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    firebaseAuth.signInWithEmailAndPassword(email, password).await()
                    launch(Dispatchers.Main) {

                    }
                } catch (e: Exception) {
                    Log.i(TAG, "singIn: ${e.message}")

                }
            }
        }
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }

    override suspend fun addToFavoriteList(id: Int) {
        val userId = firebaseAuth.currentUser?.uid
        userId?.let {
            val reference = db.collection("users").document(userId).collection("movies")
            reference.add(hashMapOf(Pair("id", id)))
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }

    override suspend fun getFavoriteList(): List<Int>? {
        val userId = firebaseAuth.currentUser?.uid
        userId?.let {
            val reference = db.collection("users").document(userId).collection("movies")
            val querySnapshot = reference
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }.await()
            Log.i(TAG, "onCreate: ${querySnapshot.documents}")
            val sb: MutableList<Int> = mutableListOf()
            for (document in querySnapshot.documents) {
                val id = document["id"].toString().toInt()
                id.let { sb.add(it) }
            }
            return sb
        }
        return null
    }

    override suspend fun deleteFromFavoriteList(id: Int) {
        val userId = firebaseAuth.currentUser?.uid
        userId?.let {
            val reference = db.collection("users").document(userId).collection("movies")
            val personQuery = reference
                .whereEqualTo("id", id)
                .get()
                .await()
            if (personQuery.documents.isNotEmpty()) {
                for (document in personQuery) {
                    reference.document(document.id)
                        .delete()
                        .addOnSuccessListener {
                            Log.d(TAG, "deletePerson: success")
                        }
                        .addOnFailureListener { e ->
                            Log.d(TAG, "deletePerson: ${e.message}")
                        }
                }
            }
        }

    }

    override suspend fun isFavorite(id: Int): Boolean? {
        val userId = firebaseAuth.currentUser?.uid
        userId?.let {
            val reference = db.collection("users").document(userId).collection("movies")
            val personQuery = reference
                .whereEqualTo("id", id)
                .get()
                .await()

            return personQuery.documentChanges.isNotEmpty()
        }
        return null
    }
}