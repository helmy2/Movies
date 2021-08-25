package com.example.movies.data.repository.implementations


import android.util.Log
import com.example.movies.data.api.PersonApi
import com.example.movies.data.models.Image
import com.example.movies.data.models.Person
import com.example.movies.data.models.Result
import com.example.movies.data.repository.repository.PersonRepository
import javax.inject.Inject

private const val TAG = "PersonRepository"

class PersonRepositoryImpl @Inject constructor(
    private val api: PersonApi,
) : PersonRepository {

    override suspend fun getPersonDetails(id: Int): Person? = try {
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

    override suspend fun getMovieCredits(id: Int): List<Result>? = try {
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

    override suspend fun getPersonImages(id: Int): List<Image>? = try {
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
