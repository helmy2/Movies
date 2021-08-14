package com.example.movies.api.models

import com.example.movies.models.Image
import com.google.gson.annotations.SerializedName

data class TaggedImagesResponse(
    @SerializedName("results")
    val images: List<Image>
)
