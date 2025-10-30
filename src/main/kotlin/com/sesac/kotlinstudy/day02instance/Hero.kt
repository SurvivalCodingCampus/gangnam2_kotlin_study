package com.sesac.kotlinstudy.day02instance

fun main() {
    val hero = Hero()
    val hero2 = Hero(name = "홍길동", hp = 10)
}

class Hero(var name: String = "", var hp: Int = 0) {
    // 멤버변수, field
    // name
    // hp

    fun attack() {
        // 로컬변수
        val x = 10

        if (hp != 0) {
            hp -= 10
        }
    }

    fun run() {}
    fun sleep() {}
}
