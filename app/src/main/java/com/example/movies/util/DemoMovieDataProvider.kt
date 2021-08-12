package com.example.movies.util

import com.example.movies.models.Cast
import com.example.movies.models.Collection
import com.example.movies.models.Genre
import com.example.movies.models.Result

object DemoMovieDataProvider {

    val movie = Result(
        id = 1,
        title = "Joker",
        releaseDate = "2020",
        voteAverage = 4.5,
        genres = listOf(
            Genre(1, "Action"),
            Genre(1, "Fantasy"),
            Genre(1, "Adventure"),
            Genre(1, "Action"),
            Genre(1, "Fantasy"),
            Genre(1, "Adventure"),
        ),
        posterPath = "https://cdnb.artstation.com/p/assets/images/images/017/022/569/medium/amirhosein-naseri-new-age.jpg",
        backdropPath = "https://cdnb.artstation.com/p/assets/images/images/017/022/569/medium/amirhosein-naseri-new-age.jpg",
        overview = "This is a blockbuster movie starring Jaquin Phoenix by DC comics",
        adult = true,
        tagline = "Joker is here",
        budget = 1223322,
        revenue = 1233343433,
        runtime = 130,
        homepage = "https://dc.com",
        status = "Running",
        voteCount = 30000,
        belongsToCollection = Collection(1, "", "", "", emptyList()),
        imdbId = "",
        originalLanguage = "",
        originalTitle = "",
        popularity = 9.1,
        video = false
    )

    val movies = listOf(
        movie,
        movie.copy(id = 2, title = "Batman"),
        movie.copy(id = 3, title = "Avengers"),
        movie.copy(id = 4, title = "Tenent"),
        movie.copy(id = 5, title = "Mulan"),
        movie.copy(id = 6, title = "Mulan"),
        movie.copy(id = 7, title = "Mulan"),
        movie.copy(id = 8, title = "Mulan"),
        movie.copy(id = 9, title = "Mulan")
    )

    val castList = listOf(
        Cast(
            castId = 0,
            creditId = "58433f95c3a3684813001d9f",
            id = 12835,
            name = "Vin Diesel",
            profilePath = "rwSXluNWZAluYMOEWBxkPmckES.jpg",
            character = "Dominic Toretto",
        ),
        Cast(
            castId = 19,
            creditId = "5 d11ce8092514131e9ba6ace",
            id = 17647,
            name = "Michelle Rodriguez",
            profilePath = "soXPKCMmOxT7oyfGsMUHB6YHLcC.jpg",
            character = "Letty Ortiz"
        ),
        Cast(
            castId = 1,
            creditId = "58433f b5c3a3684813001db8",
            id = 8169,
            name = "Tyrese Gibson",
            profilePath = "jxoy4fbXNKFQtBdK73cLXEz3ufS . jpg",
            character = "Roman Pearce"
        ),
        Cast(
            castId = 37,
            creditId = "5 d82ada4869e75001e0c385e",
            id = 8171,
            name = "Ludacris",
            profilePath = "erkJijujhe48vhJ8iCEtVpNEeVn . jpg",
            character = "Tej Parker"
        ),
        Cast(
            castId = 22,
            creditId = "5 d11cebd0e0a26641aca2468",
            id = 56446,
            name = "John Cena",
            profilePath =
            "6E ZaBiQHx3Xlz3j0D6ttDxHXaxr . jpg",
            character = "Jakob Toretto"
        ),
    )
}


