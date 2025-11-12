package com.neouul.sesac.`07-instance-manual`

fun main() {
    // primitive type - 숫자
    val a = 10
    val b = 10
    println(a === b)

    val intList = mutableListOf<Int>()
    intList.add(a)
    println(intList.size)
    intList.remove(b)
    println(intList.size)

    // 문자열
    val c = "10"
    val d = "10"
    println(c === d)

    val strList = mutableListOf<String>()
    strList.add(c)
    println(strList.size)
    strList.remove(d)
    println(strList.size)

}