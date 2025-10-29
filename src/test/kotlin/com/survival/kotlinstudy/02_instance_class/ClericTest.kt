package com.survival.kotlinstudy.`02_instance_class`

import org.junit.Test
import kotlin.test.assertEquals

class ClericTest {

    @Test
    fun `Cleric 클래스 선언 시 초기 HP MP, 최대 HP MP 확인하기`() {
        val cleric = Cleric(name = "성직자")
        assertEquals(50,cleric.hp)
        assertEquals(50,cleric.maxHp)
        assertEquals(10,cleric.mp)
        assertEquals(10,cleric.maxMp)
    }

}