package com.survivaalcoding.kotlinstudy.`02_instance_class`

fun main() {
    val hero = Hero("용사", 100)

    val slimeA = Slime(50, "A")
    val slimeB = Slime(55, "B")

    hero.attack()
    hero.run()
    hero.sit(10)
    hero.slip()
    hero.sleep()

    hero.attack()
    slimeA.run()
    slimeB.run()
    hero.run()
    hero.sleep()
}