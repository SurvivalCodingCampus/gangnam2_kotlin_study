package com.ezlevup.my.day251118.exercise

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Ex1MovieTest {

    @Test
    fun `영화 생성자`() {
        // given
        val movie = Ex1Movie()

        // when & then
        assertNotNull(movie)
    }

    @Test
    fun `영화 정보 가지고 오기`() {
        runBlocking {
            // given
            //{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""
            val title: String = "Star Wars"
            val director: String = "George Lucas"
            val year: Int = 1977
            val movie = Ex1Movie()

            // when
            val info = movie.getMovieInfo()

            // then
            assertNotNull(info)
            assertEquals(title, info.title)
            assertEquals(director, info.director)
            assertEquals(year, info.year)
        }
    }
}
