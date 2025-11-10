package com.neouul.sesac.`06-abstract-interface`

import com.neouul.sesac.`05-inheritance`.Slime

// 추상 클래스
abstract class Character(
    var name: String,
    var hp: Int,
) {
    fun run() = println("$name 이 도망갔다")

    // 추상 메서드
    abstract fun attack(slime: Slime)
}

class Dancer(
    name: String,
    hp: Int,
) : Character(name, hp) {
    override fun attack(slime: Slime) {
        // TODO()는 호출되는 즉시 NotImplementedError를 던짐
        TODO("Not yet implemented")
    }
}


// 인터페이스
//interface Human {
//    fun speak()
//}

interface Attackable {
    fun attack(target: Slime)
    fun defend()
}

interface Healable {
    fun heal(target: Hero)
}

open class Hero(
    name: String,
    hp: Int = 100
) : Character(name, hp), Attackable {
//    override fun speak() {
//        println("나는 사람입니다")
//    }

    override fun attack(target: Slime) {
        println("$name 의 물리 공격!")
        target.hp -= 10
        println("슬라임 ${target.suffix}에게 10의 데미지! (남은 HP: ${target.hp})")
    }

    override fun defend() {
        println("$name (이)는 버텼다!")
    }
}

open class Wizard(
    name: String,
    hp: Int = 80,
    var mp: Int = 100,
) : Hero(name, hp), Healable {
    // Hero에서 오버라이딩된 attack과 defend는 재정의가 필수가 아님
    override fun attack(target: Slime) {
        println("$name 의 마법 공격!")
        target.hp -= 8
        println("슬라임 ${target.suffix}에게 8의 데미지! (남은 HP: ${target.hp})")
    }

    override fun heal(target: Hero) {
        println("${target.name}을(를) 치유합니다!")
        target.hp += 20
        mp -= 10
        println("${target.name}의 HP가 20 회복되었다! (현재 HP: ${target.hp})")
        println("$name 의 남은 MP: $mp")
    }
}