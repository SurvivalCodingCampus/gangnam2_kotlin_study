package com.survival.kotlinstudy.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

fun flowA() = flowOf("A1", "A2", "A3").onEach { delay(300) }
fun flowB() = flowOf("B1", "B2", "B3").onEach { delay(100) }
