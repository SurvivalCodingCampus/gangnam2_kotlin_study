package com.neouul.sesac.`01-instance-class`

import org.junit.Assert.*
import org.junit.Test
import kotlin.test.assertFails

class Cleric2Test {
    @Test
    fun `Cleric2 클래스의 생성자로 인스턴스를 생성하면 HP, 최대 HP, MP, 최대 MP는 초기치를 만족한다`(){
        // HP, 최대 HP 초기치: 50
        // MP, 최대 MP 초기치: 10

        val cleric2 = Cleric2(name = "A")

        assertEquals(50, cleric2.hp)
        assertEquals(50, cleric2.maxHp)
        assertEquals(10, cleric2.mp)
        assertEquals(10, cleric2.maxMp)
    }

    @Test
    fun `Cleric2 클래스의 selfAid() 메서드를 실행하면 MP 5가 줄어들고 HP가 maxHP까지 늘어난다`(){
        // given: HP를 10으로 설정, 최대 HP는 초기
        val cleric2 = Cleric2()
        cleric2.hp = 10
        val preMp = cleric2.mp

        // when: MP가 5 줄어들고, HP가 최대 HP가 된다
        cleric2.selfAid()

        // then (검증)
        assertEquals(preMp - 5, cleric2.mp)
        assertEquals(cleric2.maxHp, cleric2.hp)
    }

    @Test
    // require(mp >= 5)
    fun `Cleric2 클래스의 selfAid() 메서드가 호출되었는데 MP가 5 미만이라 예외가 발생한다`(){
        // given: HP를 10, MP는 3으로 설정
        val cleric2 = Cleric2()
        cleric2.hp = 10
        cleric2.mp = 3

        assertFails { cleric2.selfAid() }
    }

    @Test
    fun `Cleric2 클래스의 pray(sec) 메서드를 실행하면, 보정된 값만큼 MP를 회복하고 회복된 양을 반환한다`(){
        // given:
        val cleric2 = Cleric2()
        cleric2.mp = 1
        val preMp = cleric2.mp

        // when: 2~4포인트만큼 MP를 회복하고 회복된 양을 반환한다
        val diffMp = cleric2.pray(2)

        // then: 메서드의 반환값이 적절한지 판단한다
        assertEquals(preMp + diffMp, cleric2.mp)
    }

    @Test
    fun `Cleric2 클래스의 pray(sec) 메서드를 실행하면, MP를 회복하고 실제로 회복한 양을 반환하는데 최대 MP보다 더 회복하는 것은 불가능하다`(){
        // given:
        val cleric2 = Cleric2()
        cleric2.mp = 9

        // when: 2~4포인트만큼 MP를 회복하고 회복된 양을 반환한다
        val diffMp = cleric2.pray(2)

        // then: 모든 경우에서 회복량은 최대 MP를 넘지만, 최대 MP보다 더 회복하지는 않았다.
        assertEquals(cleric2.maxMp, cleric2.mp)
        assertEquals(1, diffMp)     // MP가 9였고 회복량이 2~4이므로, 반환값은 항상 1이여야 한다.
    }

}