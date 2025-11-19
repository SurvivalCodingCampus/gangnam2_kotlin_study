package com.sesac.practice.day12

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Movie(
    val title: String,
    val director: String,
    val year: Int,
)

suspend fun getMovieInfo(json: String, delayTimeMillis: Long): Movie {
    delay(delayTimeMillis)

    return Json.decodeFromString<Movie>(json)
}
