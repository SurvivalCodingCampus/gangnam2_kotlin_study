package com.survival.kotlinstudy.`05_inheritance`

import com.survival.kotlinstudy.`02_instance_class`.Hero
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class PoisonSlimeTest {

    @Test
    fun `PoisonSlime 인스턴스 생성 확인`() {
        // given (준비)
        val suffix = "A"
        val slimeHp = 50
        val poisonSlime = PoisonSlime(suffix)

        // when (실행)

        // then (검증)
        assertEquals(poisonSlime.suffix, suffix)
        assertEquals(poisonSlime.hp, slimeHp)
        assertIs<PoisonSlime>(poisonSlime)
    }

    @Test
    fun `PoisonSlime 인스턴스의 poisonCount 값 확인`() {
        // given (준비)
        val poisonCount = 5
        val suffix = "A"
        val poisonSlime = PoisonSlime(suffix)

        // when (실행)

        // then (검증)
        assertEquals(poisonSlime.poisonCount, poisonCount)
    }

    @Test
    fun `attack - poisonCount가 남아있으면 기본 공격 + 독 공격을 수행한다`() {
        // given (준비)
        val heroName = "홍길동"
        val heroHp = 100
        val suffix = "A"
        var poisonCount = 5
        val hero = Hero(name = heroName, hp = heroHp)
        val poisonSlime = PoisonSlime(suffix)

        // when (실행)
        poisonSlime.attack(hero)

        // then (검증)

        assertEquals(heroHp - ((heroHp - 10) / 5) - 10, hero.hp)
        assertEquals(--poisonCount, poisonSlime.poisonCount)
    }

    @Test
    fun `attack - poisonCount가 0이면 기본 공격만 수행한다`() {
        // given (준비)
        val heroName = "홍길동"
        val heroHp = 100
        val suffix = "A"
        val hero = Hero(name = heroName, hp = heroHp)
        val poisonSlime = PoisonSlime(suffix)
        // when (실행)
        poisonSlime.poisonCount = 0
        poisonSlime.attack(hero)

        // then (검증)
        // 공격 10 데미지

        assertEquals(heroHp - 10, hero.hp)
        assertEquals(0, poisonSlime.poisonCount)
    }

    @Test
    fun `독공격 가능 횟수 이상으로 공격 불가 및 음수 안 됨 확인`() {
        val heroName = "홍길동"
        val heroHp = 100
        val hero = Hero(heroName, heroHp)
        val slime = PoisonSlime("무시무시 슬라임")
        val count = slime.poisonCount

        for (i in 1..count + 1) {
            slime.attack(hero)
        }

        assertEquals(0, slime.poisonCount)
    }

}