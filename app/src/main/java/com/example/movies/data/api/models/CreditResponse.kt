package com.example.movies.data.api.models

import com.example.movies.data.models.Result
import com.google.gson.annotations.SerializedName

data class CreditResponse(
    @SerializedName("cast")
    val result: List<Result>
)
