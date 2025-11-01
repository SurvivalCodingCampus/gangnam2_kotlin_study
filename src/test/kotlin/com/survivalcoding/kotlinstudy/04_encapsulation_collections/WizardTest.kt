package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

// given(준비)
// when(실행)
// then(검증)

// 지팡이 테스트
class WandTest {
    private val validName = "마법지팡이"
    private val invalidName = ""
    private val shortName = "지팡"
    private val lowPower = 0.4
    private val highPower = 101.0
    private val normalPower = 0.5

    @Test
    fun `지팡이 생성 성공`() {
        // given(준비)
        val name = validName
        val power = normalPower

        // when(실행)
        val wand = Wand(name, power)

        // then(검증)
        assertEquals(name, wand.name)
        assertEquals(power, wand.power, 0.0)
    }

    @Test
    fun `지팡이 생성 실패 - 이름 빈 문자열`() {
        // given(준비)
        val name = invalidName
        val power = normalPower

        //then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wand(name, power)
        }
    }

    @Test
    fun `지팡이 생성 실패 - 이름 3글자 미만`() {
        // given(준비)
        val name = shortName
        val power = normalPower

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wand(name, power)
        }
    }

    @Test
    fun `지팡이 생성 실패 - 마력 부족`() {
        // given(준비)
        val name = validName
        val power = lowPower

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wand(name, power)
        }
    }

    @Test
    fun `지팡이 생성 실패 - 마력 넘침초과`() {
        // given(준비)
        val name = validName
        val power = highPower

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wand(name, power)
        }
    }

    @Test
    fun `지팡이 이름 변경 성공`() {
        // given(준비)
        val wand = Wand(validName, normalPower)
        val newName = "마법막대기"

        // when(실행)
        wand.name = newName

        // then(검증)
        assertEquals(newName, wand.name)
    }

    @Test
    fun `지팡이 이름 변경 실패 - 이름 빈 문자열`() {
        // given(준비)
        val wand = Wand(validName, normalPower)
        val newName = invalidName

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            wand.name = newName
        }
    }

    @Test
    fun `지팡이 이름 변경 실패 - 이름 3글자 미만`() {
        // given(준비)
        val wand = Wand(validName, normalPower)
        val newName = shortName

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            wand.name = newName
        }
    }

    @Test
    fun `지팡이 마력 변경 성공`() {
        // given(준비)
        val wand = Wand(validName, 1.0)
        val newPower = 80.0

        // when(실행)
        wand.power = newPower

        // then(검증)
        assertEquals(newPower, wand.power, 0.0)
    }

    @Test
    fun `지팡이 마력 변경 실패 - 미만`() {
        // given(준비)
        val wand = Wand(validName, normalPower)
        val newPower = lowPower

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            wand.power = newPower
        }
    }

    @Test
    fun `지팡이 마력 변경 실패 - 초과`() {
        // given(준비)
        val wand = Wand(validName, normalPower)
        val newPower = highPower

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            wand.power = newPower
        }
    }
}

class WizardTest {
    private val validName = "마법사"
    private val invalidName = ""
    private val shortName = "법사"
    private val validHp = 0
    private val validMp = 10
    private val invalidMp = -1
    private val negativeHp = -1
    private val validWand = Wand("지팡이", 1.0)

    @Test
    fun `마법사 생성 성공`() {
        // given(준비)
        val wizard = Wizard(validName, validMp, validHp, validWand)

        // then(검증)
        assertEquals(validName, wizard.name)
        assertEquals(validHp, wizard.hp)
        assertEquals(validMp, wizard.mp)
        assertEquals(validWand, wizard.wand)
    }

    @Test
    fun `마법사 생성 실패 - 이름 빈 문자열`() {
        // given(준비)
        val name = invalidName
        val mp = validMp
        val hp = validHp

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wizard(name, mp, hp, validWand)
        }
    }

    @Test
    fun `마법사 생성 실패 - 이름 3글자 미만`() {
        // given(준비)
        val name = shortName
        val mp = validMp
        val hp = validHp

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wizard(name, mp, hp, validWand)
        }
    }

    @Test
    fun `마법사 생성 실패 - MP 0 미만`() {
        // given(준비)
        val name = validName
        val mp = invalidMp
        val hp = validHp

        // then(검증)
        assertFailsWith<IllegalArgumentException> {
            Wizard(name, mp, hp, validWand)
        }
    }

    @Test
    fun `마법사 성공 - HP 음수는 0으로 보정`() {
        // given(준비)
        val name = validName
        val mp = validMp
        val hp = negativeHp

        // when(실행)
        val wizard = Wizard(name, mp, hp, validWand)

        // then(검증)
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `마법사 성공 - 지팡이 null`() {
        // given(준비)
        val name = validName
        val mp = validMp
        val hp = validHp
        val wand = null

        // when(실행)
        val wizard = Wizard(name, mp, hp, wand)

        // then(검증)
        assertEquals(null, wizard.wand)
    }

    @Test
    fun `마법사 이름 변경 성공`() {
        // given(준비)
        val wizard = Wizard(validName, validMp, validHp, validWand)
        val newName = "위자드"

        // when(실행)
        wizard.name = newName

        // then(검증)
        assertEquals(newName, wizard.name)
    }

    @Test
    fun `마법사 이름 변경 실패 - 이름 빈 문자열`() {
        // given
        val wizard = Wizard(validName, validMp, validHp, validWand)
        val newName = invalidName

        // then
        assertFailsWith<IllegalArgumentException> {
            wizard.name = newName
        }
    }

    @Test
    fun `마법사 이름 변경 실패 - 이름 3글자 미만`() {
        // given
        val wizard = Wizard(validName, validMp, validHp, validWand)
        val newName = shortName

        // then
        assertFailsWith<IllegalArgumentException> {
            wizard.name = newName
        }
    }

    @Test
    fun `마법사 MP 변경 성공`() {
        // given
        val wizard = Wizard(validName, validMp, validHp, validWand)
        val newMp = 30

        // when
        wizard.mp = newMp

        // then
        assertEquals(newMp, wizard.mp)
    }

    @Test
    fun `마법사 MP 변경 실패 - 음수`() {
        // given
        val wizard = Wizard(validName, validMp, validHp, validWand)
        val newMp = invalidMp

        // then
        assertFailsWith<IllegalArgumentException> {
            wizard.mp = newMp
        }
    }

    @Test
    fun `마법사 HP 변경 성공 - 음수는 0으로 보정`() {
        // given
        val wizard = Wizard(validName, validMp, validHp, validWand)
        val newHp = negativeHp

        // when
        wizard.hp = newHp

        // then
        assertEquals(0, wizard.hp)  // setter에서 보정됨
    }
}