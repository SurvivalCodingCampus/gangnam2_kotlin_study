package com.hhp227.kotlinstudy.`04_collection`

import junit.framework.TestCase.assertTrue
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `Person 클래스는 이름을 반드시 포함해야 한다`() {
        val person = Person("홍길동")
        assertEquals("홍길동", person.name)
    }

    @Test
    fun `List에 저장된 모든 Person의 이름이 정상적으로 출력된다`() {
        val people = listOf(Person("홍길동"), Person("한석봉"))
        val names = people.map { it.name }

        assertTrue(names.contains("홍길동"))
        assertTrue(names.contains("한석봉"))
        assertEquals(2, names.size)
    }

    @Test
    fun `이름과 나이를 쌍으로 Map에 저장하고 올바르게 매칭되는지 확인한다`() {
        val person1 = Person("홍길동")
        val person2 = Person("한석봉")
        val people = listOf(person1, person2)
        val ages = listOf(20, 25)
        val peopleMap = people.zip(ages).toMap()

        // 검증
        assertEquals(2, peopleMap.size)
        assertEquals(20, peopleMap[person1])
        assertEquals(25, peopleMap[person2])
    }

    @Test
    fun `출력 포맷이 지정된 문자열 형태로 생성되는지 확인한다`() {
        val people = listOf(Person("홍길동"), Person("한석봉"))
        val ages = listOf(20, 25)
        val peopleMap = people.zip(ages).toMap()

        val result = peopleMap.entries.joinToString("\n") { (person, age) ->
            "${person.name}의 나이는 ${age}살"
        }

        val expected = """
            홍길동의 나이는 20살
            한석봉의 나이는 25살
        """.trimIndent()

        assertEquals(expected, result)
    }
}