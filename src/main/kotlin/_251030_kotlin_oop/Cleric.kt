package _251030_kotlin_oop

const val MAX_HP = 50
const val MAX_MP = 10
const val SELF_AID_REQUIRE_MP = 5

class Cleric(
    val name: String, //인스턴스 생성 시 이름은 필수 입력값으로 변경
    var hp: Int = 50,
    var mp: Int = 10
) {
    fun selfAid() {
        if (mp >= SELF_AID_REQUIRE_MP) { // MP 5소비, 체력 끝까지 회복
            hp = MAX_HP
            mp -= SELF_AID_REQUIRE_MP
        }
    }

    fun pray(time: Int): Int { // mp를 초당 1회복 하고 보너스로 0~2 추가회복, 최대MP를 넘을 수 없음
        //실제로 회복된 MP량을 반환
        val randomRange = 0..2
        val randomBonus = randomRange.random()
        val expected = time + randomBonus //mp회복 예상치

        if (mp + expected > MAX_MP) {
            val result = MAX_MP - mp
            mp = MAX_MP
            return result
        } else {
            mp += expected
            return expected
        }

    }
}