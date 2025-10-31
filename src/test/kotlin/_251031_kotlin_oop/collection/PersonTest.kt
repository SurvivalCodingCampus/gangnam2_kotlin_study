package _251031_kotlin_oop.collection

import org.junit.Assert.assertEquals
import org.junit.Test

class PersonTest {
    @Test
    fun `나이 계산이 정확한지 테스트`() {
        //given
        val person = Person("test", 2000)
        //then
        assertEquals(25, person.age)
    }


}