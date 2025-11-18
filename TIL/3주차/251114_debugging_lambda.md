## 디버깅, 람다식과 함수

### 디버깅

> 소프트웨어의 오류를 식별하고 수정하는 과정

#### 디버깅의 중요성

- 소프트웨어가 올바르게 작동하는지 확인하는데 필수적
- 디버깅 하지 않으면 소프트웨어가 오류가 발생하거나 제대로 작동하지 않을 수 있음

#### 디버깅 기술

| 항목          | 설명                                     |
|-------------|----------------------------------------|
| **로깅**      | 코드를 실행하는 동안 발생하는 이벤트를 기록하는 데 사용        |
| **브레이크포인트** | 코드의 특정 지점에서 실행을 중지하는 데 사용              |
| **디버거**     | 디버깅을 도와주는 도구로, 다양한 기능을 제공하여 디버깅을 쉽게 해줌 |
| **스택 추적**   | 호출 스택을 추적하여 실행 중인 코드의 위치를 확인할 수 있음     |

| 기능                      | 용도                    |
|-------------------------|-----------------------|
| **로깅/println**          | 흐름을 “흘려보면서” 기록        |
| **브레이크포인트**             | 실행을 “멈추고 상태를 검사”      |
| **Evaluate Expression** | 멈춘 상태에서 가상의 코드/연산 테스트 |
| **Variables 탭**         | 현재 스코프의 모든 변수 목록 확인   |

- 브레이크포인트는 **보고 싶은 변수가 '이미 생성된 시점'** 에 걸어야 함
- Evaluate는 해당 시점의 스코프 안에 있는 변수만 조회 가능
    - 원하는 변수가 선언된 줄 이후에 브레이크포인트를 걸 것

---

### 함수

#### 1급 객체(first class object, first class citizen)

> 변수에 대입 가능한 객체 <br/>
> → ex) 값, 인스턴스, 함수

##### 함수(function)

> 함수도 1급 객체로 취급 <br/>
> → 입력이 동일할 때 항상 동일한 출력

- 함수의 표현 방법
    - 일반함수 : 함수 본문을 `{}`로 감싸고  `return` 명시
        ```kotlin
        fun sum(a: Int, b: Int): Int {
            return a + b
        }
        ```
        - return 필수
        - 함수 내부에 여러 줄의 로직이 들어갈 때 사용
    - 표현식 함수
        - 함수가 단 한 줄로 끝나는 경우 간단하게 = 를 사용해 표현
          ```kotlin
          fun multiply(a: Int, b: Int): Int = a * b
          ```
        - 반환 타입 생략 (컴파일러가 자동 추론)
          ```kotlin
          fun multiply(a: Int, b: Int) = a * b
          ```
    - 람다식 : 람다는 일급 함수처럼 **함수를 변수에 저장하거나 함수의 인자로 전달**할 수 있는 익명 함수

        ```kotlin
        val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
        
        // 매개변수일경우 it 사용 가능
        val square: (Int) -> Int = { it * it }
        ```
        - 이름 없는 함수(익명 함수)
        - 함수의 마지막 인자가 람다이면 후행 람다(trailing lambda) 사용 가능
        ```kotlin
        repeat(3) {
            println("반복")
        }
        ```

#### 함수를 값으로 전달

- **function reference(::)**
    - 함수를 *값처럼* 넘길 때 사용
    - 클래스로 다루는 것이 아니라 *함수를 1급 객체처럼 취급*
      ```kotlin
      fun printElement(element: Int) {
          println(element)
      }
      
      fun main() {
          val list = listOf(1, 2, 3)
          list.forEach(::printElement)
      }
      ```

#### 메서드와 함수 차이

- 메서드(Method)
    - 클래스 내부에 정의된 함수
- 함수(Function)
    - 독립적으로 존재하는 코드
    ```kotlin
    val list = listOf(1, 2, 3)
    
    list.forEach({ e -> println(e) })
    list.forEach { e -> println(e) } // 동일 코드 (후행 람다 문법)
    ```
    - 후행 람다 문법은 메서드처럼 보이지만 사실 함수형 스타일의 호출

