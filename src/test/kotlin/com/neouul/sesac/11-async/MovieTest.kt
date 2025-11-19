package com.neouul.sesac.`11-async`

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MovieTest {
    @Test
    fun `Movie의 인스턴스가 잘 생성되는가`() {
        val title = "스타워즈"
        val director = "루카스"
        val year = 1977
        val movie = Movie(title, director, year)

        assertEquals(title, movie.title)
        assertEquals(director, movie.director)
        assertEquals(year, movie.year)
    }

    @Test
    fun `getMovieInfo()가 적절히 동작하는가`() = runBlocking {
        val movie = getMovieInfo()

        assertEquals("Star Wars", movie.title)
        assertEquals("George Lucas", movie.director)
        assertEquals(1977, movie.year)
    }
}