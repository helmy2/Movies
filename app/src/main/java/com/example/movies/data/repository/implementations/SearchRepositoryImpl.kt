package com.example.movies.data.repository.implementations


import android.util.Log
import com.example.movies.data.api.SearchApi
import com.example.movies.data.models.Cast
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.SearchRepository
import javax.inject.Inject

private const val TAG = "SearchRepository"

class SearchRepositoryImpl @Inject constructor(
    private val api: SearchApi,
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
