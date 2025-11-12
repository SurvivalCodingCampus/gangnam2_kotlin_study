package com.survivalcoding.kotlinstudy.`09_string`

fun main() {
    val str1 = "hello"
    val str2 = "hello"
    println(str1 === str2)

    println("=================")

    val str3 = String("hello".toCharArray())    // heap
    println(str1 === str3)

    println("=================")
    val str4 = "hel" + "lo"
    println(str1 === str4)

    println("=================")
    val str5 = "hel" + getLo()
    println(str1 === str5)
}

fun getLo() = "lo"