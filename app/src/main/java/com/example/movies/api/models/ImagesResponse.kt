package com.example.movies.api.models


import com.example.movies.models.Image
import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("backdrops")
    val images: List<Image>,
    val profiles: List<Image>
)
