package com.example.movies.repository


import android.util.Log
import com.example.movies.api.MovieApi
import com.example.movies.models.Cast
import com.example.movies.models.Result
import javax.inject.Inject

private const val TAG = "SearchRepository"

class SearchRepositoryImpl @Inject constructor(
    private val api: MovieApi,
) : SearchRepository {

    override suspend fun searchMovie(query: String, pageNumber: Int): List<Result>? = try {
        val response = api.searchMovie(query, pageNumber)
        if (response.isSuccessful)
            response.body()?.results
        else {
            Log.i(TAG, "getTaggedImages: ${response.errorBody()}")
            null
        }
    } catch (e: Exception) {
        Log.i(TAG, "getPersonDetails: ${e.message}")
        null
    }

    override suspend fun searchPerson(query: String, pageNumber: Int): List<Cast>? = try {
        val response = api.searchPerson(query, pageNumber)
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