package com.example.movies.repository


import android.util.Log
import com.example.movies.api.MovieApi
import com.example.movies.models.Image
import com.example.movies.models.Person
import com.example.movies.models.Result
import javax.inject.Inject

private const val TAG = "PersonRepository"

class PersonRepository @Inject constructor(
    private val api: MovieApi,
) {

    suspend fun getPersonDetails(id: Int): Person? = try {
        val response = api.getPersonDetails(id)
        if (response.isSuccessful)
            response.body()
        else {
            Log.i(TAG, "getPersonDetails: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getPersonDetails: ${e.message}")
        null
    }

    suspend fun getMovieCredits(id: Int): List<Result>? = try {
        val response = api.getMovieCredits(id)
        if (response.isSuccessful)
            response.body()?.result
        else {
            Log.i(TAG, "getMovieCredit: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getMovieCredit: ${e.message}")
        null
    }

    suspend fun getPersonImages(id: Int): List<Image>? = try {
        val response = api.getPersonImages(id)
        if (response.isSuccessful)
            response.body()?.profiles
        else {
            Log.i(TAG, "getPersonImages: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getPersonImages: ${e.message}")
        null
    }

}
