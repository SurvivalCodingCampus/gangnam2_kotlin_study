package com.hhp227.kotlinstudy.`05_inheritance`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlin.test.Test

class PoisonSlimeTest {
    @Test
    fun `일반 공격과 독 공격이 동시에 적용되어야 한다`() {
        val hero = Hero(hp = 100)
        val poisonSlime = PoisonSlime("A")

        poisonSlime.attack(hero)

        // 일반 공격(10) + 독 공격(20) = 총 30 감소
        assertEquals(70, hero.hp)
        assertEquals(4, poisonSlime.poisonCount)
    }

    @Test
    fun `poisonCount가 0이 되면 독 공격이 더 이상 발생하지 않아야 한다`() {
        val hero = Hero(hp = 100)
        val poisonSlime = PoisonSlime("A")

        repeat(5) { poisonSlime.attack(hero) }
        val hpAfter5Attacks = hero.hp

        poisonSlime.attack(hero)

        assertEquals(hpAfter5Attacks - 10, hero.hp)
        assertEquals(0, poisonSlime.poisonCount)
    }

    @Test
    fun `공격시 hero의 hp가 0이하로 떨어질 수 있다`() {
        val hero = Hero(hp = 100)
        val poisonSlime = PoisonSlime("A")

        repeat(10) { poisonSlime.attack(hero) }

        assertTrue(hero.hp < 0)
    }

    @Test
    fun `poisonCount 초기값은 5이어야 한다`() {
        val poisonSlime = PoisonSlime("A")

        assertEquals(5, poisonSlime.poisonCount)
    }
}