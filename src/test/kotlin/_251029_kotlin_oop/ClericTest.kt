package _251029_kotlin_oop

import junit.framework.TestCase.assertEquals
import org.junit.Test


class ClericTest {

    @Test
    fun `heal테스트`() {
        //given
        val cleric = Cleric()
        //when
        cleric.selfAid()
        //then
        assertEquals(50, cleric.hp)

    }

    @Test
    fun `MP가 없는경우 selfAid가 안되는지 테스트`() {
        //given
        val cleric = Cleric(mp = 0, hp = 0)
        //when
        cleric.selfAid()
        //then
        assertEquals(0, cleric.hp)
    }

    @Test
    fun `MP가 회복될 때 MP값이 최대치에서 멈추는지 테스트`() {
        //given
        val cleric = Cleric(mp = 5)
        //when
        cleric.pray(10)
        //then
        assertEquals(cleric.maxMp, cleric.mp)
    }

    @Test
    fun `기본 생성자로 인스턴스를 만들 경우 이름이 ""인지 테스트`(){
        //given
        val cleric = Cleric()
        //when

        //then
        assertEquals("", cleric.name)
    }
}