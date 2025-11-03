package com.survivaalcoding.kotlinstudy.`03_encapsulation`.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDate

class PersonTest {
    @Test
    fun `Person 클래스 인스턴스 생성 확인`() {
        // given
        val name = "홍길동"
        val birthYear = 2000

        // when
        val person = Person(name, birthYear)

        // then
        assertThat(person.name).isEqualTo(name)
        assertThat(person.birthYear).isEqualTo(birthYear)
    }

    @Test
    fun `2000년 생의 나이는 25세다`() {
        // given
        val name = "홍길동"
        val birthYear = 2000
        val age = LocalDate.now().year - birthYear

        // when
        val person = Person(name, birthYear)

        // then
        assertThat(person.age).isEqualTo(age)
    }
}