package com.example.movies.repository


import com.example.movies.models.Cast
import com.example.movies.models.Image
import com.example.movies.models.Result


interface DetailsRepository {
    suspend fun getMovieDetails(id: Int): Result?
    suspend fun getMovieCast(id: Int): List<Cast>?
    suspend fun getMovieRecommendations(id: Int): List<Result>?
    suspend fun getMovieCollection(id: Int): List<Result>?
    suspend fun getMovieImages(id: Int): List<Image>?
}
