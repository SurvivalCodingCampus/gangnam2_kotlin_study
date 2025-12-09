package com.hhp227.kotlinstudy.`19_flow`

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip

/*
연습문제1
1.flow{ } 빌더를 사용하여 1부터 5까지의 숫자를 100ms 간격으로 방출하는 Flow 를 생성하시오
2.이 Flow에 filter 연산자를 적용하여 짝수만 남기시오
3.map 연산자를 적용하여 남은 각 숫자에 10을 곱한 값을 만드시오
4.최종 결과를 collect() 함수로 수집하여 출력하시오

연습문제2
1.Flow A: "A1", "A2", "A3" 세 개의 문자열을 각각 300ms 간격으로 방출하는 Flow를 만드시오
2.Flow B: "B1", "B2", "B3", "B4" 네 개의 문자열을 각각 100ms 간격으로 방출하는 Flow를 만드시오
3.Flow A와 B를 zip 연산자로 합치고 결과를 출력하여, 어떤 값이 몇 쌍 묶여서 방출되는지 확인하시오
4.Flow A와 B를 combine 연산자로 합치고 결과를 출력하여, 어느 시점에 새로운 값이 방출되며 어떤 값의 조합이 사용되는지 확인하시오

연습문제3
1.Dispatchers.IO에서 동작하는 Flow를 만들고, 이 Flow가 "데이터 로딩 중"이라는 메시지를 방출하게 하시오.
2.이 Flow에 flowOn(Dispatchers.Default)를 적용하여 연산이 일어나는 스레드를 변경하시오.
3.사용자의 연속된 키보드 입력(예: 5개의 문자열을 아주 짧은 간격으로 순차 방출)을 가정하여 Flow를 만드시오.
4.이 Flow에 debounce(300)을 적용하여, 입력이 300ms 동안 멈췄을 때만 최종 값을 방출하도록 처리하고 결과를 출력하시오. (연타 방지 효과 확인)

 */

val intFlow: Flow<Int> = flow {
    for (i in 1..5) {
        emit(i)
        delay(100)
    }
}
    .filter { it % 2 == 0 }
    .map { it * 10 }

val flowA: Flow<String> = flow {
    for (s in listOf("A1", "A2", "A3")) {
        emit(s)
        delay(300)
    }
}

val flowB: Flow<String> = flow {
    for (s in listOf("B1", "B2", "B3", "B4")) {
        emit(s)
        delay(100)
    }
}

val zipFlow = flowA.zip(flowB) { a, b ->
    a + b
}

val combineFlow = flowA.combine(flowB) { a, b ->
    a + b
}

val loadingFlow: Flow<String> = flow {
    emit("데이터 로딩 중...")
}
    .flowOn(Dispatchers.IO)

val userInputFlow: Flow<String> = flow {
    for (input in listOf("a", "ab", "abc", "abcd", "abcde")) {
        emit(input)
        delay(50)
    }
}

