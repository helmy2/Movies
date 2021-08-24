package com.example.movies.data.repository


import android.util.Log
import androidx.activity.ComponentActivity
import com.example.movies.data.api.HomeApi
import com.example.movies.data.database.Authentication
import com.example.movies.data.models.Genre
import com.example.movies.data.models.Result
import com.example.movies.ui.MainActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val TAG = "HomeRepository"

class HomeRepositoryImpl @Inject constructor(
    private val api: HomeApi,
) : HomeRepository {

    override suspend fun getPopularMovies(): List<Result>? = try {
        val response = api.getPopularMovies()
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getPopularMovies: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getPopularMovies: ${e.message}")
        null
    }

    override suspend fun getNowPlayingMovies(): List<Result>? = try {
        val response = api.getNowPlayingMovies()
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getNowPlayingMovies: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getNowPlayingMovies: ${e.message}")
        null
    }

    override suspend fun getTopRatedMovies(): List<Result>? = try {
        val response = api.getTopRatedMovies()
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getTopRatedMovies: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getTopRatedMovies: ${e.message}")
        null
    }

    override suspend fun getUpcomingMovies(): List<Result>? = try {
        val response = api.getUpcomingMovies()
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getUpcomingMovies: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getUpcomingMovies: ${e.message}")
        null
    }

    override suspend fun getAnimationMovies(): List<Result>? = try {
        val response = api.getAnimationMovies()
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getAnimationMovies: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getAnimationMovies: ${e.message}")
        null
    }

    override suspend fun getGenreListMovies(): List<Genre>? = try {
        val response = api.getGenreListMovies()
        if (response.isSuccessful)
            response.body()?.genres
        else {
            Log.i(TAG, "getGenreListMovies: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getGenreListMovies: ${e.message}")
        null
    }

}
