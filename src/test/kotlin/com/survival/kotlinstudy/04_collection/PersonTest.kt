package com.survival.kotlinstudy.`04_collection`

import org.junit.Test
import kotlin.test.assertEquals

class PersonTest {

    @Test
    fun `Person 인스턴스를 2개 생성해 List 에 담고 이름 출력`() {
        val personList = listOf(
            Person(name = "홍길동"),
            Person(name = "한석봉"),
        )

        assertEquals(2, personList.size)
        assertEquals("홍길동", personList[0].name)
        assertEquals("한석봉", personList[1].name)

    }

    @Test
    fun `Person의 이름과 나이를 출력`() {
        val wantOutput = listOf(
            "홍길동의 나이는 20살",
            "한석봉의 나이는 25살"
        )
        val hong = Person(name = "홍길동")
        val han = Person(name = "한석봉")
        hong.age = 20
        han.age = 25

        val personList = listOf(hong, han)
        val actualOutput = personList.map { "${it.name}의 나이는 ${it.age}살" }

        assertEquals(wantOutput, actualOutput)
    }
}