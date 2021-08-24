package com.example.movies.data.api.models

import com.example.movies.data.models.Cast

data class PersonResponse(
    val results: List<Cast>
)