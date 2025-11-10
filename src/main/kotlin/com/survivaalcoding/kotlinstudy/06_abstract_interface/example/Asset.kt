package com.survivaalcoding.kotlinstudy.`06_abstract_interface`.example

abstract class Asset(val name: String, val price: Int) {
    abstract fun getInfo(): String
}