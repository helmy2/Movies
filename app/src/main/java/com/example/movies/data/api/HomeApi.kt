package com.example.movies.data.api

import com.example.movies.data.api.models.GenresListResponse
import com.example.movies.data.api.models.ResultResponse
import com.example.movies.data.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET("movie/popular${Constants.API_KEY}${Constants.Language}")
    suspend fun getPopularMovies(): Response<ResultResponse>

    @GET("movie/now_playing${Constants.API_KEY}${Constants.Language}")
    suspend fun getNowPlayingMovies(): Response<ResultResponse>

    @GET("movie/top_rated${Constants.API_KEY}${Constants.Language}")
    suspend fun getTopRatedMovies(): Response<ResultResponse>

    @GET("movie/upcoming${Constants.API_KEY}${Constants.Language}")
    suspend fun getUpcomingMovies(): Response<ResultResponse>

    @GET("discover/movie${Constants.API_KEY}${Constants.Language}&page=1&with_genres=16")
    suspend fun getAnimationMovies(): Response<ResultResponse>

    @GET("genre/movie/list${Constants.API_KEY}${Constants.Language}")
    suspend fun getGenreListMovies(): Response<GenresListResponse>

}