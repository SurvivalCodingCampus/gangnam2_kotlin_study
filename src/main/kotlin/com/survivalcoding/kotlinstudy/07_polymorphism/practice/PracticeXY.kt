package com.survivalcoding.kotlinstudy.`07_polymorphism`.practice

/*
1번.

빈칸에 들어갈 적절한 클래스명을 정하시오

(1) Sword, Sword, Item
(2) Monster, Slime, Slime, Monster
*/

interface X {
    fun a()
}

abstract class Y : X {
    abstract fun b()
}