package com.survivaalcoding.kotlinstudy.`02_instance_class`

class Hero(var name: String, var hp: Int) {
    fun attack() = println("${name}은 공격중")
    fun run() = println("$name 은 뛰는중")
    fun sit(sec: Int) = println("$name 은 ${sec}초 동안 앉아 있다")
    fun slip() = println("$name 은 넘어졌다")
    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다!")
    }
}
