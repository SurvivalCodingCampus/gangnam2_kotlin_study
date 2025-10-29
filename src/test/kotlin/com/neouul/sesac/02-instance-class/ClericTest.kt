package com.neouul.sesac.`02-instance-class`

import org.junit.Assert.*
import org.junit.Test

class ClericTest {
    @Test
    fun `Cleric 클래스의 생성자로 인스턴스를 생성하면 HP, 최대 HP, MP, 최대 MP는 초기치를 만족한다`(){
        // HP, 최대 HP 초기치: 50
        // MP, 최대 MP 초기치: 10

        val cleric = Cleric(name = "A")

        assertEquals(50, cleric.HP)
        assertEquals(50, cleric.maxHP)
        assertEquals(10, cleric.MP)
        assertEquals(10, cleric.maxMP)
    }

    @Test
    fun `Cleric 클래스의 selfAid() 메서드를 실행하면 MP 5가 줄어들고 HP가 maxHP까지 늘어난다`(){
        // given: HP를 10으로 설정, 최대 HP는 초기
        val cleric = Cleric(name = "Ju", HP = 10)
        val preMP = cleric.MP

        // when: MP가 5 줄어들고, HP가 최대 HP가 된다
        cleric.selfAid()

        // then (검증)
        assertEquals(preMP - 5, cleric.MP)
        assertEquals(cleric.maxHP, cleric.HP)
    }

    @Test
    fun `Cleric 클래스의 pray(sec) 메서드를 실행하면, 보정된 값만큼 MP를 회복하고 회복된 양을 반환한다`(){
        // given:
        val cleric = Cleric(name = "A", MP = 1)
        val preMP = cleric.MP

        // when: 2~4포인트만큼 MP를 회복하고 회복된 양을 반환한다
        val diffMP = cleric.pray(2)

        // then: 메서드의 반환값이 적절한지 판단한다
        assertEquals(preMP + diffMP, cleric.MP)
    }

    @Test
    fun `Cleric 클래스의 pray(sec) 메서드를 실행하면, MP를 회복하고 실제로 회복한 양을 반환하는데 최대 MP보다 더 회복하는 것은 불가능하다`(){
        // given:
        val cleric = Cleric(name = "A", MP = 9)

        // when: 2~4포인트만큼 MP를 회복하고 회복된 양을 반환한다
        cleric.pray(2)

        // then: 모든 경우에서 회복량은 최대 MP를 넘지만, 최대 MP보다 더 회복하지는 않았다.
        assertEquals(cleric.maxMP, cleric.MP)
    }

}