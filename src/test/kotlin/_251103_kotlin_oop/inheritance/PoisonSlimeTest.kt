package _251103_kotlin_oop.inheritance

import _251030_kotlin_oop.MAX_HP
import org.junit.Test
import kotlin.test.assertEquals

class PoisonSlimeTest {

    @Test
    fun `PoisonSlime 객체가 잘 만들어지는지 테스트`() {
        //given
        val definedName = "Poison"
        val poisonSlime = PoisonSlime(name = definedName)
        //when
        //then
        assertEquals(definedName, poisonSlime.name)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `PoisonSlime의 이름이 빈값인 경우 프로그램이 터지는지 테스트`() {
        //given
        val poisonSlime = PoisonSlime("")

    }

    @Test
    fun `PoisonSlime의 poisonCount값이 초기값으로 설정되어있는지 테스트`() {
        //given
        val poisonSlime = PoisonSlime("poison")
        //when
        //then
        assertEquals(POISONCOUNT, poisonSlime.poisonCount)

    }

    @Test
    fun `PoisonSlime이 poisonCount가 0이 아닌경우 추가 공격이 진행되는지 테스트`() {
        //given
        val poisonSlime = PoisonSlime(name = "poison")
        val heroHp = 100
        val hero = Hero(name = "superMan", hp = heroHp, sword = null)
        //when
        poisonSlime.attack(hero)
        //then
        //100-10-최대체력20%에 해당하는 수치
        assertEquals(heroHp - SLIMEBASICATTCK - MAX_HP / 5, hero.hp)
    }

    @Test
    fun `PoisonSlime이 추가공격을 한 후 PoisonCount 수치가 감소되는지 테스트`() {
        //given
        val poisonSlime = PoisonSlime(name = "poison")
        val hero = Hero("superMan", hp = 100, sword = null)

        //when
        poisonSlime.attack(hero)
        //then
        assertEquals(POISONCOUNT - 1, poisonSlime.poisonCount)
    }

    @Test
    fun `PoisonSlime이 poisonCount가 0인 경우 추가 공격이 진행 안 되는지 테스트`() {
        //given
        val poisonSlime = PoisonSlime(name = "poison")
        val heroHp = 100
        val hero = Hero("superMan", hp = heroHp)
        poisonSlime.poisonCount = 0
        //when
        poisonSlime.attack(hero)
        //then
        assertEquals(heroHp - SLIMEBASICATTCK, hero.hp)
    }
}