package com.example.movies.data.api

import com.example.movies.data.api.models.CreditResponse
import com.example.movies.data.api.models.ImagesResponse
import com.example.movies.data.models.Person
import com.example.movies.data.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonApi {
    @GET("person/{id}${Constants.API_KEY}${Constants.Language}")
    suspend fun getPersonDetails(@Path("id") id: Int): Response<Person>

    @GET("person/{id}/movie_credits${Constants.API_KEY}${Constants.Language}")
    suspend fun getMovieCredits(@Path("id") id: Int): Response<CreditResponse>

    @GET("person/{id}/images${Constants.API_KEY}")
    suspend fun getPersonImages(@Path("id") id: Int): Response<ImagesResponse>
}