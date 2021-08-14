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
    }

    ///////////////////////////////////////////////////////////

    @GET("movie/popular$API_KEY")
    suspend fun getPopularMovies(): Response<ResultResponse>

    @GET("movie/now_playing$API_KEY")
    suspend fun getNowPlayingMovies(): Response<ResultResponse>

    @GET("movie/top_rated$API_KEY")
    suspend fun getTopRatedMovies(): Response<ResultResponse>

    @GET("movie/upcoming$API_KEY")
    suspend fun getUpcomingMovies(): Response<ResultResponse>

    @GET("discover/movie$API_KEY&page=1&with_genres=16")
    suspend fun getAnimationMovies(): Response<ResultResponse>


    ////////////////////////////////////////////////////////////////

    @GET("movie/{id}$API_KEY")
    suspend fun getMovieDetails(@Path("id") id: Int): Response<Result>

    @GET("movie/{id}/credits$API_KEY")
    suspend fun getMovieCast(@Path("id") id: Int): Response<CastResponse>

    @GET("movie/{id}/recommendations$API_KEY")
    suspend fun getMovieRecommendations(@Path("id") id: Int): Response<ResultResponse>

    @GET("collection/{id}$API_KEY")
    suspend fun getMovieCollection(@Path("id") id: Int): Response<Collection>

    @GET("movie/{id}/images$API_KEY")
    suspend fun getMovieImages(@Path("id") id: Int): Response<ImagesResponse>

    ///////////////////////////////////////////////////////////

    @GET("person/{id}$API_KEY")
    suspend fun getPersonDetails(@Path("id") id: Int): Response<Person>

    @GET("person/{id}/movie_credits$API_KEY")
    suspend fun getMovieCredits(@Path("id") id: Int): Response<CreditResponse>

    @GET("person/{id}/tagged_images$API_KEY")
    suspend fun getTaggedImages(@Path("id") id: Int): Response<TaggedImagesResponse>

//    @GET("trending/all/{time_window}$API_KEY")
//    suspend fun getTrending(@Path("time_window") timeWindow: String): ResultResponse
//
//    @GET("search/multi$API_KEY")
//    suspend fun getSearch(@Query("query") query: String): ResultResponse


//    @GET("tv/{id}/images$API_KEY")
//    suspend fun getTVImages(@Path("id") id: Int): ImagesResponse

//    @GET("person/{id}/images$API_KEY")
//    suspend fun getPersonImages(@Path("id") id: Int): ImagesResponse
}