package com.survival.kotlinstudy.asynchronous

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieTest {

    @Test
    fun `Movie 클래스 생성 테스트`() = runBlocking {
        // given (준비)
        val expectedTitle = "Star Wars"
        val expectedDirector = "George Lucas"
        val expectedYear = 1977

        // when (실행)
        val movie = getMovieInfo()

        // then (검증)
        assertEquals(movie.title, expectedTitle)
        assertEquals(movie.director, expectedDirector)
        assertEquals(movie.year, expectedYear)

    }
}