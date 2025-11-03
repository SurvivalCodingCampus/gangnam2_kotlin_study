package com.ezlevup.my.day05.exercise2

import org.junit.Assert.*
import org.junit.Test

class PersonTest {
    @Test
    fun `Person 생성자`() {
        //given
        val testName = "lee"
        val testBirthYear = 1980
        val person = Person(name = testName, birthYear = testBirthYear)

        // then
        assertEquals(testName, person.name)
        assertEquals(testBirthYear, person.birthYear)
    }

    @Test
    fun `Person 이름이 빈 문자열이면 예외 1`() {
        // given
        val testName = ""
        val testBirthYear = 1980
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val person = Person(name = testName, birthYear = testBirthYear)
        }
        assertTrue(exception.message?.contains("이름은 최소") ?: false)
    }

    @Test
    fun `Person 이름이 빈 문자열이면 예외 2`() {
        // given
        val testName = "ab"
        val testBirthYear = 1980
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val person = Person(name = testName, birthYear = testBirthYear)
        }
        assertTrue(exception.message?.contains("이름은 최소") ?: false)
    }

    @Test
    fun `Person 이름이 너무 길면 예외`() {
        // given
        val testName = "abcdabcdasdf"
        val testBirthYear = 1980
        val exception = assertThrows(IllegalArgumentException::class.java) {
            val person = Person(name = testName, birthYear = testBirthYear)
        }
        assertTrue(exception.message?.contains("이름은 최대") ?: false)
    }

    @Test
    fun `Person 이름 수정 불가`() {
        //given
        val testName = "lee"
        val testBirthYear = 1980
        val person = Person(name = testName, birthYear = testBirthYear)

        // when
        // person.name = "kim" // 컴파일 에러 발생이 목표

        // then
        assertEquals(testName, person.name)
        assertEquals(testBirthYear, person.birthYear)
    }

    @Test
    fun `Person 나이 값 가지고 오기`() {
        //given
        val testName = "lee"
        val testBirthYear = 1980
        val person = Person(name = testName, birthYear = testBirthYear)

        // when
        // person.age = 30 // 컴파일 에러 발생이 목표
        // 현재 나이 계산
        val age = java.time.Year.now().value - testBirthYear

        // then
        assertEquals(age, person.age)
    }
}
