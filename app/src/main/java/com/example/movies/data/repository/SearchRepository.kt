package com.example.movies.data.repository


import com.example.movies.data.models.Cast
import com.example.movies.data.models.Result

interface SearchRepository{
    suspend fun searchMovie(query: String, pageNumber: Int): List<Result>?
    suspend fun searchPerson(query: String, pageNumber: Int): List<Cast>?
}
