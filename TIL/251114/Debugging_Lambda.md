```# 디버깅

- 소프트웨어의 오류를 식별하고 수정하는 과정(= 에러를 고치는 것)

## 디버깅의 중요성

- 디버깅은 소프트웨어가 올바르게 작동하는지 확인하는 데 필수적
- 디버깅하지 않으면 소프트웨어가 오류가 발생하거나 제대로 작동하지 않을 수 있다.

## 디버깅 기술

- 로깅 ( print() 함수를 활용하는 방법 )
    - 로깅은 코드가 실행되는 동안 발생하는 이벤트를 기록하는 데 사용
- 브레이크 포인터 ( Debug 모드로 실행하여 원하는 위치에서 코드를 멈출 수 있음 )
    - 브레이크포인트는 코드의 특정 지점에서 실행을 중지하는 데 사용
    - 보고 싶은 변수가 이미 생성된 시점에 걸어야 함
- 디버거 ( 디버그 모드로 실행하여 브레이크 포인트에서 멈추거나 에러가 나면 다양한 도구를 활용하여 에러를 찾는데 도움 )
    - 디버거는 디버깅을 도와주는 도구입니다. 다양한 기능을 제공하며 디버깅을 더 쉽게 만듦
- 스택 추적 ( 어떤 경로로 코드가 실행되었는지 추적가능 )
    - 스택 추적은 호출 스택을 추적하여 코드가 실행 중인 위치를 확인하는 데 사용

## 디버깅 팁

- 작게 시작
    - 디버깅할 때 작은 문제부터 시작. 이렇게 하면 더 큰 문제로 넘어가기 전에 한 번에 한 가지 문제에 집중할 수 있다.
- 단순하게 유지
    - 디버깅할 때 코드를 단순하게 유지하는 것이 중요. 이렇게 하면 오류의 원인을 파악하기가 더 쉽다.
- 인내심을 가지기
    - 디버깅은 시간이 많이 걸릴 수 있으므로 인내심을 갖는 것이 중요. 오류를 찾는 데 즉시 성공하지 못하더라도 낙심하지 말자.

# 람다식과 함수

## 1급 객체

- 변수에 대입 가능한 객체를 1급 객체라고 한다.
- 대표적인 1급 객체 : 값, 인스턴스, 함수

## 함수

- 함수 역시 1급 객체
- 입력이 동일할 때 항상 동일한 출력을 한다.

```kotlin
f(x) = 2 x +3
```

## 함수의 표현 방법

- 일반 함수 : 함수 본문을 '{}'로 감싸고 return 명시

```kotlin
fun sum(a: Int, b: Int) {
    return a + b
}
```

- Expression Body 또는 Single expression function : 함수가 단 한 줄로 끝나는 경우 간단하게 = 를 사용해 표현

```kotlin
fun multiply(a: Int, b: Int): Int = a * b
fun multiply(a: Int, b: Int) = a * b
```

- 람다식 또는 람다 표현식 : 일급 함수처럼 함수를 변수에 저장하거나 함수의 인자로 전달할 수 있는 익명 함수

```kotlin
val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
val square: (Int) -> Int = { it * it } // 단일 매개변수 람다 (람다의 매개변수가 하나인 경우 매개변수를 생략하고 it을 사용할 수 있다)
repeat(3) {  // 후행 람다 (함수의 마지막 인자가 람다일 경우, 함수 호출 소괄호 밖에 람다를 작성할 수 있다)
    println("반복")
}
```

### 함수를 값으로 전달하는 예

- 입출력 타입만 같으면 같은 함수로 볼 수 있다.

```kotlin
fun printElement(element: Int) {
    println(element)
}
fun main() {
    val list = listOf(1, 2, 3)
    list.forEach(::printElement)
}
```
-function reference : 함수를 일급 객체로 다룰 수 있게 값으로 취급, 호출 X

### 메서드와 함수의 차이

- 메서드는 클래스에 속하고 클래스를 조작하기 위한 일종의 함수
- 메서드는 이름이 있지만, 함수에게는 이름은 중요하지 않다.
- 메서드 : 클래스 내부에 정의된 함수
- 함수 : 독립적으로 존재하는 코드
```kotlin
val list = listOf(1, 2, 3)
list.forEach({ e -> println(e) })

