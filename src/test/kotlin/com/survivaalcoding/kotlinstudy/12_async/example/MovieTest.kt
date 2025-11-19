package com.survivaalcoding.kotlinstudy.`12_async`.example

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class MovieTest {
    @Test
    fun `Movie 인스턴스를 생성할 수 있다`() {
        // given
        val title = "Star Wars"
        val director = "George Lucas"
        val year = 1977

        // when
        val movie = Movie(title, director, year)

        // then
        assertThat(movie.title).isEqualTo(title)
        assertThat(movie.director).isEqualTo(director)
        assertThat(movie.year).isEqualTo(year)
    }

    @Test
    fun `영화 정보를 반환하는 함수에서 역직렬화 된다`() = runBlocking {
        // given
        val title = "Star Wars"
        val director = "George Lucas"
        val year = 1977
        val movie = Movie(title, director, year)

        // when
        val actual = MovieInfo.getMovieInfo()

        // then
        assertThat(actual.title).isEqualTo(title)
        assertThat(actual.director).isEqualTo(director)
        assertThat(actual.year).isEqualTo(year)
        assertThat(actual).isEqualTo(movie)
        assertThat(actual).isNotSameAs(movie)
        Unit
    }

}