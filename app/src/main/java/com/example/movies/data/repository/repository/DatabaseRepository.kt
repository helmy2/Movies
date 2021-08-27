package com.example.movies.data.repository.repository

interface DatabaseRepository {
    suspend fun addToFavoriteList(id: Int)
    suspend fun getFavoriteList(): List<Int>
    suspend fun deleteFromFavoriteList(id: Int)
    suspend fun isFavorite(id: Int): Boolean
}
