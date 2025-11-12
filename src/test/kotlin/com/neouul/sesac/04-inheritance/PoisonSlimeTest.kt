package com.neouul.sesac.`04-inheritance`

import org.junit.Assert.*
import org.junit.Test

class PoisonSlimeTest {
    @Test
    fun `PoisonSlime의 인스턴스가 정상적으로 생성되는 경우`() {
        val poisonSlime = PoisonSlime("A")

        assertEquals("A", poisonSlime.suffix)
        assertEquals(50, poisonSlime.hp)
        assertEquals(PoisonSlime.POISON_NUMBER, poisonSlime.poisonCount)
        assertTrue(poisonSlime is Slime)
    }

    @Test
    fun `PoisonSlime의 attack 메서드가 Hero의 HP를 적절히 감소시키는 경우`() {
        // given: 용사의 최대 HP는 80, 현재 HP는 최대 HP가 아닌 값으로 설정
        val poisonSlime = PoisonSlime("A")
        val hero = Hero("홍길동", 50)
        val previousHP = hero.hp
        val previousCount = poisonSlime.poisonCount
        val poisonSlimeDamage = hero.maxHp / 5 + Slime.DAMAGE

        // when: poisonSlime의 poisonCount가 0이 아닐 때,
        // 최대 HP의 1/5 + 10만큼 공격 받음
        poisonSlime.attack(hero)

        // then
        assertEquals(Hero.MAX_HP, hero.maxHp)
        assertNotEquals(0, previousCount)
        assertTrue(previousCount in 1..PoisonSlime.POISON_NUMBER)
        assertEquals(previousHP - poisonSlimeDamage, hero.hp)
    }

    @Test
    fun `PoisonSlime의 attack 메서드에서 Hero에게 추가 공격은 하지 않는 경우`() {
        // given
        val poisonSlime = PoisonSlime("A")
        val hero = Hero("홍길동", 50)
        val previousHP = hero.hp

        // when
        poisonSlime.poisonCount = 0
        poisonSlime.attack(hero)

        // then
        assertEquals(0, poisonSlime.poisonCount)
        assertEquals(previousHP - Slime.DAMAGE, hero.hp)
    }

    // SuperHero의 인스턴스는 Hero가 대상인 테스트로 통과할텐데 따로 테스트가 필요할까??
    @Test
    fun `PoisonSlime의 attack 메서드가 SuperHero의 HP를 적절히 감소시키는 경우`() {
        // given: 용사의 최대 HP는 100, 현재 HP는 최대 HP가 아닌 값으로 설정
        val poisonSlime = PoisonSlime("A")
        val superHero = SuperHero("슈퍼홍길동", 50, null)
        val previousHP = superHero.hp
        val previousCount = poisonSlime.poisonCount
        val poisonSlimeDamage = superHero.maxHp / 5 + Slime.DAMAGE

        // when: poisonSlime의 poisonCount가 0이 아닐 때,
        // 최대 HP의 1/5 + 10만큼 공격 받음
        poisonSlime.attack(superHero)

        // then
        assertEquals(SuperHero.MAX_HP, superHero.maxHp)
        assertNotEquals(0, previousCount)
        assertTrue(previousCount in 1..PoisonSlime.POISON_NUMBER)
        assertEquals(previousHP - poisonSlimeDamage, superHero.hp)
    }

    @Test
    fun `PoisonSlime의 attack 메서드에서 SuperHero에게 추가 공격은 하지 않는 경우`() {
        // given
        val poisonSlime = PoisonSlime("A")
        val superHero = SuperHero("슈퍼홍길동", 50, null)
        val previousHP = superHero.hp

        // when
        poisonSlime.poisonCount = 0
        poisonSlime.attack(superHero)

        // then
        assertEquals(0, poisonSlime.poisonCount)
        assertEquals(previousHP - Slime.DAMAGE, superHero.hp)
    }
}