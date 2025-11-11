package com.neouul.sesac.`04-inheritance`

import org.junit.Assert.*
import org.junit.Test

class GreatWizardTest {
    @Test
    fun `GreatWizard의 인스턴스가 성공적으로 생성된 경우, mp의 초기값이 올바른지`() {
        // given
        val greatWizard = GreatWizard("대마법사", 50, null)

        // then
        assertEquals(150, greatWizard.mp)    // 초기치
        assertEquals(GreatWizard.MAX_MP, greatWizard.mp)
        assertEquals("대마법사", greatWizard.name)
        assertEquals(50, greatWizard.hp)
        assertTrue(greatWizard is Wizard)
    }

    @Test
    fun `GreatWizard의 heal 메서드가 용사의 hp와 자신의 mp를 적절히 조절하는 경우`() {
        // given: 용사의 최대 HP인 80보다 20이상 적은 값으로 설정하여
        // 회복이 예상하는 값 만큼 되었는지 확인
        val greatWizard = GreatWizard("대마법사", 50, null)
        val hero = Hero("용사", 10)
        val previousHP = hero.hp
        val previousMp = greatWizard.mp

        // when
        greatWizard.heal(hero)

        // then
        assertEquals(previousHP + GreatWizard.HEAL_HP, hero.hp)
        assertEquals(previousMp - GreatWizard.HEAL_MP, greatWizard.mp)
    }

    @Test
    fun `GreatWizard의 heal 메서드를 호출했는데 mp가 부족한 경우`() {
        // given: 대마법사의 mp를 heal 사용하는 mp보다 적게 설정하여 마나가 부족한 경우를 테스트
        val greatWizard = GreatWizard("대마법사", 50, null)
        val hero = Hero("용사", 10)
        greatWizard.mp = 3

        val previousHP = hero.hp
        val previousMp = greatWizard.mp

        // when
        greatWizard.heal(hero)

        // then: 용사의 hp와 마법사의 mp 변화 없음
        assertEquals(previousHP, hero.hp)
        assertEquals(previousMp, greatWizard.mp)
    }

    @Test
    fun `GreatWizard의 superHeal 메서드가 용사의 hp와 자신의 mp를 적절히 조절하는 경우`() {
        // given: 용사의 최대 HP인 80보다 20이상 적은 값으로 설정하여
        // 회복이 예상하는 값 만큼 되었는지 확인
        val greatWizard = GreatWizard("대마법사", 50, null)
        val hero = Hero("용사", 10)
        val previousMp = greatWizard.mp

        // when
        greatWizard.superHeal(hero)

        // then
        assertEquals(hero.maxHp, hero.hp)
        assertEquals(previousMp - GreatWizard.SUPER_HEAL_MP, greatWizard.mp)
    }

    @Test
    fun `GreatWizard의 superHeal 메서드를 호출했는데 mp가 부족한 경우`() {
        // given: 대마법사의 mp를 heal 사용하는 mp보다 적게 설정하여 마나가 부족한 경우를 테스트
        val greatWizard = GreatWizard("대마법사", 50, null)
        val hero = Hero("용사", 10)
        greatWizard.mp = 3

        val previousHP = hero.hp
        val previousMp = greatWizard.mp

        // when
        greatWizard.superHeal(hero)

        // then: 용사의 hp와 마법사의 mp 변화 없음
        assertEquals(previousHP, hero.hp)
        assertEquals(previousMp, greatWizard.mp)
    }
}