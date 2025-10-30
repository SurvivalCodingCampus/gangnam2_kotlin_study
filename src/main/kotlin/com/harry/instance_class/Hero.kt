package com.harry.instance_class


fun main() {
    val hero: Hero = Hero(name = "홍길동", hp = 10)
}

class Hero(val name: String, val hp: Int) {

}

class Hero2 {
    val name : String = ""
    val hp: Int = 0
}