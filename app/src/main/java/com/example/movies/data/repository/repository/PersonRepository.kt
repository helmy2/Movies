package com.example.movies.data.repository.repository


import com.example.movies.data.models.Image
import com.example.movies.data.models.Person
import com.example.movies.data.models.Result

interface PersonRepository {
    suspend fun getPersonDetails(id: Int): Person?
    suspend fun getMovieCredits(id: Int): List<Result>?
    suspend fun getPersonImages(id: Int): List<Image>?
}
