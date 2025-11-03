package _251031_kotlin_oop.encapsulation

import org.junit.Test

class WandTest {
    @Test(expected = IllegalArgumentException::class)
    fun `지팡이 이름이 없는경우 터지는지 테스트`() {
        //given
        val wand = Wand(name = "", power = WAND_MP_MIN)//이름 없이 인스턴스 생성
    }

    @Test(expected = IllegalArgumentException::class)
    fun `지팡이의 마력이 0_5 미만 인 경우 터지는지 테스트`() {
        //given
        val wand1 = Wand(name = "지팡이", WAND_MP_MIN - .1)
    }

    @Test
    fun `지팡이의 마력이 0_5 이상 인 경우 정상작동하는지 테스트`() {
        //given
        val wand1 = Wand(name = "지팡이", WAND_MP_MIN)
        val wand2 = Wand(name = "지팡이", WAND_MP_MIN + .1)
        //when
        //then
    }

    @Test(expected = IllegalArgumentException::class)
    fun `지팡이의 마력이 100 초과 인 경우 터지는지 테스트`() {
        //given
        val wand1 = Wand(name = "지팡이", WAND_MP_MAX + .1)
    }

    @Test
    fun `지팡이의 마력이 100 이하 인 경우 정상작동하는지 테스트`() {
        //given
        val wand1 = Wand(name = "지팡이", WAND_MP_MAX)
        val wand2 = Wand(name = "지팡이", WAND_MP_MAX - .1)
        //when
        //then
    }


}