package com.survivalcoding.kotlinstudy.`02_instance_class`

fun main() {
    val hero = Hero() // 기본 생성자
    val hero2 = Hero(name = "홍길동", hp= 10)

}

class Hero (var name: String = "", var hp: Int = 0){
    // 멤버 변수, field
    // name
    // hp
    fun attack() {
        // 로컬 변수
        hp -= 10
    }
    fun run() {

    }
    fun sleep() {

    }
}