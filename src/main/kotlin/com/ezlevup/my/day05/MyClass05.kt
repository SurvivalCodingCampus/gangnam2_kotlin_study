package com.ezlevup.my.day05

class MyClass05 {
}

class Sword(
    var name: String,
    var power: Double
) {}

class Hero(
    var name: String,
    hp: Int,
    var sword: Sword? = null,
) {
    private var _hp = hp
    val hp: Int
        get() = _hp
}

class Hero2(
    var name: String,
    hp: Int,
) {
    var hp: Int = hp
        private set
        get() = field + 10 // 객체 내부의 저장 값을 10 더해 반환
    //  get() = hp + 10 // getter에서 다시 getter를 호출해 무한 재귀, 에러 발생

    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            // setDataFromString(value)
        }
}

class TestClass(
    p1: Int,
    val p2: Int,
    var p3: Int,
) {
    var a1: Int = 0  // getter와 setter가 자동 생성
    val a2: Int = 0 // getter만 자동 생성 (불변)
    var a3: Int = p1
}

fun main() {
    println("main")

    val hero = Hero("lee", 100)
    println(hero.hp)

    val hero2 = Hero2("lee", 100)
    println(hero2.hp)
    // hero2.hp = 100 // error Cannot access 'hp': it is private
}
