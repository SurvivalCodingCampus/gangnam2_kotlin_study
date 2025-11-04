package com.hhp227.kotlinstudy.`05_inheritance`

import com.hhp227.kotlinstudy.`02_instance_class`.Hero

class SuperHero(
    name: String
) : Hero(name) {

    init {
        println("SuperHero의 init")
    }

    // 기능 재정의
    override fun run() {
        println("SuperHero의 run")
    }
}