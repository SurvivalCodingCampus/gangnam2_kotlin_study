package com.survivalcoding.kotlinstudy.`05_inheritance`

import org.junit.Test
import kotlin.test.assertEquals

class PoisonSlimeTest {
    companion object {
        private const val HERO_NAME = "용사"
        private const val HERO_HP = 100
        private const val SLIME_SUFFIX = "A"
        private const val BASE_DAMAGE = 10   // 기본 공격 데미지
        private const val POISON_RATIO = 5  // 독 공격 데미지 들어가는 비율
        private const val INITIAL_POISON_COUNT = 5  // 슬라임이 공격 가능한 횟수
    }

    @Test
    fun `기본 공격 - 용사 HP 10 감소`() {
        // given
        val hero = Hero(HERO_NAME, HERO_HP)
        val slime = Slime(SLIME_SUFFIX)

        // when
        slime.attack(hero)

        // then
        assertEquals(HERO_HP - BASE_DAMAGE, hero.hp)   // 기본 공격 -10
    }
    
    @Test
    fun `독 공격 - 용사 HP, poisonDiscount  감소`() {
        // given
        val hero = Hero(HERO_NAME, HERO_HP)
        val slime = PoisonSlime(SLIME_SUFFIX)

        // when
        slime.attack(hero)

        // then

        val poisonDamage = HERO_HP / POISON_RATIO
        val expectedHp = HERO_HP - BASE_DAMAGE - poisonDamage

        assertEquals(poisonDamage, slime.lastDamage)
        assertEquals(expectedHp, hero.hp)   // 기본 공격 10 + 독 공격 20 = 30 감소
        assertEquals(INITIAL_POISON_COUNT - 1, slime.poisonCount)  // 1 감소
    }

    @Test
    fun `독 공격 X - poisonCount 0`() {
        // given
        val hero = Hero(HERO_NAME, HERO_HP)
        val slime = PoisonSlime(SLIME_SUFFIX)
        repeat(PoisonSlime.INITIAL_POISON_COUNT) { slime.attack(hero) } // 0 이 될때 까지 반복

        val previousHp = hero.hp

        // when
        slime.attack(hero)  // 0일 때 공격이 들어가는지 확인

        // then
        assertEquals(0, slime.poisonCount)
        assertEquals(0, slime.lastDamage) // 독 피해 없음
        assertEquals(previousHp - BASE_DAMAGE, hero.hp) // 조건 a에 따라서  기본 공격은 유효
    }
}