package _251029_kotlin_oop

class Cleric() {
    val name: String = ""
    var hp: Int = 50
    var mp: Int = 10
    val maxHp: Int = 50
    val maxMp: Int = 10

    fun selfAid() { // MP 5소비, 체력 끝까지 회복
        hp = maxHp
    }

    fun pray(time: Int):Int { // mp를 초당 1회복 하고 보너스로 0~2 추가회복, 최대MP를 넘을 수 없음
        //실제로 회복된 MP량을 반환
        val randomRange = 0..2
        val randomBonus = randomRange.random()
        return randomBonus
    }
}