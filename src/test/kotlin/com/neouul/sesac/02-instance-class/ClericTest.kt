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
        val cleric1 = Cleric(name = "Ju", HP = 10)
        val preMP = cleric1.MP

        // when (실행)
        cleric1.selfAid()

        // then (검증)
        assertEquals(preMP - 5, cleric1.MP)
        assertEquals(cleric1.maxHP, cleric1.HP)
    }

}