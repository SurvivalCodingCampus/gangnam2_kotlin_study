package com.sesac.practice.day12

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MovieTest {
    @Test
    fun `Movie 데이터를 역직렬화한다`() = runBlocking {
        // given
        val title = "Star Wars"
        val director = "George Lucas"
        val year = 1977
        val json = """{"title": "$title", "director": "$director", "year": $year}"""
        val delayTimeMillis = 1000L

        // when
        var movie: Movie
        val measureTimeMillis = measureTimeMillis {
            movie = getMovieInfo(json, delayTimeMillis)
        }

        // then
        assertNotNull(movie)
        assertEquals(title, movie.title)
        assertEquals(director, movie.director)
        assertEquals(year, movie.year)

        assertTrue(measureTimeMillis > delayTimeMillis)
    }
}
