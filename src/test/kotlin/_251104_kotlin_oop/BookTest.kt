package _251104_kotlin_oop

import org.junit.Test
import kotlin.test.assertEquals

class BookTest {

    @Test
    fun `book의 생성자들의 값이 잘 바뀌는지 테스트`() {
        //given
        val beforeName = "before"
        val beforePrice = 1000
        val beforeColor = "red"
        val isbn = "123"
        val beforeWeight = 100.0
        val afterName = "after"
        val afterPrice = 1001
        val afterColor = "blue"
        val afterWeight = 101.0
        val book = Book(beforeName, beforePrice, beforeColor, isbn, beforeWeight)
        //when
        book.name = afterName
        book.price = afterPrice
        book.color = afterColor
        book.weight = afterWeight

        //then
        assertEquals(afterName, book.name)
        assertEquals(afterPrice, book.price)
        assertEquals(afterColor, book.color)
        assertEquals(afterWeight, book.weight)


    }

}