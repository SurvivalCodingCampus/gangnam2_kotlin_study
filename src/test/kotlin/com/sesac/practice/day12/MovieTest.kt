package com.sesac.practice.day12

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class MovieTest {
    @Test
    fun `Movie 데이터를 역직렬화한다`() = runTest {
        // given
        val title = "Star Wars"
        val director = "George Lucas"
        val year = 1977
        val json = """{"title": "$title", "director": "$director", "year": $year}"""
        val delayTimeMillis = 1000L

        // when
        val movie = getMovieInfo(json, delayTimeMillis)

        // then
        assertEquals(title, movie.title)
        assertEquals(director, movie.director)
        assertEquals(year, movie.year)
    }
}
