package com.example.movies.data.api.models


import com.example.movies.data.models.Image
import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("backdrops")
    val images: List<Image>,
    val profiles: List<Image>
)
