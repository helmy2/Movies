package com.example.movies.repository


import android.util.Log
import com.example.movies.api.MovieApi
import com.example.movies.models.Image
import com.example.movies.models.Cast
import com.example.movies.models.Result
import javax.inject.Inject

private const val TAG = "DetailsRepository"

class DetailsRepository @Inject constructor(
    private val api: MovieApi,
) {

    suspend fun getMovieDetails(id: Int): Result? = try {
        val response = api.getMovieDetails(id)
        if (response.isSuccessful)
            response.body()
        else {
            Log.i(TAG, "getMovieDetails: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getMovieDetails: ${e.message}")
        null
    }

    suspend fun getMovieCast(id: Int): List<Cast>? = try {
        val response = api.getMovieCast(id)
        if (response.isSuccessful)
            response.body()?.cast
        else {
            Log.i(TAG, "getMovieCast: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getMovieCast: ${e.message}")
        null
    }

    suspend fun getMovieRecommendations(id: Int): List<Result>? = try {
        val response = api.getMovieRecommendations(id)
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getMovieCast: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getMovieCast: ${e.message}")
        null
    }

    suspend fun getMovieCollection(id: Int): List<Result>? = try {
        val response = api.getMovieCollection(id)
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getMovieCollection: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getMovieCollection: ${e.message}")
        null
    }

    suspend fun getMovieImages(id: Int): List<Image>? = try {
        val response = api.getMovieImages(id)
        if (response.isSuccessful)
            response.body()?.images
        else {
            Log.i(TAG, "getMovieCollection: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getMovieCollection: ${e.message}")
        null
    }
}
