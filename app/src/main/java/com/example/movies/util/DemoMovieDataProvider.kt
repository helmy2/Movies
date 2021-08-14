package com.example.movies.util

import com.example.movies.models.*
import com.example.movies.models.Collection

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

    val person = Person(
        adult = false,
        birthday = "1990-07-02",
        deathday = 0,
        gender = 1,
        homepage = "null",
        id = 234352,
        imdbId = "nm3053338",
        knownForDepartment = "Acting",
        name = "Margot Robbie",
        placeOfBirth = "Dalby",
        popularity = 50.812,
        profilePath = "/ euDPyqLnuwaWMHajcU3oZ9uZezR . jpg",
        alsoKnownAs = emptyList(),
        biography = "\n" +
                "\n" +
                "Margot Elise Robbie (born 2 July 1990) is an Australian actress and producer. She has received nominations for two Academy Awards and five BAFTA Awards. In 2017, Time magazine named her one of the 100 most influential people in the world, and in 2019, she was ranked among the world's highest-paid actresses.\n" +
                "\n" +
                "Robbie studied drama at Somerset College and began her career in Australian independent films in the late 2000s, before working in the soap opera Neighbours (2008–2011). After moving to America, she starred in the ABC drama series Pan Am (2011–2012) and had her breakthrough role in Martin Scorsese's black comedy film The Wolf of Wall Street (2013). Robbie's profile continued to grow with starring roles as a grifter in Focus (2015), Jane Porter in The Legend of Tarzan (2016), and Harley Quinn in the DC Extended Universe, beginning with Suicide Squad (2016).\n" +
                "\n" +
                "Robbie garnered critical acclaim and nominations for the BAFTA Award and Academy Award for Best Actress for portraying the disgraced figure skater Tonya Harding in the biopic I, Tonya (2017). This acclaim continued for her roles as Queen Elizabeth I in the period drama Mary Queen of Scots (2018), Sharon Tate in the comedy-drama Once Upon a Time in Hollywood (2019), and a fictional Fox News employee in the drama Bombshell (2019). She received BAFTA Award nominations for all three and a nomination for the Academy Award for Best Supporting Actress for the lattermost.\n" +
                "\n" +
                "Robbie is married to the filmmaker Tom Ackerley. They are among the founders of the production company LuckyChap Entertainment, under which she has produced some of her own films, as well as the television series Dollface (2019–present).\n"
    )

}


