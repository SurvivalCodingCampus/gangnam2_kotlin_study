package com.survivaalcoding.kotlinstudy.`02_instance_class`

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class WizardTest {
    @Test
    fun `Wizard Heal Test`() {
        // given
        val wizard = Wizard(name = "마법사", hp = 100)
        val hero = Hero(name = "히어로", hp = 10)

        // when
        wizard.heal(hero)

        // then
        assertThat(hero.hp).isEqualTo(20)
    }
}