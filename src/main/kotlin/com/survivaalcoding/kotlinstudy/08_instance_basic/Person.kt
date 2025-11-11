package com.survivaalcoding.kotlinstudy.`08_instance_basic`

class Person(val name: String, val age: Int) {
    fun copy(name: String = this.name, age: Int = this.age) = Person(name, age)
}