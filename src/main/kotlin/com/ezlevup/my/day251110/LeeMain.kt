package com.ezlevup.my.day251110

class Slime(var name: String) {

}

class Wand {

}

open class Character(
    var name: String,
    var hp: Int,
) {
    open fun attack(slime: Slime) {
        println("character attack")
    }
}

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand? = null,
    var mp: Int = 100,
) : Character(name, hp) {
    override fun attack(slime: Slime) {
        println("wizard attack")
    }

    fun fireball(slime: Slime) {

    }
}

fun main() {
    val wizard = Wizard(name = "해리포터", hp = 50)
    val character: Character = wizard
    val slime = Slime("A")

    character.attack(slime)
    // character.fireball(slime) // 컴파일 에러. Character 클래스에는 fireball() 메서드가 없음.
}