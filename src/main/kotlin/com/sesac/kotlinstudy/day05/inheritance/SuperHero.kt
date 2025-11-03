package com.sesac.kotlinstudy.day05.inheritance

class SuperHero(
    name: String,
) : Hero(name) {
    init {
        println("SuperHero의 init")
    }

    // 기능 재정의
    override fun run() {
//        super.run()
        println("다시 쓴 run")
    }
}

fun main() {
    val superHero = SuperHero("홍길동")
    println(superHero.name)

    superHero.run()
}
