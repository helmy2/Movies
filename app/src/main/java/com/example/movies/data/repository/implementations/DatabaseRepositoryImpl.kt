package com.example.movies.data.repository.implementations

import android.util.Log
import com.example.movies.data.repository.repository.DatabaseRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


private const val TAG = "DatabaseRepositoryImpl"

class DatabaseRepositoryImpl @Inject constructor(
    firebaseAuth: FirebaseAuth,
    db: FirebaseFirestore
) : DatabaseRepository {

    private val userId = firebaseAuth.currentUser?.uid ?: " "
    private val reference = db.collection("users").document(userId).collection("movies")

    override suspend fun addToFavoriteList(id: Int) {
        if (userId != " ") {
            reference.add(hashMapOf(Pair("id", id)))
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }

    override suspend fun getFavoriteList(): List<Int> {
        if (userId != " ") {
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
        return emptyList()
    }

    override suspend fun deleteFromFavoriteList(id: Int) {
        if (userId != " ") {
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

    override suspend fun isFavorite(id: Int): Boolean {
        if (userId != " ") {
            val personQuery = reference
                .whereEqualTo("id", id)
                .get()
                .await()

            return personQuery.documentChanges.isNotEmpty()
        }
        return false
    }
}