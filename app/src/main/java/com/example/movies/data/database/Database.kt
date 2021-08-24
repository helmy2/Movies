//package com.example.movies.data.database
//
//import android.util.Log
//import com.google.firebase.ktx.Firebase
//
//private const val TAG = "Database"
//class Database {
//    private val db = Firebase.firestore.collection("users")
//    fun addData(userId: String, person: Person) {
//        db.document(userId).collection("movies").add(person)
//            .addOnSuccessListener { documentReference ->
//                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                Log.w(TAG, "Error adding document", e)
//            }
//    }
//
//    suspend fun getData(userId: String): String {
//        val querySnapshot = db.document(userId).collection("movies")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    Log.d(TAG, "${document.id} => ${document.data}")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents.", exception)
//            }.await()
//
//        Log.i(TAG, "onCreate: ${querySnapshot.documents}")
//
//        val sb: MutableList<Person> = mutableListOf()
//        for (document in querySnapshot.documents) {
//            val person = document.toObject(Person::class.java)
//            person?.let { sb.add(it) }
//        }
//        return sb.toString()
//    }
//
//    suspend fun deleteData(userId: String, person: Person) {
//        val personQuery = db.document(userId).collection("movies")
//            .whereEqualTo("firstName", person.firstName)
//            .get()
//            .await()
//
//        if (personQuery.documents.isNotEmpty()) {
//            for (document in personQuery) {
//                db.document(userId).collection("movies").document(document.id)
//                    .delete()
//                    .addOnSuccessListener {
//                        Log.d(TAG, "deletePerson: success")
//                    }
//                    .addOnFailureListener { e ->
//                        Log.d(TAG, "deletePerson: ${e.message}")
//                    }
//            }
//        }
//
//    }
//}