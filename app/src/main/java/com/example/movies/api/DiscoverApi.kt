package com.example.movies.api

import com.example.movies.api.models.GenresResponse
import com.example.movies.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverApi {
    @GET("discover/movie${Constants.API_KEY}${Constants.Language}")
    suspend fun getMovieGenres(
        @Query("with_genres") genresId: Int,
        @Query("page") pageNumber: Int
    ): Response<GenresResponse>
}