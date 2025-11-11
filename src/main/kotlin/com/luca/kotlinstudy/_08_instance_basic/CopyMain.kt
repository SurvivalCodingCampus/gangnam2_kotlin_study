package com.luca.kotlinstudy._08_instance_basic

import com.luca.kotlinstudy._02_instance_class.Hero
import com.luca.kotlinstudy._05_inheritance.Slime

fun main() {
    // 숫자(primitive), 문자열
    val a = 10
    val b = a

    println(a === b)

    val c = "홍길동"
    val d = c

    println(c === d)

    val h1 = Hero("홍")
    val h2 = h1
    val h3 = Hero(h1.name, h1.hp) // 안에 있는 걸 다 넘겨주는 것이 복사 => Hero 안에 copy 라는 메서드 만들어줘서 편하게 해보자.
    val h4 = h1.copy()
    val h5 = h1.copy(name = "김")
    val h6 = h1.copy(hp = 100)
    println(h1)

    println(h1 === h2) // 인스턴스는 하나기 때문에 인스턴스 복사라고 하지 않는다.
    println(h1 == h3)

    val slime1 = Slime("A")
    val slime2 = slime1.copy()

    println(slime1 === slime2)
}