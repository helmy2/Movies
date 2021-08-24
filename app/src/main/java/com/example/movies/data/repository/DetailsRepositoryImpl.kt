package com.example.movies.data.repository


import android.util.Log
import com.example.movies.data.api.DetailsApi
import com.example.movies.data.models.Cast
import com.example.movies.data.models.Image
import com.example.movies.data.models.Result
import javax.inject.Inject

private const val TAG = "DetailsRepository"

class DetailsRepositoryImpl @Inject constructor(
    private val api: DetailsApi,
) : DetailsRepository {

    override suspend fun getMovieDetails(id: Int): Result? = try {
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

    override suspend fun getMovieCast(id: Int): List<Cast>? = try {
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

    override suspend fun getMovieRecommendations(id: Int): List<Result>? = try {
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

    override suspend fun getMovieCollection(id: Int): List<Result>? = try {
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

    override suspend fun getMovieImages(id: Int): List<Image>? = try {
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
