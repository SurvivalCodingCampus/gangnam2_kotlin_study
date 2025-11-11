package com.survivaalcoding.kotlinstudy.`07_polymorphism`.example

class B : Y() {
    override fun a() {
        println("Ba")
    }

    override fun b() {
        println("Bb")
    }

    fun c() {
        println("Bc")
    }
}