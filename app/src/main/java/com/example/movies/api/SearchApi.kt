package com.example.movies.api

import com.example.movies.api.models.*
import com.example.movies.util.Constants.API_KEY
import com.example.movies.util.Constants.Language
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchApi {

    @GET("search/movie$API_KEY$Language")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("page") pageNumber: Int
    ): Response<ResultResponse>


    @GET("search/person$API_KEY$Language")
    suspend fun searchPerson(
        @Query("query") query: String,
        @Query("page") pageNumber: Int
    ): Response<PersonResponse>

}