package com.example.movies.util

fun String.toYearFormat(): String {
    if (length > 4)
        return this.substring(startIndex = 0,endIndex = 4)
    return this
}