package com.example.movies.data.repository


import androidx.activity.ComponentActivity
import com.example.movies.data.database.Authentication
import com.example.movies.data.models.Genre
import com.example.movies.data.models.Result
import com.example.movies.ui.MainActivity


interface HomeRepository {

    suspend fun getPopularMovies(): List<Result>?
    suspend fun getNowPlayingMovies(): List<Result>?
    suspend fun getTopRatedMovies(): List<Result>?
    suspend fun getUpcomingMovies(): List<Result>?
    suspend fun getAnimationMovies(): List<Result>?
    suspend fun getGenreListMovies(): List<Genre>?
}
