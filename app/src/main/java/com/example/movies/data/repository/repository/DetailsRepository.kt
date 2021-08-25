package com.example.movies.data.repository.repository


import com.example.movies.data.models.Cast
import com.example.movies.data.models.Image
import com.example.movies.data.models.Result


interface DetailsRepository {
    suspend fun getMovieDetails(id: Int): Result?
    suspend fun getMovieCast(id: Int): List<Cast>?
    suspend fun getMovieRecommendations(id: Int): List<Result>?
    suspend fun getMovieCollection(id: Int): List<Result>?
    suspend fun getMovieImages(id: Int): List<Image>?
}
