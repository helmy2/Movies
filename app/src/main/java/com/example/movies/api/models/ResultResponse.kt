package com.example.movies.api.models

import com.example.movies.models.Result

data class ResultResponse(
    val page: String,
    val results: List<Result>
)


