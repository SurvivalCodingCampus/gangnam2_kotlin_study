package com.survivalcoding.kotlinstudy.`02_instance_class`

import kotlin.test.Test
import kotlin.test.assertEquals

class ClericTest2 {
    @Test
    fun `클래릭의 이름, HP, MP를 지정하여 인스턴스`() {
        val cleric = Cleric(name = "아서스", hp = 40, mp = 5)

        assertEquals(cleric.name, "아서스")
        assertEquals(cleric.hp, 40)
        assertEquals(cleric.mp, 5)
    }

    @Test
    fun `클래릭의 이름, HP만 지정하여 인스턴스`() {
        val cleric = Cleric(name = "아서스", hp = 35)

        assertEquals(cleric.name, "아서스")
        assertEquals(cleric.hp, 35)
        assertEquals(cleric.mp, 10)
    }

    @Test
    fun `클래릭의 이름만 지정하여 인스턴스`() {
        val cleric = Cleric("아서스")

        assertEquals(cleric.name, "아서스")
        assertEquals(cleric.hp, 50)
        assertEquals(cleric.mp, 10)
    }
}