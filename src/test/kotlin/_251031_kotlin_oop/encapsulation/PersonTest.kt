package _251031_kotlin_oop.encapsulation

import org.junit.Assert
import org.junit.Test

class PersonTest {
    @Test
    fun `나이 계산이 정확한지 테스트`() {
        //given
        val person = Person("test", 2000)
        //then
        Assert.assertEquals(25, person.age)
    }


}