// 트레일링 람다 = 마지막 인자의 람다를 괄호 밖으로 빼는 문법
val list = listOf(1, 2, 3)
list.forEach { e -> println(e) }

```
- 후행 람다 문법은 메서드처럼 보이지만 사실 함수형 스타일의 호출
## 람다식

- 함수 내용을 바로바로 정의해서 사용하고 싶을 때 사용

```kotlin
// 함수를 값에 저장
val loudify = { msg: String -> "!!! ${msg.uppercase()} !!!" }
assert(loudify("hello") == "!!! HELLO !!!")
```

- { 매개변수: 타입 -> 실제 실행 코드 }
- 문자열을 받아서 대문자로 바꾸고 감탄부호로 감싸서 반환하는 함수
- 람다를 변수에 담았기 때문에 변수 이름을 함수처럼 호출 가능하다.

### 1. Functional interface 또는 Single Abstract Method (SAM) interface

```kotlin

list.sortedWith(object : Comparator<Int> {
    override fun compare(o1: Int, o2: Int): Int {
        return o1 - o2
    }
})
// 코틀린 SAM : 인퍼테이스 메서드 하나면 람다로 표현 가능
list.sortedWith { o1, o2 -> o1 - o2 }


```
- 코틀린의 SAM은 함수형 인터페이스(Java)에서만 동작한다
### 2. 축약형 코드

```kotlin
button.setOnClickListener(object : View.OnClickListener {
    override fun onClick(v: View?) {
        TODO()
    }
})

// SAM
button.setOnClickListener({ view -> TODO() })

// 트레일링 람다
button.setOnClickListener { view -> TODO() }

// 미사용 파라미터 생략
button.setOnClickListener { TODO() }

```

## 콜백

- 나중에 실행될 코드를 미리 등록해두는 것
- 비동기 개념, 이벤트 처리 방식, 함수를 파라미터로 전달하는 개념에 대해 이해하기 쉬워진다.

### 1. 콜백 기초

```kotlin
// 콜백 인터페이스 선언
interface OnCompleteCallback {
    fun onComplete()
}

// 타이머
class Timer {
    // 타이머가 끝나면 실행할 코드를 미리 등록
    fun start(callback: OnCompleteCallback) {
        println("타이머 시작!")

        Thread.sleep(1000) // 1초 기다림

        callback.onComplete() // 콜백 호출 = 등록해둔 코드 실행
    }
}
// 콜백을 넘기며 타이머 사용
val timer = Timer()

timer.start(object : OnCompleteCallback {
    override fun onComplete() {
        println("끝! → 1초 후 실행되는 코드")
    }
})

```

- 콜백은 인터페이스나 람다로 구현한다.
- 비동기 처리, 특정 작업 후 실행할 로직에 유용하다.
- 콜백용 인퍼테이스, 여러개의 메서드가 있어도 된다.

### 2. 함수 파라미터로 사용하는 콜백

```kotlin
// 1. 콜백 인터페이스 대신 함수 타입을 사용하는 방식
class Timer {
    fun start(callback: () -> Unit) {
        println("타이머 시작!")

        Thread.sleep(1000)

        callback()   // 1초 후 콜백 실행
    }
}
// 2. 사용 방법1 - 람다 전달 
val timer = Timer()
// 트레일링 람다: 마지막 파라미터라 괄호 없이 가능
timer.start {
    println("띠링!")   // 1초 후 실행됨
}

// 2. 사용 방법2 - 기존 함수 넘기기(함수 참조)
fun onComplete() {
    println("띠링!")
}

timer.start(::onComplete) // 이미 만들어둔 함수를 “값처럼 넘겨주겠다”는 뜻

```

### 3. 콜백을 활용하여 값을 전달하는 예시

```kotlin
// 1. 값을 전달하는 콜백 함수
class Downloader {
    // 진행룰을 전달하는 콜백
    fun download(onProgress: (Int) -> Unit) {
        println("다운로드 시작!")

        for (progress in 0..100 step 20) {
            Thread.sleep(500)   // 0.5초 기다림
            onProgress(progress)   // 콜백으로 진행률 전달
        }
    }
}
// 사용
val downloader = Downloader()

downloader.download { progress ->
    println("다운로드 진행률: $progress%")
}

