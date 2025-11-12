package com.survivalcoding.kotlinstudy.`07_instance_basic`

import java.time.LocalDateTime


fun main() {

    val date = LocalDateTime.of(2010, 10, 10, 0, 0, 0).toLocalDate()

    val items = listOf(3, 2, 1, 5, 6)

    items.sortedByDescending{ it }

    val immutableObject = MyClass(1, "홍")

    val immutableObject2 = immutableObject.copy(field1 = 2)
}

// 완벽한 불변
data class MyClass(
    val field1: Int,
    val field2: String,
)