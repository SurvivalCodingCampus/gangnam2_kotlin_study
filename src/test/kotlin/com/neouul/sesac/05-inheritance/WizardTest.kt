package com.neouul.sesac.`05-inheritance`

import org.junit.Assert.*
import org.junit.Test

class WizardTest {
    @Test
    fun `Wizard의 인스턴스가 성공적으로 생성된 경우, mp의 초기값이 올바른지`() {
        // given
        val wizard = Wizard("마법사", 50, null)

        // then
        assertEquals(100, wizard.mp)    // 초기치
        assertEquals(Wizard.MAX_MP, wizard.mp)
        assertEquals("마법사", wizard.name)
        assertEquals(50, wizard.hp)
    }

    @Test
    fun `Wizard의 heal 메서드가 용사의 hp와 자신의 mp를 적절히 조절하는 경우`() {
        // given: 용사의 최대 HP인 80보다 20이상 적은 값으로 설정하여
        // 회복이 예상하는 값 만큼 되었는지 확인
        val wizard = Wizard("마법사", 50, null)
        val hero = Hero("용사", 10)
        val previousHP = hero.hp
        val previousMp = wizard.mp

        // when
        wizard.heal(hero)

        // then
        assertEquals(previousHP + Wizard.HEAL_HP, hero.hp)
        assertEquals(previousMp - Wizard.HEAL_MP, wizard.mp)
    }

    @Test
    fun `Wizard의 heal 메서드를 호출했는데 mp가 부족한 경우`() {
        // given: 마법사의 mp를 heal 사용하는 mp보다 적게 설정하여 마나가 부족한 경우를 테스트
        val wizard = Wizard("마법사", 50, null)
        val hero = Hero("용사", 10)
        wizard.mp = 3

        val previousHP = hero.hp
        val previousMp = wizard.mp

        // when
        wizard.heal(hero)

        // then: 용사의 hp와 마법사의 mp 변화 없음
        assertEquals(previousHP, hero.hp)
        assertEquals(previousMp, wizard.mp)
    }
}