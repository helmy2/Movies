package com.example.movies.data.api.models

import com.example.movies.data.models.Result

data class ResultResponse(
    val page: String,
    val results: List<Result>
)


