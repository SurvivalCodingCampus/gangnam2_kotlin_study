package com.ezlevup.my.day251104

interface Organism {
    val forceConnection: Int
    fun useForce()
}

interface Alien : Organism {
    fun sleep() {
        println("alien sleeping")
    }
}

interface Human : Organism {
    val numberOfLegs: Int  // 추상 프로퍼티

    fun speak() // 추상 메서드

    val isKing: Boolean
        get() = true  // 디폴트 구현

    fun sleep() {
        println("human sleeping")
    }
}

class Man(override val forceConnection: Int = 10) : Human, Alien {

    override fun useForce() {
        println("man force: $forceConnection")
    }

    override val numberOfLegs: Int
        get() = 2

    override fun speak() {
        println("man speak")
    }

    override fun sleep() {
        super<Alien>.sleep() // 중복된 메서드 처리
        println("man sleep")
    }
}

fun main() {
    val man = Man()
    man.speak()
    man.sleep()
    man.useForce()
    println("numberOfLegs: ${man.numberOfLegs}")
    println("isKing: ${man.isKing}")
}
