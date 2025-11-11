package com.luca.kotlinstudy._04_collection

import com.luca.kotlinstudy._02_instance_class.Hero
import org.junit.Assert.assertEquals
import org.junit.Test

class GreatWizardTest {
    @Test
    fun `MP가 4 이하일 때는 heal이 발동하지 않는다`() {
        val invalidMana = 4

        val greatWizard = GreatWizard(name = availableName, mp = invalidMana)
        val hero = Hero(name = availableName, heroHp)

        val beforeHeal = hero.hp
        greatWizard.heal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal, afterHeal)
        assertEquals(invalidMana, greatWizard.mp)
    }

    @Test
    fun `힐을 하면 MP가 5가 닳는다`() {
        val greatWizard = GreatWizard(name = availableName, mp = availableMana)
        val hero = Hero(name = availableName, hp = heroHp)


        val beforeHeal = hero.hp
        greatWizard.heal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal + GreatWizard.DEFAULT_HEAL_AMOUNT, afterHeal)
        assertEquals(availableMana - GreatWizard.DEFAULT_HEAL_MP_COST, greatWizard.mp)
    }

    @Test
    fun `힐을 했을 때 대상이 MAX면 heal이 발동하지 않는다`() {
        val greatWizard = GreatWizard(name = availableName, mp = availableMana)
        val hero = Hero(name = availableName, hp = Hero.DEFAULT_MAX_HP)

        val beforeHeal = hero.hp
        greatWizard.heal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal, afterHeal)
        assertEquals(availableMana, greatWizard.mp)
    }

    @Test
    fun `MP가 49 이하일 때는 superHeal이 발동하지 않는다`() {
        val invalidMana = 49

        val greatWizard = GreatWizard(name = availableName, mp = invalidMana)
        val hero = Hero(name = availableName, heroHp)

        val beforeHeal = hero.hp
        greatWizard.superHeal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal, afterHeal)
        assertEquals(invalidMana, greatWizard.mp)
    }

    @Test
    fun `superHeal을 하면 MP가 50이 닳는다`() {
        val greatWizard = GreatWizard(name = availableName, mp = availableMana)
        val hero = Hero(name = availableName, hp = heroHp)

        greatWizard.superHeal(hero)
        val afterHeal = hero.hp

        assertEquals(afterHeal, Hero.DEFAULT_MAX_HP)
        assertEquals(availableMana - GreatWizard.DEFAULT_SUPERHEAL_MP_COST, greatWizard.mp)
    }

    @Test
    fun `힐을 했을 때 대상이 MAX면 superHeal이 발동하지 않는다`() {
        val greatWizard = GreatWizard(name = availableName, mp = availableMana)
        val hero = Hero(name = availableName, hp = Hero.DEFAULT_MAX_HP)

        val beforeHeal = hero.hp
        greatWizard.superHeal(hero)
        val afterHeal = hero.hp

        assertEquals(beforeHeal, afterHeal)
        assertEquals(availableMana, greatWizard.mp)
    }

    companion object {
        val heroHp = 1
        val availableMana = 50
    }
}