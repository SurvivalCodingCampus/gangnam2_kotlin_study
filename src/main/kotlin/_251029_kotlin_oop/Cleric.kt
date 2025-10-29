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
}