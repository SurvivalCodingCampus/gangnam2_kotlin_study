package com.luca.kotlinstudy._02_instance_class

class SuperHero(
    //val name: String 물려 받을 거라 재정의를 할 수 없다.
    name: String // 값을 넘겨 Hero 것을 사용
) : Hero(name) {

    init{
        println("2. SuperHero의 init")
    }
    // 기능 재정의
    override fun run() {
        println("다시 쓴 run")
    }
}

fun main() {
    val superHero = SuperHero("홍길동")
    println(superHero.name)

    superHero.run()
}
