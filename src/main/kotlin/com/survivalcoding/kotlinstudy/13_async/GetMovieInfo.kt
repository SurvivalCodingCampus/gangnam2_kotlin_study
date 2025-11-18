package com.survivalcoding.kotlinstudy.`13_async`

import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year" : 1997}"""

    // TODO: Movie 데이터를 리턴하도록 작성
    val result = Json.decodeFromString<Movie>(json)
    return result
}
