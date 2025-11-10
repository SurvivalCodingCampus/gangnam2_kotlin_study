package _251104_kotlin_oop

import org.junit.Test
import kotlin.test.assertEquals

class ComputerTest {
    @Test
    fun `computer의 생성자들의 값이 잘 바뀌는지 테스트`() {
        //given
        val beforeName = "before"
        val beforePrice = 1000
        val beforeColor = "red"
        val makerName = "LG"
        val beforeWeight = 100.0
        val afterName = "after"
        val afterPrice = 1001
        val afterColor = "blue"
        val afterWeight = 101.0
        val computer = Computer(beforeName, beforePrice, beforeColor, makerName, beforeWeight)
        //when
        computer.name = afterName
        computer.price = afterPrice
        computer.color = afterColor
        computer.weight = afterWeight
        //then
        assertEquals(afterName, computer.name)
        assertEquals(afterPrice, computer.price)
        assertEquals(afterColor, computer.color)
        assertEquals(afterWeight, computer.weight)
    }

}