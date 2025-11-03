package com.survivalcoding.kotlinstudy.`05_inheritance`.practice

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class PoisonSlimeTest {
    @Test
    fun `포이즌 슬라임이 잘 생성되는지 확인`() {
        val poisonSlime = PoisonSlime()

        assertEquals(poisonSlime.suffix, "PoisonSlime")
    }

    @Test
    fun `공격할때 포이즌 카운트가 있으면 독 데미지가 추가로 들어가는지 확인`() {
        val expectedHeroHp = 60     // 히어로의 hp 예상값
        val expectedPoisonCount = 4     // 포이즌 카운트 예상값
        val poisonSlime = PoisonSlime()
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        poisonSlime.attack(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(poisonSlime.poisonCount, expectedPoisonCount)
    }

    @Test
    fun `공격할때 포이즌 카운트가 없으면 기본 공격만 들어가는지 확인`() {
        val expectedHeroHp = 90     // 히어로의 hp 예상값
        val expectedPoisonCount = 0     // 포이즌 카운트 예상값
        val poisonCount = 0         // 테스트용 포이즌 카운트
        val poisonSlime = PoisonSlime(poisonCount)
        val hero = Hero(DEFAULT_HERO_NAME, HERO_TEST_HP)

        poisonSlime.attack(hero)

        assertEquals(hero.hp, expectedHeroHp)
        assertEquals(poisonSlime.poisonCount, expectedPoisonCount)
    }

    companion object {
        const val DEFAULT_HERO_NAME = "슈퍼맨"
        const val HERO_TEST_HP = 100     // 히어로의 테스트용 hp값
    }
}