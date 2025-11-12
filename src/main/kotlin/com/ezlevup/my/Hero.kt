package com.ezlevup.my

class Hero(
    val hp: Int,
    val mp: Int,
) : Comparable<Hero> {
    override fun compareTo(other: Hero): Int {
        println("compareTo")
        return 1;
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hero

        if (hp != other.hp) return false
        if (mp != other.mp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hp
        result = 31 * result + mp
        return result
    }


}
