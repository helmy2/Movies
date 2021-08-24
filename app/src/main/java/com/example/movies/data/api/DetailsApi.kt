package com.example.movies.data.api

import com.example.movies.data.api.models.CastResponse
import com.example.movies.data.api.models.ImagesResponse
import com.example.movies.data.api.models.ResultResponse
import com.example.movies.data.models.Collection
import com.example.movies.data.models.Result
import com.example.movies.data.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("movie/{id}${Constants.API_KEY}${Constants.Language}")
    suspend fun getMovieDetails(@Path("id") id: Int): Response<Result>

    @GET("movie/{id}/credits${Constants.API_KEY}${Constants.Language}")
    suspend fun getMovieCast(@Path("id") id: Int): Response<CastResponse>

    @GET("movie/{id}/recommendations${Constants.API_KEY}${Constants.Language}")
    suspend fun getMovieRecommendations(@Path("id") id: Int): Response<ResultResponse>

    @GET("collection/{id}${Constants.API_KEY}${Constants.Language}")
    suspend fun getMovieCollection(@Path("id") id: Int): Response<Collection>

    @GET("movie/{id}/images${Constants.API_KEY}")
    suspend fun getMovieImages(@Path("id") id: Int): Response<ImagesResponse>
}