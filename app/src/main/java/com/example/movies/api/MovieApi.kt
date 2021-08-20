package com.example.movies.api

import com.example.movies.api.models.*
import com.example.movies.models.Collection
import com.example.movies.models.Person
import com.example.movies.models.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {

    companion object {
        const val API_KEY = "?api_key=baf62556ad57430e7e61c1ace8490114"
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
        const val IMAGE_URL_ORIGINAL = "https://image.tmdb.org/t/p/original/"
        const val Language="&language=en"
    }

    ///////////////////////////////////////////////////////////

    @GET("movie/popular$API_KEY$Language")
    suspend fun getPopularMovies(): Response<ResultResponse>

    @GET("movie/now_playing$API_KEY$Language")
    suspend fun getNowPlayingMovies(): Response<ResultResponse>

    @GET("movie/top_rated$API_KEY$Language")
    suspend fun getTopRatedMovies(): Response<ResultResponse>

    @GET("movie/upcoming$API_KEY$Language")
    suspend fun getUpcomingMovies(): Response<ResultResponse>

    @GET("discover/movie$API_KEY$Language&page=1&with_genres=16")
    suspend fun getAnimationMovies(): Response<ResultResponse>

    @GET("genre/movie/list$API_KEY$Language")
    suspend fun getGenreListMovies(): Response<GenresListResponse>


//    https://api.themoviedb.org/3/genre/movie/list?api_key=baf62556ad57430e7e61c1ace8490114

    ////////////////////////////////////////////////////////////////

    @GET("movie/{id}$API_KEY$Language")
    suspend fun getMovieDetails(@Path("id") id: Int): Response<Result>

    @GET("movie/{id}/credits$API_KEY$Language")
    suspend fun getMovieCast(@Path("id") id: Int): Response<CastResponse>

    @GET("movie/{id}/recommendations$API_KEY$Language")
    suspend fun getMovieRecommendations(@Path("id") id: Int): Response<ResultResponse>

    @GET("collection/{id}$API_KEY$Language")
    suspend fun getMovieCollection(@Path("id") id: Int): Response<Collection>

    @GET("movie/{id}/images$API_KEY")
    suspend fun getMovieImages(@Path("id") id: Int): Response<ImagesResponse>

    ///////////////////////////////////////////////////////////

    @GET("person/{id}$API_KEY$Language")
    suspend fun getPersonDetails(@Path("id") id: Int): Response<Person>

    @GET("person/{id}/movie_credits$API_KEY$Language")
    suspend fun getMovieCredits(@Path("id") id: Int): Response<CreditResponse>

    @GET("person/{id}/images$API_KEY")
    suspend fun getPersonImages(@Path("id") id: Int): Response<ImagesResponse>

    /////////////////////////////////////////////

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

    ////////////////////////////////////////////

    @GET("discover/movie$API_KEY$Language")
    suspend fun getMovieGenres(
        @Query("with_genres") genresId: Int,
        @Query("page") pageNumber: Int
    ): Response<GenresResponse>


}