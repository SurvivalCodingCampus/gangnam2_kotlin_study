package com.sesac.practice.day09.generic

enum class KeyType(
    val tryLimit: Int,
) {
    PADLOCK(1024),
    BUTTON(10_000),
    DIAL(30_000),
    FINGER(1_000_000),
    ;

    fun canOpen(tryCount: Int): Boolean = tryLimit <= tryCount
}
