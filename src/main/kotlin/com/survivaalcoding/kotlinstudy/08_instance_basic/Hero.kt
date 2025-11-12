package com.survivaalcoding.kotlinstudy.`08_instance_basic`

import kotlin.math.min

open class Hero(var name: String, var hp: Int = 100) : Comparable<Hero> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (hp != other.hp) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hp
        result = 31 * result + name.hashCode()
        return result
    }

    override fun compareTo(other: Hero): Int {
        if (this == other) return 0

        return this.name.compareTo(other.name)
    }
}
