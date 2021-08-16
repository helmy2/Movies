package com.example.movies.api.models

import com.example.movies.models.Cast

data class PersonResponse(
    val results: List<Cast>
)