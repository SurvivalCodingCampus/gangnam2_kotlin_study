package com.survivaalcoding.kotlinstudy.`05_inheritance`

class SuperHero(name: String) : Hero(name) {
    init {
        println("SuperHero init")
    }

    override fun run() {
        println("${name}이 퇴각한다.")
    }
}

fun main() {
    val superHero = SuperHero("홍길동")
    println(superHero.name)

    superHero.run()
}