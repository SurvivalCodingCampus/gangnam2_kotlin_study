package com.survivaalcoding.kotlinstudy.`02_instance_class`.example

fun main() {
    val clericA = Cleric("클레릭A", 30)

    clericA.selfAid()
    clericA.selfAid()
    clericA.selfAid()

    println("============")

    val clericB = Cleric("클레릭B", 20)

    clericB.selfAid()
    clericB.selfAid()
    clericB.pray()
    clericB.pray(3)
}