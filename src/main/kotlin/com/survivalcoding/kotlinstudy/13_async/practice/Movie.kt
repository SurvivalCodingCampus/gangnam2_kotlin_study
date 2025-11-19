package com.survivalcoding.kotlinstudy.`13_async`.practice

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int,
)

suspend fun getMovieInfo(): Movie {
    delay(2000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1997}"""

    return Json.decodeFromString<Movie>(json)
}