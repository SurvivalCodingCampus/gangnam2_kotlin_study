package com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class ComputerTest {
    @Test
    fun `Computer 객체를 생성할 수 있다`() {
        // given
        val weight = 7.0
        val name = "computer1"
        val price = 500
        val stock = 10
        val color = "white"
        val makeNamee = "ms"

        // when
        val computer = Computer(weight, name, price, stock, color, makeNamee)

        // then
        assertThat(computer.weight).isEqualTo(weight)
        assertThat(computer.name).isEqualTo(name)
        assertThat(computer.price).isEqualTo(price)
        assertThat(computer.stock).isEqualTo(stock)
        assertThat(computer.color).isEqualTo(color)
        assertThat(computer.makeNamee).isEqualTo(makeNamee)
    }

    @Test
    fun `재고를 차감할 수 있다`() {
        // given
        val weight = 7.0
        val name = "computer1"
        val price = 500
        val stock = 10
        val color = "white"
        val makeNamee = "ms"
        val quantity = 2

        val computer = Computer(weight, name, price, stock, color, makeNamee)

        // when
        computer.decreaseStock(quantity)

        // then
        assertThat(computer.stock).isEqualTo(stock - quantity)
    }

    @Test
    fun `재고 개수보다 많이 차감하면 예외가 발생한다`() {
        // given
        val weight = 7.0
        val name = "computer1"
        val price = 500
        val stock = 5
        val color = "white"
        val makeNamee = "ms"
        val quantity = 10

        val computer = Computer(weight, name, price, stock, color, makeNamee)

        // when
        // then
        assertThatThrownBy { computer.decreaseStock(quantity) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `컴퓨터를 대여할 수 있다`() {
        // given
        val weight = 7.0
        val name = "computer1"
        val price = 500
        val stock = 10
        val color = "white"
        val makeNamee = "ms"
        val rentalQuantity = 5

        val computer = Computer(weight, name, price, stock, color, makeNamee)

        // when
        val result = computer.rental(rentalQuantity)

        // then
        assertThat(result).isTrue
        assertThat(computer.stock).isEqualTo(stock - rentalQuantity)
    }

    @Test
    fun `재고가 부족해 컴퓨터를 대여할 수 없다`() {
        // given
        val weight = 7.0
        val name = "computer1"
        val price = 500
        val stock = 3
        val color = "white"
        val makeNamee = "ms"
        val rentalQuantity = 5

        val computer = Computer(weight, name, price, stock, color, makeNamee)

        // when
        val result = computer.rental(rentalQuantity)

        // then
        assertThat(result).isFalse
        assertThat(computer.stock).isEqualTo(stock)
    }

    @Test
    fun `컴퓨터 정보를 확인할 수 있다`() {
        // given
        val weight = 7.0
        val name = "computer1"
        val price = 500
        val stock = 3
        val color = "white"
        val makeNamee = "ms"

        val computerInfo = """
            명칭: $name
            무게: $weight
            가격: $price
            재고: $stock
            색상: $color
            제조사: $makeNamee
        """.trimIndent()

        val computer = Computer(weight, name, price, stock, color, makeNamee)

        // when
        val result = computer.getInfo()

        // then
        assertThat(result).isEqualTo(computerInfo)
    }
}