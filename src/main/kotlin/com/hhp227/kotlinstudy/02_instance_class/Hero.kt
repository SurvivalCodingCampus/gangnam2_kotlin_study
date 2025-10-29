package com.hhp227.kotlinstudy.`02_instance_class`

class Hero(var name: String = "", var hp: Int) {
    fun attack() {
        // 로컬 변수
        hp -= 10
    }

    fun run() {
        hp = 10
    }

    fun sleep() {
        hp = 100
        println("")
    }
}

//f(x) = x + 4
//f(36) = 40