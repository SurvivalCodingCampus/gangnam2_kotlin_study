package com.survivalcoding.kotlinstudy.`13_async`.practice

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class MovieTest {

    @Test
    fun `title이 Star Wars인지 확인`() = runBlocking {
        val movieInfo = getMovieInfo()
        val expectedTitle = "Star Wars"

        assertEquals(movieInfo.title, expectedTitle)
    }
}