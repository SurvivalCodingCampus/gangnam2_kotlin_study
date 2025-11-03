package com.survivalcoding.kotlinstudy.`02_instance_class`

class SuperHero(
    name: String
) : Hero(name) {

    init {
        println("2. SuperHero의 init")
    }

    // 기능 재정의
    override fun run() {
        println("다시 쓴 run")
    }


}

fun main() {
    val superHero = SuperHero("홍길동")
//    println(superHero.name)

    superHero.run()
}