#### 람다식(lambda expression)

- 함수를 값으로 저장
    ```kotlin
    val loudify = { msg: String -> "!!! ${msg.uppercase()} !!!" }
    assert(loudify("hello") == "!!! HELLO !!!")
    ```

#### Functional Interface / SAM(Single Abstract Method)

- 기존 Java 방식 (익명 클래스)
    ```kotlin
    list.sortedWith(object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1 - o2
        }
    })
    ```
- Kotlin SAM 변환 → 람다로 간단하게!
    ```kotlin
    list.sortedWith { o1, o2 -> o1 - o2 }
    ```
    - 함수가 하나만존재하는 인터페이스는 람다로 변환 가능
    - Comparator, Runnable 등 Java SAM 인터페이스 모두 가능

#### 무명 클래스 → 람다식 → 후행 람다식 → 생략 규칙

- Java 익명 클래스 방식
    ```kotlin
    button.setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View?) {
            TODO()
        }
    })
    ```
- Kotlin SAM 변환
    ```kotlin
    button.setOnClickListener({ view -> TODO() })
    ```
- 후행 람다 적용 (마지막 인자가 람다)
    ```kotlin
    button.setOnClickListener { view -> TODO() }
    ```
- 매개변수 미사용할 경우 `_`
    ```kotlin
    button.setOnClickListener { _ -> TODO() }
    button.setOnClickListener { TODO() }  // 모두 생략
    ```

#### 요약

| 개념        | 설명                      | 예제                            |
|-----------|-------------------------|-------------------------------|
| 일반 함수     | 기본적인 함수 선언 방식           | `fun sum(a,b)=...`            |
| 표현식 함수    | return과 중괄호 생략          | `fun mul(a,b)=a*b`            |
| 람다식       | 함수를 값처럼 사용              | `{ a,b -> a+b }`              |
| 함수 참조(::) | 함수를 그대로 전달              | `::printElement`              |
| 메서드 vs 함수 | 메서드는 클래스 안, 함수는 독립      | `list.forEach {}`             |
| SAM 변환    | 함수 1개 가진 인터페이스 → 람다로 변환 | `sortedWith { o1,o2 -> ... }` |
| 후행 람다     | 마지막 인자가 람다 → 괄호 밖으로 이동  | `forEach { }`                 |
| 매개변수 생략   | 미사용 시 `_` 사용            | `{ _ -> TODO() }`             |

---

### 함수형 프로그래밍

- Kotlin은 객체지향 프로그래밍(OOP)과 함수형 프로그래밍(FP) 특징을 모두 제공하는 멀티 패러다임 언어
- 함수형 프로그래밍은 자료 처리를 수학적 함수의 계산으로 취급하는 프로그래밍 패러다임
    - 가변 데이터를 멀리하는 특징이 있음

#### 고차 함수

> 더 높은 수준의 함수를 다루는 함수 <br/>
> → 함수를 다루는 함수 = 함수를 파라미터로 받는 함수

- `order`: 함수를 다루는 방식
- `high-order` : 더 높은 수준

| 구분        | 의미                                | 수학적 표기              |
|-----------|-----------------------------------|---------------------|
| **1차 함수** | 숫자나 문자열 같은 일반적인 데이터를 입력으로 받는 함수   | ( f : A → B )       |
| **고차 함수** | 함수를 ‘데이터처럼’ 입력으로 받거나, 함수를 반환하는 함수 | ( G : (A → B) → C ) |

#### Kotlin 대표적인 고차 함수

