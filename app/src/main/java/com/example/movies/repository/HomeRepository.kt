package com.example.movies.repository


import com.example.movies.models.Genre
import com.example.movies.models.Result


interface HomeRepository {

    suspend fun getPopularMovies(): List<Result>?
    suspend fun getNowPlayingMovies(): List<Result>?
    suspend fun getTopRatedMovies(): List<Result>?
    suspend fun getUpcomingMovies(): List<Result>?
    suspend fun getAnimationMovies(): List<Result>?
    suspend fun getGenreListMovies(): List<Genre>?
}
