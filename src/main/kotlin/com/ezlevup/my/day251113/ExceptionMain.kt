package com.ezlevup.my.day251113

import java.io.IOException

class Lee {
    fun readFile(path: String) {
        throw IOException("File not found")
    }
}

class Person(val name: String?)

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun main() {
    val lee = Lee()
    // lee.readFile("c:/sample.txt")

    // val person = Person(name = null)
    val person = Person(name = "kim")
    val s: String = person.name ?: fail("Name required")
    println(s)

    
}
