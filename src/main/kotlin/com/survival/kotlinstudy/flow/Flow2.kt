package com.survival.kotlinstudy.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

/**
 * Flow A: "A1", "A2", "A3" 세 개의 문자열을 각각 300ms 간격으로 방출하는 Flow를 만드시오
 * Flow B: "B1", "B2", "B3", "B4" 네 개의 문자열을 각각 100ms 간격으로 방출하는 Flow를 만드시오
 * Flow A와 B를 zip 연산자로 합치고 결과를 출력하여, 어떤 값이 몇 쌍 묶여서 방출되는지 확인하시오
 * Flow A와 B를 combine 연산자로 합치고 결과를 출력하여, 어느 시점에 새로운 값이 방출되며 어떤 값의 조합이 사용되는지 확인하시오
 */
fun flowA() = flowOf("A1", "A2", "A3").onEach { delay(300) }
fun flowB() = flowOf("B1", "B2", "B3").onEach { delay(100) }
