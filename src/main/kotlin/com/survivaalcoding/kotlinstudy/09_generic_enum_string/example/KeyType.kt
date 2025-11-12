package com.survivaalcoding.kotlinstudy.`09_generic_enum_string`.example

enum class KeyType(val count: Int) {
    PADLOCK(1_024),
    BUTTON(10_000),
    DIAL(30_000),
    FINGER(1_000_000);
}