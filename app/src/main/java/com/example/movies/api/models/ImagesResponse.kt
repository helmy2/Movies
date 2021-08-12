package com.example.movies.api.models


import com.example.movies.models.Backdrop
import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("backdrops")
    val backdrops: List<Backdrop>
)