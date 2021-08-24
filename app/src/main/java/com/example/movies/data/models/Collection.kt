package com.example.movies.data.models

import com.google.gson.annotations.SerializedName

data class Collection(
    val id: Int,
    val name: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("parts")
    val results: List<Result>
)