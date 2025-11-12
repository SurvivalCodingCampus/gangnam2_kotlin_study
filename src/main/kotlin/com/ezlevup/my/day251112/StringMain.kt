package com.ezlevup.my.day251112

import com.ezlevup.my.Hero
import kotlin.time.measureTime

fun main() {
    var string = "Hello"

    println(string.substring(1, 3)) // el
    // println(string.substring(1, 30)) // error java.lang.StringIndexOutOfBoundsException
    println(string.take(2)) // He

    string = "HELLO"
    println(string.replace("LL", "XX")) // HEXXO

    string = "1,2,3"
    val parts = string.split(',')
    parts.forEach(::println) // List<String>

    string = "HELLO"
    println(string.lowercase()) // hello

    string = "HELLO"
    println(string.indexOf('E')) // 1

    var s1 = "KOTLIN"
    var s2 = "kotlin"
    println(s1 == s2) // false
    println(s1.lowercase() == s2.lowercase()) // true
    println(s1.lowercase().equals(s2)) // true

    println(s1.length) // 6
    println(s1.isEmpty()) // false

    // contains() : 포함 관계
    // endsWith() : 끝나는 단어가 맞는지
    // indexOf() : 단어가 몇 번째에 있는지
    // lastIndexOf() : 뒤에서 몇 번째에 단어가 있는지

    s1 = "A Kotlin and Android"
    println(s1.contains("Kotlin")) // true
    println(s1.endsWith("Android")) // true
    println(s1.indexOf("Kotlin")) // 2
    println(s1.lastIndexOf("A")) // 13

    println(s1.lowercase())
    println(s1.uppercase())
    println(s1.trim())
    println(s1.replace("and", "or")) // A Kotlin or Android

    val sb = StringBuilder("Kotlin")
    sb.append(" and ")
        .append("Android King")
    println(sb.toString())


    val time = measureTime {
        var string = ""
        repeat(10) {
            string += it.toString()
        }
    }
    println(time) // 3.18s

    val time2 = measureTime {
        val sb = StringBuilder("")
        repeat(10) {
            sb.append(it.toString())
        }
    }
    println(time2) // 5.89ms


    // 인스턴스 비교
    val hero1 = Hero("lee")
    val hero2 = Hero("lee")
    println(hero1 === hero2) // false

    val str1 = "hello"
    val str2 = "hello"
    println(str1 === str2) // true

    val str3 = String("hello".toCharArray())
    println(str1 === str3) // false

    val str4 = "hel" + "lo"
    println(str1 === str4) // true

    val str5 = "hel" + getLo()
    println(str1 === str5) // false

}

fun getLo() = "lo"
