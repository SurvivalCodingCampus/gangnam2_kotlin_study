package com.hhp227.kotlinstudy.`06_interface`

/*abstract class Human {
    abstract fun speak()
}*/

interface Human {
    val int: Int
    fun speak()
}

class Man : Human {
    override val int: Int = 0

    override fun speak() {
        TODO("Not yet implemented")
    }
}