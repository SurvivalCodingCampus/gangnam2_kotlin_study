package com.neouul.sesac.`02-instance-class`

import org.junit.Assert.*
import org.junit.Test

class ClericTest {
    @Test
    fun `Cleric 클래스의 생성자로 인스턴스를 생성하면 HP, 최대 HP, MP, 최대 MP는 초기치를 만족한다`(){
        // HP, 최대 HP 초기치: 50
        // MP, 최대 MP 초기치: 10

        val cleric = Cleric(name = "A")

        assertEquals(50, cleric.hp)
        assertEquals(50, cleric.maxHp)
        assertEquals(10, cleric.mp)
        assertEquals(10, cleric.maxMp)
    }

    @Test
    fun `Cleric 클래스의 selfAid() 메서드를 실행하면 MP 5가 줄어들고 HP가 maxHP까지 늘어난다`(){
        // given: HP를 10으로 설정, 최대 HP는 초기값
        val cleric = Cleric(name = "Ju", hp = 10)
        val preMp = cleric.mp

        // when: MP가 5 줄어들고, HP가 최대 HP가 된다
        cleric.selfAid()

        // then (검증)
        assertEquals(preMp - 5, cleric.mp)
        assertEquals(cleric.maxHp, cleric.hp)
    }

    @Test
    fun `Cleric 클래스의 selfAid() 메서드가 호출되었는데 MP가 5 미만이라 아무일도 벌어지지 않는다`(){
        // given: HP를 10, MP는 3으로 설정
        val cleric = Cleric(name = "A", hp = 10, mp = 3)
        val preHp = cleric.hp
        val preMp = cleric.mp

        // when:
        cleric.selfAid()

        // then: 필드값에 변화는 없다
        assertEquals(preMp, cleric.mp)
        assertEquals(preHp, cleric.hp)
    }

    @Test
    fun `Cleric 클래스의 selfAid() 메서드가 호출되었는데 HP가 최대라 아무것도 처리하지 않는다`() {
        // given: HP와 최대 HP는 초기치인 50, MP는 8으로 설정
        val cleric = Cleric(name = "A", mp = 8)
        val preMp = cleric.mp

        // when:
        cleric.selfAid()

        // then: MP를 소요하지 않아 그대로다.
        assertEquals(preMp, cleric.mp)
    }

    @Test
    fun `Cleric 클래스의 pray(sec) 메서드를 실행하면, 보정된 값만큼 MP를 회복하고 회복된 양을 반환한다`(){
        // given:
        val cleric = Cleric(name = "A", mp = 1)
        val preMp = cleric.mp

        // when: 2~4포인트만큼 MP를 회복하고 회복된 양을 반환한다
        val diffMp = cleric.pray(2)

        // then: 메서드의 반환값이 적절한지 판단한다
        assertEquals(preMp + diffMp, cleric.mp)
    }

    @Test
    fun `Cleric 클래스의 pray(sec) 메서드를 실행하면, MP를 회복하고 실제로 회복한 양을 반환하는데 최대 MP보다 더 회복하는 것은 불가능하다`(){
        // given:
        val cleric = Cleric(name = "A", mp = 9)

        // when: 2~4포인트만큼 MP를 회복하고 회복된 양을 반환한다
        val diffMp = cleric.pray(2)

        // then: 모든 경우에서 회복량은 최대 MP를 넘지만, 최대 MP보다 더 회복하지는 않았다.
        assertEquals(cleric.maxMp, cleric.mp)
        assertEquals(1, diffMp)     // MP가 9였고 회복량이 2~4이므로, 반환값은 항상 1이여야 한다.
    }

    @Test
    fun `Cleric 클래스의 pray(sec) 메서드가 호출될 때, 인자가 음수인 경우 회복하지 않고 0을 반환한다`(){
        // given:
        val cleric = Cleric(name = "A", mp = 9)
        val preMp = cleric.mp

        // when:
        val diffMp = cleric.pray(-2)

        // then:
        assertEquals(0, diffMp)
        assertEquals(preMp, cleric.mp)
    }
}