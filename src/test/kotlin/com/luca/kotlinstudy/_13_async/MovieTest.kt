package com.luca.kotlinstudy._13_async

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class MovieTest {

    @Test
    fun `title이 Star Wars인지 확인`() = runBlocking {
        val movieTitle = "Star Wars"
        val movie = getMovieInfo()
        assertEquals(movieTitle,movie.title)
    }

}