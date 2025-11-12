package com.survival.kotlinstudy.`06_interface`

import org.junit.Test
import kotlin.test.assertEquals

class ComputerTest {

    @Test
    fun `Computer 인스턴스 생성 테스트`() {

        // given (준비)
        val name = "Mac"
        val price = 2401312
        val color = "Black"
        val markerName = "markerName"
        val computer = Computer(name = name, price = price, color = color, markerName = markerName,weight = 0.0)

        // when (실행)

        // then (검증)
        assertEquals(name, computer.name)
        assertEquals(price, computer.price)
        assertEquals(color, computer.color)
        assertEquals(markerName, computer.markerName)
    }

    @Test
    fun `Computer 인스턴스 생성 후 weight 테스트`() {

        // given (준비)
        val name = "Mac"
        val price = 2401312
        val color = "Black"
        val markerName = "markerName"
        val weight = 50.5

        // when (실행)
        val computer = Computer(name = name, price = price, color = color, markerName = markerName,weight = 0.0)
        computer.weight = weight


        // then (검증)
        assertEquals(name, computer.name)
        assertEquals(price, computer.price)
        assertEquals(color, computer.color)
        assertEquals(markerName, computer.markerName)
        assertEquals(weight, computer.weight)
    }
}