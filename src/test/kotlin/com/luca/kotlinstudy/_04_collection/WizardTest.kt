package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.Hero
import org.junit.Assert.*
import org.junit.Test

const val availableName = "루카스" // 3글자

class WizardTest {

    @Test
    fun `위자드 이름이 3글자 미만이면 예외가 발생한다`() {
        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Wizard(name = invalidName)
        }
    }

    @Test
    fun `위자드 이름이 3글자 이상이면 정상적으로 설정된다`() {
        val wizard = Wizard(name = availableName)

        // when & then
        assertEquals(availableName, wizard.name)
    }

    @Test
    fun `MP가 0 미만이면 예외가 발생한다`() {
        // given
        val invalidMp = -50

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            Wizard(name = availableName, mp = invalidMp)
        }
    }

    @Test
    fun `MP가 9 이하일 때는 heal이 발동하지 않는다`() {
        val invalidMana = 9
        val wizard = Wizard(name = availableName, mp = invalidMana)
        val hero = Hero(name = availableName, hp = 30)

        val beforeHeal = hero.hp
        wizard.heal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal, afterHeal)
        assertEquals(invalidMana, wizard.mp)
    }

    @Test
    fun `힐을 하면 MP가 10이 닳는다`() {
        val heroHp = 30

        val wizard = Wizard(name = availableName, mp = availableMana)
        val hero = Hero(name = availableName, hp = heroHp)

        val beforeHeal = hero.hp
        wizard.heal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal + Wizard.DEFAULT_HEAL_AMOUNT, afterHeal)
        assertEquals(availableMana - Wizard.DEFAULT_HEAL_MP_COST, wizard.mp)
    }

    @Test
    fun `힐을 했을 때 대상이 MAX면 heal이 발동하지 않는다`() {
        val wizard = Wizard(name = availableName, mp = availableMana)
        val hero = Hero(name = availableName, hp = Hero.DEFAULT_MAX_HP)

        val beforeHeal = hero.hp
        wizard.heal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal, afterHeal)
        assertEquals(availableMana, wizard.mp)
    }

    companion object {
        val invalidName = "루카" // 2글자
        val availableMana = 10
    }
}
