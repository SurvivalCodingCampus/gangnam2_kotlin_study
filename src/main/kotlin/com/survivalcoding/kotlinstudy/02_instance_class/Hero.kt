package com.survivalcoding.kotlinstudy.`02_instance_class`

fun main() {
    val hero = Hero() // 기본 생성자
    val hero2 = Hero(name = "홍길동", hp = 10)

}

open class Hero(var name: String = "", var hp: Int = 0) {
    init {
        println { "1. Hero의 init" }
    }


    // 멤버 변수, field
    // name
    // hp
    fun attack() {
        // 로컬 변수
        hp -= 10
    }

    open fun run() {
        println("달린다")
    }

    fun sleep() {

    }
}