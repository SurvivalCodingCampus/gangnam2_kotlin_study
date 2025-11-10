package com.survivalcoding.kotlinstudy.`07_polymorphism`.practice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ABTest {
    @Test
    fun `A가 어떤 메서드를 호출하는 지 확인`() {
        val obj: X = A()

        obj.a()
    }

    @Test
    fun `y1 y2를 실행했을때 화면에 표시되는 순서 확인`() {
        val y1: Y = A()
        val y2: Y = B()

        y1.a()
        y2.a()
    }
}