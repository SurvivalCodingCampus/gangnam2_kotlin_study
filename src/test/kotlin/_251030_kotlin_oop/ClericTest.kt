package _251030_kotlin_oop

import junit.framework.TestCase
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ClericTest {


    @Test
    fun `selfAid 작동 테스트`() { //경계값 분석 기법 적용
        //given
        val cleric1 = Cleric("", mp = 0, hp = 10)
        val cleric2 = Cleric("", mp = 4, hp = 10)
        val cleric3 = Cleric("", mp = 5, hp = 10)
        val cleric4 = Cleric("", mp = 6, hp = 10)

        //when
        cleric1.selfAid()
        cleric2.selfAid()
        cleric3.selfAid()
        cleric4.selfAid()

        //then
        assertNotEquals(MAX_HP, cleric1.hp)
        assertNotEquals(MAX_HP, cleric2.hp)
        assertEquals(MAX_HP, cleric3.hp)
        assertEquals(MAX_HP, cleric4.hp)
    }

    @Test
    fun `MP가 회복될 때 MP값이 최대치에서 멈추는지 테스트`() {
        //given
        val cleric = Cleric(mp = 0, name = "")
        //when
        cleric.pray(10)
        //then
        TestCase.assertEquals(MAX_MP, cleric.mp)
    }

    @Test
    fun `name, hp, mp를 이용하여 인스턴스가 만들어지는지 테스트`() {
        //given
        val name = "아서스"
        val cleric = Cleric(name = name, hp = 40, mp = 5)
        //when

        //then
        assertEquals(name, cleric.name)
    }

    @Test
    fun `name과 hp만으로 인스턴스가 만들어지는지 테스트`() {
        //given
        val name = "아서스"
        val cleric = Cleric(name = name, hp = 35)
        //when

        //then
        assertNotEquals(50, cleric.hp)//기본hp값이 적용되면 안됨
        assertEquals(MAX_MP, cleric.mp)

    }

    @Test
    fun `name만으로 인스턴스가 만들어지는지 테스트`() {
        //given
        val name = "아서스"
        val cleric = Cleric(name = name)
        //when

        //then
        assertEquals(MAX_HP, cleric.hp)
        assertEquals(MAX_MP, cleric.mp)
    }
}