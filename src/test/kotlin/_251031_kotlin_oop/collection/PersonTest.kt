package _251031_kotlin_oop.collection

import org.junit.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `인스턴스가 잘 만들어지는지 테스트`() {
        //given
        val person = Person("한석봉")
        //then
        assertEquals("한석봉", person.name)

    }
}