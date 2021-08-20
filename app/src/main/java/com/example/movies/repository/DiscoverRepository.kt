package com.example.movies.repository


import com.example.movies.models.Result


interface DiscoverRepository {

    suspend fun getMovieGenres(genreId: Int, pageNumber: Int): List<Result>?
}
