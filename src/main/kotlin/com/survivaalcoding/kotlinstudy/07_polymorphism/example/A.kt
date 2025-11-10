package com.survivaalcoding.kotlinstudy.`07_polymorphism`.example

class A : Y() {
    override fun a() {
        println("Aa")
    }

    override fun b() {
        println("Ab")
    }

    fun c() {
        println("Ac")
    }
}