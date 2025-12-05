package com.survival.kotlinstudy.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

fun flow1() = flow {
    for (i in 1..5) {
        delay(100)
        emit(i)
    }
}.filter { it % 2 == 0 }.map { it * 10 }