package com.luca.kotlinstudy._05_inheritance

import com.luca.kotlinstudy._02_instance_class.HERO_MAX_HP
import com.luca.kotlinstudy._02_instance_class.Hero
import com.luca.kotlinstudy._04_collection.availableName
import org.junit.Assert.*
import org.junit.Test

class PoisonSlimeTest {

    @Test
    fun `공격할 때마다 포이즌 횟수가 차감이 된다`() {
        val poisonSlime = PoisonSlime(slimeName)
        val hero = Hero(availableName, hp = HERO_MAX_HP)
        val minusCount = 1

        val before = poisonSlime.poisonCount
        poisonSlime.attack(hero)
        val after = poisonSlime.poisonCount

        assertEquals(before - minusCount, after)
    }

    @Test
    fun `포이즌 횟수 소진 후 기본 공격만 해야한다`() {
        val poisonSlime = PoisonSlime(slimeName)
        val hero = Hero(availableName, hp = HERO_MAX_HP)
        val expectedDamage = 10
        poisonSlime.poisonCount = 0

        val beforeHp = hero.hp
        poisonSlime.attack(hero)
        val afterHp = hero.hp

        assertEquals(beforeHp - expectedDamage, afterHp)
        assertEquals(expectedCount, poisonSlime.poisonCount)
    }

    @Test
    fun `슬라임이 공격했을 때 용사의 체력이 닳는다`() {
        val poisonSlime = PoisonSlime(slimeName)
        val hero = Hero(availableName, hp = HERO_MAX_HP)
        val expectedDamage = 20

        val beforeHp = hero.hp
        poisonSlime.attack(hero)
        val afterHp = hero.hp

        assertEquals(beforeHp - expectedDamage, afterHp)
    }

    @Test
    fun `포이즌 횟수에 음수가 들어가면 0으로 교정된다`() {
        val poisonSlime = PoisonSlime(slimeName)
        poisonSlime.poisonCount = -5

        assertEquals(expectedCount, poisonSlime.poisonCount)
    }

    companion object {
        val slimeName = "A"
        val expectedCount = 0
    }
}

/*
copainon object를 쓰면 하나의 인스턴스를 공유하게 된다.
그렇게 됐을 때 전역객체가 되어버려서 변경된 상태 (poisonCount 감소)가 되어버려서 다음 테스트에 영향이 끼친다.
이는 테스트 간 독립성이 깨진다. 테스트가 동시에 실행되거나 순서가 달라져도 안전해야 한다는 단위 테스트 원칙에 위배가 된다.
lateinit var 는 나중에 초기화하겠다 하지만 널은 아니다 라는 뜻이다.
@Before 를 붙이면 테스트 실행 전에 자동으로 한 번씩 호출된다. 그 안에서 새 인스턴스로 초기화를 해주면 모든 테스트가 독립적으로 hero 와 slime을 받게된다.

class PoisonSlimeTest {
    private lateinit var poisonSlime: PoisonSlime
    private lateinit var hero: Hero


    @Before
    fun setUp() {
        poisonSlime = PoisonSlime("A")
        hero = Hero("루카스", hp = HERO_MAX_HP)
    }

    @Test
    fun `공격할 때마다 포이즌 횟수가 차감이 된다`() {
        val minusCount = 1

        val before = poisonSlime.poisonCount
        poisonSlime.attack(hero)
        val after = poisonSlime.poisonCount

        assertEquals(before - minusCount, after)
    }

    @Test
    fun `포이즌 횟수 소진 후 기본 공격만 해야한다`() {
        val poisonSlime = PoisonSlime("A")
        val hero = Hero("루카스", hp = HERO_MAX_HP)
        val expectedDamage = 10
        val expectedCount = 0
        poisonSlime.poisonCount = 0

        val beforeHp = hero.hp
        poisonSlime.attack(hero)
        val afterHp = hero.hp

        assertEquals(beforeHp - expectedDamage, afterHp)
        assertEquals(expectedCount, poisonSlime.poisonCount)
    }

    @Test
    fun `공격했을 때 용사의 체력이 닳는다`() {
        val poisonSlime = PoisonSlime("A")
        val hero = Hero("루카스", hp = HERO_MAX_HP)
        val expectedDamage = 20

        val beforeHp = hero.hp
        poisonSlime.attack(hero)
        val afterHp = hero.hp

        assertEquals(beforeHp - expectedDamage, afterHp)
    }
    // 공격했을 때 용사의 피가 까지는지 체크
}

 */