```

- 콜백 함수는 작업 도중에 발생하는 값(진행률 등)을 외부로 전달하는 데 아주 유용하다.
- 비동기 작업의 결과 처리
- 진행 상황 모니터링
- 에러 처리

### 콜백함수 활용

- 인터페이스 정의가 불필요 하다.
- 더 간단한 문법으로 사용가능하다.
- 더 유연한 사용을 할 수 있다.
- 이것이 함수형 프로그래밍의 시작이다.

## 함수형 프로그래밍

- Kotlin은 객체지향 프로그래밍(OOP)과 함수형 프로그래밍(FP) 특징을 모두 제공하는 멀티 패러다임 언어이다.
- 함수형 프로그래밍은 자료 처리를 수학적 함수의 계산으로 취급하는 프로그래밍 패러다임이고 가변 데이터를 멀리하는 특징을 가진다.
- 함수를 값처럼 다룬다.
- 불변성을 선호한다.
- 순수 함수를 지향한다.
### 고계 함수

- order : 함수를 다루는 방식
- higher-order : 더 높은 수준
- 즉, 더 높은 수준의 함수를 다루는 함수 = 함수를 파라미터로 받는 함수
- 1차 함수는 숫자나 문자열 같은 일반적인 데이터를 받지만 고계 함수는 함수를 데이터처럼 취급하는 함수다.

### Kotlin 에서 제공되는 대표적인 고계 함수

- filter : 조건 필터링
- map : 변환
- forEach : 전체 뺑뺑이
- reduce : 하나씩 줄이기
- fold : 하나씩 접기
- any : 있는지 없는지

### filter 함수

```kotlin
val items = listOf(1, 2, 3, 4, 5)

for (item in items) {
    if (item % 2 == 0) {
        println(item) // 2,4
    }
}

items.filter { it % 2 == 0 }.forEach(::println) //2,4
```

- 조건에 해당하는 요소만 가지는 새로운 컬렉션 생성

### map 함수

```kotlin
val items = listOf(1, 2, 3, 4, 5)

for (item in items) {
    if (item % 2 == 0) {
        println("숫자 $item") // 숫자 2, 숫자 4
    }
}

items.filter { it % 2 == 0 }.map { "숫자 $it " }.forEach(::println) //2,4
```

- 변환된 새로운 컬렉션 생성

### toSet() : 자료구조 Set으로 변환하는 함수

```kotlin
val items = listOf(1, 2, 3, 4, 5)

for (item in items) {
    if (item % 2 == 0) {
        temp.add(item)
    }
}
val result = temp.toList()
println(result) // 2,4

val result = items.filter { it % 2 == 0 }.toSet().toList()
val result = items.filter { it % 2 == 0 }.distinct()
```

- 중복을 허용하지 않기 때문에 간단히 중복데이터를 제거할 수 있다.

### any
```kotlin
val items = listOf(1, 2, 2, 3, 3, 4, 5)

var result = false

for (item in items) {
    if (item % 2 == 0) {
        result = true
        break
    }
}
println(result)

println(items.any { it % 2 == 0})
```

-특정 조건을 충족하는 요소가 있는지를 검사할 때 사용

### 안티패턴 (forEach)
```kotlin
// 1. 잘못된 접근 (forEach에서 break 시도)
list.forEach { item -> // 나쁜 예시 
    if(condition) {
        return@forEach // break처럼 사용하려고 시도
    }
    //처리
}

// 2. 올바른 접근 방법들:

// A. 전통적인 for문 사용 (break가 필요한 경우)
for (item in list) { //좋은예시
    if (condition) break
    // 처리
}

```
- forEach 에서 중단 시도

### 안티패턴 (map)
```kotlin
// 1. map 내에서 return 시도
list.map { item ->
    if (someCondition) {
        return@map null // 의도한 대로 동작하지 않음
    }
    transform(item)
}

// 2. map 내에서 예외 발생
list.map { item ->
    if (someCondition) {
        throw Exception("중단!") // 예외를 흐름 제어에 사용
    }
    transform(item)
}
```
- map에서 중단 시도
- map에서 예외

### 안티패턴의 조건
1. 함수형 프로그래밍의 의도 위반
2. 코드의 예측 가능성 저하
3. 부작용 발생 가능
4. 가독성 저하
5. 유지보수 어려움
- forEach: 각 요소에 대한 동작을 모두 수행
- map: 변한된 새 컬렉션 생성