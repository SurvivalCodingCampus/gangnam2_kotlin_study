package com.luca.kotlinstudy._10_string

fun main() {
    val str1 = "hello world"
    val str2 = "hello world"

    println(str1 === str2) // 문자열은 자주 사용해서 상수로 처리가 된다. String pool에 있으면 거기 있는 걸 가져온다.

    val str3 = String("hello world".toCharArray()) // heap
    println(str1 === str3) // false 런타임에 사용되는 애들은 새로 만들어서 쓴다. 생성자는 런타임에 생성

    val str4 = "hello " + "world" // 컴파일러는 이미 hello라는 것을 알고있다. 생성자가 아니기 때문
    println(str1 === str4)

    val str5 = "hello wor" + getld() // getld() 는 런타임에 결정된다.
    println(str1 === str5)
}

fun getld() = "ld"