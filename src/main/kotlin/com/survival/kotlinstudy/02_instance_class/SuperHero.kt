package com.survival.kotlinstudy.`02_instance_class`

class SuperHero(
    name: String
) : Hero(name) {


    init {
        println("SuperHero의 init")
    }
    var isFlying: Boolean = false
    override fun run() {
        println("$name 이 퇴각했다.")
    }

    override fun attack(slime: Slime) {
        super.attack(slime)

        if (isFlying) {
            println("~~~")
        }
    }
}

fun main() {
    val superHero = SuperHero("홍길동")
    println(superHero.name)
    superHero.run()
}