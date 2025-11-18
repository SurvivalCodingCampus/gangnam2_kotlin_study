package com.survivalcoding.kotlinstudy.`13_async`

import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year" : 1997}"""

    // Movie 데이터를 리턴
    return Json.decodeFromString<Movie>(json)
}
