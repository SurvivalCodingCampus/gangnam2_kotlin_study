package com.neouul.sesac.`03-encapsulation`

class Hero(
    name: String,
    hp: Int,    // 캡슐화
    var sword: Sword? = null,
) {
    // hp를 클래스 밖에서 Read-Only로 만드는 방법1
    // getter 재정의
    private var _hp = hp    // 내부에서 _로 선언. 관행
    val hp: Int
        get() = _hp

    // hp를 클래스 밖에서 Read-Only로 만드는 방법2
    // setter 재정의 (막음)
//    var hp: Int = hp
//        private set

    // setter에서 유효성 검사하는 방법
    var name: String = name
        set(value) {
            require(value.length > 1) { "이름이 너무 짧습니다" }
            require(value.length < 8) { "이름이 너무 깁니다" }
            // backing field: 실제 필드 값
            field = value
        }

    fun bye() {
        println("바이바이")
    }

    private fun die() {
        println("You Died")
    }
}

class Sword(
    var name: String,
    var power: Double,
)