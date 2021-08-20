package com.example.movies.repository


import com.example.movies.models.Cast
import com.example.movies.models.Result

interface SearchRepository{
    suspend fun searchMovie(query: String, pageNumber: Int): List<Result>?
    suspend fun searchPerson(query: String, pageNumber: Int): List<Cast>?
}
