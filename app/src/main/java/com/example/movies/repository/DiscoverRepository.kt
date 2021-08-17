package com.example.movies.repository


import android.util.Log
import com.example.movies.api.MovieApi
import com.example.movies.models.Result
import javax.inject.Inject

private const val TAG = "DiscoverRepository"

class DiscoverRepository @Inject constructor(
    private val api: MovieApi,
) {

    suspend fun getMovieGenres(genreId: Int, pageNumber: Int): List<Result>? = try {
        val response = api.getMovieGenres(genreId, pageNumber)
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "searchPerson: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "searchPerson: ${e.message}")
        null
    }
}