| 함수          | 역할(설명)                      | 결과 형태     |
|-------------|-----------------------------|-----------|
| **filter**  | 조건에 맞는 요소만 골라냄              | 컬렉션       |
| **map**     | 각 요소를 새로운 형태로 변환            | 컬렉션       |
| **forEach** | 모든 요소에 대해 반복 수행 (반환값 없음)    | `Unit`    |
| **reduce**  | 누적 연산으로 하나의 값으로 축약 (초기값 없음) | 단일 값      |
| **fold**    | 누적 연산으로 하나의 값으로 축약 (초기값 제공) | 단일 값      |
| **any**     | 조건을 만족하는 요소가 하나라도 있는지 검사    | `Boolean` |

- filter : 조건에 해당하는 요소만 가지는 새로운 컬렉션 생성

    ```kotlin
    // for문
    val items = listOf(1, 2, 3, 4, 5)
    
    for (item in items) {
        if (item % 2 == 0) {
            println(item)    // 2, 4
        }
    }
    
    // filter + forEach
    items
        .filter { it % 2 == 0 }
        .forEach(::println)   // 2, 4
    ```

- map : 변환된 새로운 컬렉션 생성

    ```kotlin
    // for문
    val items = listOf(1, 2, 3, 4, 5)
    
    for (item in items) {
        if (item % 2 == 0) {
            // 숫자 2, 숫자 4
            println("숫자 $item")
        }
    }
    
    // filter + map + forEach
    items
        .filter { it % 2 == 0 }
        .map { "숫자 $it" }
        .forEach(::println)
    
    ```

- toSet() : 자료구조를 Set 으로 변환하는 함수

    ```kotlin
    // for문 + Set
    val items = listOf(1, 2, 2, 3, 3, 4, 5)
    
    val temp = mutableSetOf<Int>()
    
    for (item in items) {
        if (item % 2 == 0) {
            temp.add(item)
        }
    }
    
    val result = temp.toList()
    println(result)   // 2, 4
    
    // toSet + toList
    val result = items
        .filter { it % 2 == 0 }
        .toSet()
        .toList()
    
    // distinct
    val result = items
        .filter { it % 2 == 0 }
        .distinct()
    ```

- any : 특정 조건을 충족하는 요소가 있는지 검사

    ```kotlin
    // for문
    val items = listOf(1, 2, 2, 3, 3, 4, 5)
    
    var result = false
    
    for (item in items) {
        if (item % 2 == 0) {
            result = true
            break
        }
    }
    
    println(result)
    
    // any
    println(items.any { it % 2 == 0 })
    ```

- reduce : 반복 요소를 줄여가면서 결과를 만들 때 사용

    ```kotlin
    // for문
    val items = listOf(1, 2, 3, 4, 5)
    
    var maxResult = items[0]
    for (item in items) {
        maxResult = max(maxResult, item)
    }
    
    println(maxResult)
    
    // reduce
    println(items.reduce { acc, i -> max(acc, i) })  // 5
    
    // 함수 참조(::max)
    println(items.reduce(::max))  // 5
    ```

#### 안티패턴

- forEach에서 중단 시도

    ```kotlin
    // 1. 잘못된 접근 (forEach에서 break 시도)
    list.forEach { item ->      // ❌ 나쁜 예시
        if (condition) {
            return@forEach      // break처럼 사용하려고 시도
        }
        // 처리
    }
    ```

    ```kotlin
    for (item in list) {        // ✅ 좋은 예시
        if (condition) break
        // 처리
    }
    ```

- map에서 중단 시도, map 에서 예외

    ```kotlin
    // 1. map 내에서 return 시도
    list.map { item ->
        if (someCondition) {
            return@map null     // ❌ 의도한 대로 동작하지 않음
        }
        transform(item)
    }
    
    // 2. map 내에서 예외 발생
    list.map { item ->
        if (someCondition) {
            throw Exception("중단!")   // ❌ 흐름 제어에 예외 사용은 비권장
        }
        transform(item)
    }
    ```

#### 안티패턴의 조건

- 함수형 프로그래밍의 의도 위반
- 코드의 예측 가능성 저하
- 부작용 (side effect) 발생 가능
- 가독성 저하
- 유지보수 어려움
