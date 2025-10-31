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

        assertEquals(2,personList.size)
        assertEquals("홍길동",personList[0].name)
        assertEquals("한석봉",personList[1].name)

    }
}