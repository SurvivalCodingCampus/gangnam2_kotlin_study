package _251103_kotlin_oop.inheritance

import org.junit.Assert.assertEquals
import kotlin.test.Test

class WizardTest {

    @Test
    fun `wizard 인스턴스 만들 시 mp값이 초기값으로 설정되는지 테스트`() {
        //given
        val wizard = Wizard(name = "마법사", hp = 10, wand = null)
        //then
        assertEquals(WIZARD_MINIMUM_MP, wizard.mp)
    }

    @Test
    fun `마나가 부족한 경우 hero에게 힐이 안되는지 테스트`() {
        //given
        val heroHp = 1
        val wizardHp = 1
        val hero = Hero("슈퍼맨", hp = heroHp)
        val wizard = Wizard(name = "마법사", hp = wizardHp, wand = null)
        wizard.mp = 0
        ///when
        wizard.heal(hero)
        //then
        assertEquals(heroHp, hero.hp)
    }

    @Test
    fun `마나가 충분한 경우 hero에게 힐이 정상적으로 되는지 테스트`() {
        //given
        val heroHp = 1
        val wizardHp = 1
        val hero = Hero("슈퍼맨", hp = heroHp)
        val wizard = Wizard(name = "마법사", hp = wizardHp, wand = null)
        //when
        wizard.heal(hero)
        //then
        assertEquals(heroHp + HEALTREATHP, hero.hp)
        assertEquals(WIZARD_MINIMUM_MP - HEALREQUIREDMP, wizard.mp)
    }


}