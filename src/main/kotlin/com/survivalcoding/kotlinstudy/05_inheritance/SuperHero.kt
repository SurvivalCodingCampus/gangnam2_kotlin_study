package com.survivalcoding.kotlinstudy.`05_inheritance`

import com.survivalcoding.kotlinstudy.`02_instance_class`.Hero


// 물려 받아야 하는데 재 선언 할 수는 없음, 값만 넘겨서
// open 된 클래스를 사용
class SuperHero(
    name: String
) : Hero(name) {
    // 기능 재정의
//    override fun run() {
//        println("달려!")
//    }


    init {
        println { "2. SuperHero의 init" }
    }

    override fun run() {
        println("달려")

        super.run()

        println("달려")
    }
}

fun main() {
    val superHero = SuperHero("홍길동")
    println(superHero.name)

    superHero.run()
}