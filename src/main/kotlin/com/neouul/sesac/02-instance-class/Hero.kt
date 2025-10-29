package com.neouul.sesac.`02-instance-class`

class Hero(
    var name: String = "",
    var hp: Int = 0
){
    // 멤버 변수
    // name
    // hp

    fun attack() {
        // 로컬 변수
        hp -= 10
    }

    fun run() {

    }

    fun sleep() {

    }
}