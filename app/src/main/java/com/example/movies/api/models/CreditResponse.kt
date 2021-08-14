package com.example.movies.api.models

import com.example.movies.models.Result
import com.google.gson.annotations.SerializedName

data class CreditResponse(
    @SerializedName("cast")
    val result: List<Result>
)
