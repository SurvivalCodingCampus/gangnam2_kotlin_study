package com.survivaalcoding.kotlinstudy.`04_collections`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class PersonTest {
    @Test
    fun `사람 이름은 빈 문자일 수 없다`() {
        // given
        // when
        // then
        assertThatThrownBy { Person("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `사람 이름은 공백일 수 없다`() {
        // given
        // when
        // then
        assertThatThrownBy { Person(" ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자 혹은 공백일 수 없습니다.")
    }

    @Test
    fun `사람 이름 경계값`() {
        // given
        val nameLength2 = Person("김신")
        val nameLength3 = Person("홍길동")

        // when
        // then
        assertThatThrownBy { Person("김") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 ${Person.NAME_LENGTH_RULE}자 이상이어야 합니다.")
        assertThat(nameLength2).isNotNull
        assertThat(nameLength3).isNotNull
    }

    @Test
    fun `List Person 목록 이름 출력`() {
        val gildong = Person("홍길동")
        val seokbong = Person("한석봉")

        val persons = listOf(gildong, seokbong)

        persons.forEach {
            println("안녕하세요. ${it.name}입니다.")
        }
    }
}