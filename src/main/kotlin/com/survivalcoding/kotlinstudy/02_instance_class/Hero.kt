package com.survivalcoding.kotlinstudy.`02_instance_class`

fun main() {
    val hero = Hero()
    val hero2 = Hero(name = "홍길동", hp = 10)
    hero2.name = ""

    println("잘 되나!!!")
}

class Hero(var name: String = "", var hp: Int = 0) {
    // 멤버변수, field, 전역 변수
    // name
    // hp

    fun attack() {
        if (hp == 0) {
            return
        }
        // 로컬 변수
        hp -= 10
    }

    fun run() {
        hp = 10
    }

    fun sleep() {

    }
}

// f(x) = x + 4
// f(36) = 36 + 4 = 40