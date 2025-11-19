package _251118_coroutine

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int
)

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

    return Json.decodeFromString(json)

}