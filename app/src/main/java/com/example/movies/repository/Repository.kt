package com.example.movies.repository


import com.example.movies.api.MovieApi
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: MovieApi,
) {
    suspend fun getMovieDetails(id: Int) = api.getMovieDetails(id)

    suspend fun getPopularMovies() = api.getPopularMovies()
    suspend fun getNowPlayingMovies() = api.getNowPlayingMovies()
    suspend fun getNowPlayingArabicMovies() = api.getNowPlayingArabicMovies()
    suspend fun getTopRatedMovies() = api.getTopRatedMovies()
    suspend fun getUpcomingMovies() = api.getUpcomingMovies()
    suspend fun getAnimationMovies() = api.getAnimationMovies()
}