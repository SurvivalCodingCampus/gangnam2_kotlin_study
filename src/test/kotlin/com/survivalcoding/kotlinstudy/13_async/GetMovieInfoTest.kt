package com.survivalcoding.kotlinstudy.`13_async`

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals


class GetMovieInfoTest {
    companion object {
        private const val TITLE = "Star Wars"
        private const val DIRECTOR = "George Lucas"
        private const val YEAR = 1997
    }

    @Test
    fun `title - Star Wars`() = runBlocking {
            val movie = getMovieInfo()

            assertEquals(TITLE, movie.title)
        }

    @Test
    fun `director - George Lucas`() = runBlocking {
        val movie = getMovieInfo()

        assertEquals(DIRECTOR, movie.director)
        }

    @Test
    fun `year - 1997`() = runBlocking {
            val movie = getMovieInfo()

        assertEquals(YEAR, movie.year)
        }
}
