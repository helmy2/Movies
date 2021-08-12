package com.example.movies.models


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("cast_id")
    val castId: Int,
    @SerializedName("credit_id")
    val creditId: String,
    val id: Int,
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String,
    val character: String
)

