package com.example.movies.data.repository


import android.util.Log
import com.example.movies.data.api.DiscoverApi
import com.example.movies.data.models.Result
import javax.inject.Inject

private const val TAG = "DiscoverRepository"

class DiscoverRepositoryImpl @Inject constructor(
    private val api: DiscoverApi,
) : DiscoverRepository{

    override suspend fun getMovieGenres(genreId: Int, pageNumber: Int): List<Result>? = try {
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
