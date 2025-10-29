package com.luca.kotlinstudy.`02_instance_class`

fun main() {
    val hero = Hero() // 기본 생성자
    val hero2 = Hero(name = "홍길동", hp = 50) // 기본 생성자
    hero2.name = ""
}

class Hero(var name: String = "",var hp: Int = 0) {
    // var name: String 이렇게 하면 에러가 난다.
    // 멤버변수, field, 전역 변수
    // name
    // hp
    fun attack(){
    // 로컬변수
        val x: Int = 0
    }
    fun run(){
    }
    fun sleep(){
    }
    // 연습 때는 한 번에 클래스를 치지만 실제로 쓸 때는 분산을 해주자.
    class Slime(hp: Int){ // var 를 안붙이면 활용할 수 가 없다. 수정X
        val level = 10
        // const val SLIME_LEVEL = 10 탑레벨에 가능
    }
}