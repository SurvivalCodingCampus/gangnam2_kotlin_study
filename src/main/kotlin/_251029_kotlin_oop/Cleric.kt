package _251029_kotlin_oop

class Cleric(
    val name: String = "",
    var hp: Int = 40,
    var mp: Int = 10
) {
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() {
        if(mp>5){ // MP 5소비, 체력 끝까지 회복
            hp = maxHp
            mp -= 5
        }
        else{
            return
        }
    }

    fun pray(time: Int): Int { // mp를 초당 1회복 하고 보너스로 0~2 추가회복, 최대MP를 넘을 수 없음
        //실제로 회복된 MP량을 반환
        val randomRange = 0..2
        val randomBonus = randomRange.random()
        val expected = time + randomBonus //mp회복 예상치
        if (mp + expected > maxMp) {
            val result = maxMp-mp
            mp=maxMp
            return result
        } else {
            mp+=expected
            return expected
        }

    }
}