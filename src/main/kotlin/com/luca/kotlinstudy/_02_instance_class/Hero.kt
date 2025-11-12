package com.luca.kotlinstudy._02_instance_class

import com.luca.kotlinstudy._04_collection.MIN_HP_MP
import kotlin.random.Random

fun main() {
    val hero = Hero() // 기본 생성자
    val hero2 = Hero(name = "홍길동", hp = 50) // 기본 생성자
    hero2.name = ""
    val hero3 = Hero(name = "한석봉", hp = 50)
}

// 동적
open class Hero(
    var name: String = "",
    hp: Int = DEFAULT_MAX_HP
) : Comparable<Hero> {
    var hp: Int = hp
        set(value) {
            field = if (value > DEFAULT_MAX_HP) DEFAULT_MAX_HP else value
        }

    // java static 정적 = 얘는 정적이라서 Heap 에 없다. 동적인 Hero와는 소통이 불가하다. 같은 클래스 안에서는 생략이 가능하다. 혹은 탑레벨
    // 메모리에 먼저 올라감
    companion object {
        var MONEY = 100
        const val DEFAULT_MAX_HP = 50


        fun setRandomMoney() { // 클래의 메서드가 아니라 유틸함수다. 인스턴스를 위한 것이 아님.
            MONEY = Random.nextInt(1000)
            // Hero.name에 접근하려면?
            // 메모리가 달라서 서로 모르기 때문에 따로 생성을 해줘야한다.
            val hero = Hero("홍길동")
            hero.name = ""
        }
    }

    // var name: String 이렇게 하면 에러가 난다.
    // 멤버변수, field, 전역 변수
    // name
    // hp
    fun attack() {
        // 로컬변수
        val x: Int = 0
    }

    open fun run() {
        println("Hero의 run")
    }

    fun sleep() {
    }

    fun copy(
        // 자바
        name: String = this.name,
        hp: Int = this.hp,
    ): Hero {
        return Hero(
            name = name,
            hp = hp,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hero) return false

        if (hp != other.hp) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hp
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Hero(hp=$hp, name='$name')"
    }

    override fun compareTo(other: Hero): Int {
        if (this == other) return 0
        return this.name.compareTo(other.name) * -1 // * -1 혹은 this 앞에 - 를 붙이면 반대로 sort할 수 있다.
    }
    //    // 연습 때는 한 번에 클래스를 치지만 실제로 쓸 때는 분산을 해주자.
//    class Slime(hp: Int) { // var 를 안붙이면 활용할 수 가 없다. 수정X
//        val level = 10
//        // const val SLIME_LEVEL = 10 탑레벨에 가능
//    }
}