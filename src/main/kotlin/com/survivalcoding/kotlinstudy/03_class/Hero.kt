package com.survivalcoding.kotlinstudy.`03_class`

import kotlin.random.Random


fun main() {
    val hero1 = Hero(name = "홍길동", hp = 100)
    val hero2 = hero1

    hero2.hp = 200
    println(hero2.hp)

    val hero3 = Hero(name = "한석봉", hp = 50)
    Hero.money = 90
    println(Hero.money)

    Hero.setRandomMoney()

}

class Hero(
    // 동적
    var name: String = "",
    var hp: Int = 0,
    var sword: Sword? = null,
    var money: Int = 100
) {
    // 공유 자원
    // Java 의 static 과 동일한 느낌 -> 정적인 데이터
    companion object {
        var money = 100


        // 클래스를 위한 유틸 함수 처럼 생각
        fun setRandomMoney() {
            money = Random.nextInt(1000)

            // this.name 이런식으로 접근 불가
            // 내부의 this는 Hero의 인스턴스가 아님

            // 뭔지 알려줘야해!!
            val hero = Hero("홍길동")
            hero.name = ""
        }

    }

    fun attack() {}
    fun run() {}
    fun sleep() {}
}

class Sword(
    val name: String,
    val damage: Int,
) {

}
