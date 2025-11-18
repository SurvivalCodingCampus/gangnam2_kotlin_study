package com.hhp227.kotlinstudy.`12_async`

import kotlinx.coroutines.async
import kotlinx.coroutines.test.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MovieTest {
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Test
    fun `Movie의 title 은 Star Wars 인지 테스트`() = runTest {
        val loader = MovieLoader()
        val movie = loader.getMovieInfo()

        assertEquals("Star Wars", movie.title)
    }

    @Test
    fun `Movie의 속성들이 기대값과 맞는지 테스트`() = runTest(dispatcher) {
        val loader = MovieLoader()
        val movie = loader.getMovieInfo()

        assertEquals("Star Wars", movie.title)
        assertEquals("George Lucas", movie.director)
        assertEquals(1977, movie.year)
    }

    @Test
    fun `year속성이 Int형이 맞는지 테스트`() = runTest(dispatcher) {
        val loader = MovieLoader()
        val movie = loader.getMovieInfo()

        assertTrue(movie.year is Int)
    }

    @Test
    fun `딜레이가 1000ms인지 테스트`() = runTest(dispatcher) {
        val loader = MovieLoader()
        val job = async { loader.getMovieInfo() }

        assertEquals(0, currentTime)
        advanceTimeBy(1000)

        job.await()

        assertEquals(1000, currentTime)
    }
}