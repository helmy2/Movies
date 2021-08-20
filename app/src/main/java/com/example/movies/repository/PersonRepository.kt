package com.example.movies.repository


import com.example.movies.models.Image
import com.example.movies.models.Person
import com.example.movies.models.Result

interface PersonRepository {
    suspend fun getPersonDetails(id: Int): Person?
    suspend fun getMovieCredits(id: Int): List<Result>?
    suspend fun getPersonImages(id: Int): List<Image>?
}
