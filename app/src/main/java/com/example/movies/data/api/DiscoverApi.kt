package com.example.movies.data.api

import com.example.movies.data.api.models.GenresResponse
import com.example.movies.data.util.Constants
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