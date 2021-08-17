package com.example.movies.repository


import android.util.Log
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import javax.inject.Inject

private const val TAG = "HomeRepository"

class HomeRepository @Inject constructor(
    private val api: MovieApi,
) {

    suspend fun getPopularMovies(): List<Result>? = try {
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

    suspend fun getNowPlayingMovies(): List<Result>? = try {
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

    suspend fun getTopRatedMovies(): List<Result>? = try {
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

    suspend fun getUpcomingMovies(): List<Result>? = try {
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

    suspend fun getAnimationMovies(): List<Result>? = try {
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
}
