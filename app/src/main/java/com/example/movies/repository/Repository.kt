package com.example.movies.repository


import android.util.Log
import com.example.movies.api.MovieApi
import com.example.movies.models.Image
import com.example.movies.models.Cast
import com.example.movies.models.Person
import com.example.movies.models.Result
import javax.inject.Inject

private const val TAG = "Repository"

class Repository @Inject constructor(
    private val api: MovieApi,
) {

    ////////////////////////////////// Details Screen //////////////////////////////////

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


    ////////////////////////////////// Home Screen //////////////////////////////////

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

    ////////////////////////////////// Person Screen //////////////////////////////////

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

////////////////////////////////////////////////////////////////////

    suspend fun searchMovie(query: String, pageNumber: Int = 1): List<Result>? = try {
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

    suspend fun searchPerson(query: String, pageNumber: Int = 1): List<Cast>? = try {
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

    ////////////////////////////////////////////////

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
