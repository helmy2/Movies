package com.example.movies.data.repository


import com.example.movies.data.models.Result


interface DiscoverRepository {

    suspend fun getMovieGenres(genreId: Int, pageNumber: Int): List<Result>?
}
