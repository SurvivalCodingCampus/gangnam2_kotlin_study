package _251031_kotlin_oop.encapsulation

import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class PersonTest {
    @Test
    fun `나이 계산이 정확한지 테스트`() {
        //given
        val person = Person("test", 2000)
        //when
        val expectedAge = LocalDate.now().year-person.birthYear

        //then
        Assert.assertEquals(expectedAge, person.age)
    }


}