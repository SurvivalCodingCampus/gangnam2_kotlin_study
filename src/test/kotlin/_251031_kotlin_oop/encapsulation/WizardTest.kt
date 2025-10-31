package _251031_kotlin_oop.encapsulation

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class WizardTest {
    @Test(expected = IllegalArgumentException::class)
    fun `마법사 이름이 없는경우 터지는지 테스트`() {
        //given
        val wizard = Wizard(name = "", hp = 10, wand = null)//이름 없이 인스턴스 생성
    }

    @Test
    fun `마법사가 공격 당했을 때 hp가 제대로 깍이는지 테스트`() {
        //given
        val wizard = Wizard(name = "마법사", hp = 10, wand = null)
        //when
        wizard.attacked(1)
        //then
        assertEquals(9, wizard.hp)
    }

    @Test
    fun `마법사의 HP가 음수가 되는 상황에서 0으로 되는지 테스트`() {
        //given
        val wizard = Wizard(name = "마법사", hp = 10, wand = null)
        //when
        wizard.attacked(1000)
        //then
        assertEquals(0, wizard.hp)
    }

    @Test
    fun `마법사가 지팡이를 들고 있는 경우 마법사의 마력은 지팡이의 최저 마력 기준보다 크거나 같은지 테스트`() {
        //given
        val wand = Wand(name = "몽둥이", 10.0)
        val wizard = Wizard(name = "마법사", hp = 10, wand = wand)
        //when
        //then
        assertTrue { (wizard.wand?.power ?: 0.0) >= WIZARD_MINIMUM_MP }
    }

    @Test
    fun `마법사가 지팡이를 들고 있지 않은 경우 프로그램이 잘 돌아가는지 테스트`() {
        //given
        val wizard = Wizard(name = "마법사", hp = 10, wand = null)
        //when
        //then
        assertTrue { (wizard.wand?.power ?: 0.0) >= WIZARD_MINIMUM_MP }
    }
}