package com.survivaalcoding.kotlinstudy.`04_collections`.example

import org.junit.Test

class Person2Test {
    @Test
    fun `Person 이름과 나이를 쌍으로 출력`() {
        val gildong = Person2("홍길동", 2005)
        val seokbong = Person2("한석봉", 2000)

        val personMap = mapOf(
            gildong.name to gildong.age,
            seokbong.name to seokbong.age
        )

        for ((name, age) in personMap.entries) {
            println("${name}의 나이는 ${age}살")
        }
    }
}