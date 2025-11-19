package com.survival.kotlinstudy.asynchronous

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val title: String? = null,
    val director: String? = null,
    val year: Int? = null,
)

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

    val movie = Json.decodeFromString<Movie>(json)

    return movie
}