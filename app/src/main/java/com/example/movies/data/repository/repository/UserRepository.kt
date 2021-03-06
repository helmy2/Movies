package com.example.movies.data.repository.repository

import com.google.firebase.auth.FirebaseUser


interface UserRepository {
    fun currentUser(onAuthChange:(FirebaseUser?)->Unit)
    fun loginWithGoogle(idToken: String)
    fun signUp(email: String, password: String)
    fun signIn(email: String, password: String)
    fun signOut()
    suspend fun addToFavoriteList(id: Int)
    suspend fun getFavoriteList(): List<Int>?
    suspend fun deleteFromFavoriteList(id: Int)
    suspend fun isFavorite(id: Int): Boolean?
}