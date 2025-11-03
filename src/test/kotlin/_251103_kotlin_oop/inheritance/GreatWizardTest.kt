package _251103_kotlin_oop.inheritance

import _251030_kotlin_oop.MAX_HP
import org.junit.Assert.assertEquals
import org.junit.Test

class GreatWizardTest {

    @Test
    fun `인스턴스를 생성 시 기본 MP의 초기값이 잘 설정되어있는지 테스트`() {
        //given
        val greatWizardHp = 1
        val greatWizard = GreatWizard(name = "대마법사", hp = greatWizardHp, wand = null)
        //when

        //then
        assertEquals(GREATWIZARD_MINIMUM_MP, greatWizard.mp)
    }

    @Test
    fun `대마법사의 마나가 충분할 경우 재정의한 heal 메서드가 잘 동작하는지 테스트`() {
        //given
        val greatWizard = GreatWizard(name = "대마법사", hp = 1, wand = null)
        val heroHp = 1
        val hero = Hero("영웅", heroHp)
        //when
        greatWizard.heal(hero)
        //then
        assertEquals(heroHp + GREATWIZARD_HEAL_TREAT_HP, hero.hp)
        assertEquals(GREATWIZARD_MINIMUM_MP - GREATWIZARD_HEAL_REQUIRED_MP, greatWizard.mp)
    }

    @Test
    fun `대마법사의 마나가 없을 경우 재정의한 heal 메서드가 작동 안하는지 테스트`() {
        //given
        val greatWizard = GreatWizard(name = "대마법사", hp = 1, wand = null)
        greatWizard.mp = 0
        val heroHp = 1
        val hero = Hero("영웅", heroHp)
        //when
        greatWizard.heal(hero)
        //then
        assertEquals(heroHp, hero.hp)
        assertEquals(0, greatWizard.mp)
    }

    @Test
    fun `대마법사의 마나가 부족한 경우 재정의한 heal 메서드가 작동 안하는지 테스트`() {
        //given
        val greatWizard = GreatWizard(name = "대마법사", hp = 1, wand = null)
        greatWizard.mp = GREATWIZARD_HEAL_REQUIRED_MP - 1
        val heroHp = 1
        val hero = Hero("영웅", heroHp)
        //when
        greatWizard.heal(hero)
        //then
        assertEquals(heroHp, hero.hp)
        assertEquals(GREATWIZARD_HEAL_REQUIRED_MP - 1, greatWizard.mp)
    }

    @Test
    fun `대마법사의 마나가 충분할 경우 superHeal메서드가 잘 동작하는지 테스트`() {
        //given
        val greatWizard = GreatWizard("대마법사", 1, null)
        val heroHp = 1
        val hero = Hero("영웅", heroHp)
        //when
        greatWizard.superHeal(hero)
        //then
        assertEquals(MAX_HP, hero.hp)
        assertEquals(GREATWIZARD_MINIMUM_MP - GREATWIZARD_SUPERHEAL_REQUIRED_MP, greatWizard.mp)
    }

    @Test
    fun `대마법사의 마나가 부족한 경우 superHeal메서드가 작동 안하는지 테스트`() {
        //given
        val greatWizard = GreatWizard("대마법사", 1, null)
        greatWizard.mp = GREATWIZARD_SUPERHEAL_REQUIRED_MP - 1
        val heroHp = 1
        val hero = Hero("영웅", heroHp)
        //when
        greatWizard.superHeal(hero)
        //then
        assertEquals(GREATWIZARD_SUPERHEAL_REQUIRED_MP - 1, greatWizard.mp)
        assertEquals(heroHp, hero.hp)
    }

    @Test
    fun `대마법사의 마나가 없는 경우 superHeal메서드가 작동 안하는지 테스트`() {
        //given
        val greatWizard = GreatWizard("대마법사", 1, null)
        greatWizard.mp = 0
        val heroHp = 1
        val hero = Hero("영웅", heroHp)
        //when
        greatWizard.superHeal(hero)
        //then
        assertEquals(0, greatWizard.mp)
        assertEquals(heroHp, hero.hp)
    }
}