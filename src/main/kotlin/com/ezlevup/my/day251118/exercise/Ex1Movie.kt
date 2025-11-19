package com.ezlevup.my.day251118.exercise

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class Ex1Movie {
    suspend fun getMovieInfo(): Movie {
        delay(1000)
        val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

        return Json.decodeFromString<Movie>(json)
    }
}

@Serializable
data class Movie(
    var title: String,
    var director: String,
    var year: Int,
)

//fun main() = runBlocking {
//    val ex1 = Ex1Movie()
//    val info = ex1.getMovieInfo()
//    println(info.toString())
//}





