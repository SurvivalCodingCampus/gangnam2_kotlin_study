# 코틀린 문법 기초

--------------- 


## 코틀린 특징
- Null 에 안전하다.
- 확장함수
- 코루틴 ( 비동기 )
- JVM 기반 언어
- 속도는 느리지만 장점이 많다. ( 공부하면서 알아보자 )

--------------- 

## 1. 함수

### 1-1 ) 기본예시
```kotlin
fun sum(a: Int, b: Int): Int { // a를 받을 건데 Int 로 받겠다. 괄호 뒤는 반환 타입
return  a + b
}
```
### 1-2 ) 간단한 버전
```kotlin
fun sum(a: Int, b: Int) = a + b
```
### 1-3 ) 리턴 타입이 없는 경우 Unit
```kotlin
fun sum(a: Int, b: Int): Unit { //사실 안적어도 된다. void와 유사함     
println(a + b)
}
```

### 1-4 ) 문자열
```kotlin
fun sum(a: Int, b: Int) {    
println("sum of $a and $b is ${a + b}")
}
```

--------------- 

## 2. 상수와 변수
- val : Value ( 값 : 변하지 않는다 = 상수 )
- var : Variable ( 변수 )

### 2-1 ) 기본예시
```kotlin
fun main() {
    // 상수
    val x = 5
    // val x: Int = 5  // 타입 명시가능 (안해도 타입 추론)
    // x = 4           // 컴파일 에러 발생! val은 재할당 불가능

    // 변수
    var y = 5
    y++                // 가능
    println(y)
}
```

### 2-2 ) 탑 레벨
- Kotlin은 클래스 바깥, 즉 파일의 최상단에도 변수/상수를 선언할 수 있다.

### 2-2-1) const & var 

```kotlin
const val PI = 3.14 // 컴파일타임 상수 : 실행되기 전 메모리 결정 우선순위 먼저 
val PI2 = 3.14      // 런타임 상수 : 실행되면서 메모리 결정 
```
- 메모리에 올라가는 시점이 다르다.
- 나중에 성능차이가 존재할 수 있다. ( 컴파일타임 상수가 조금 더 속도가 빠르다.)

--------------- 
## 3. 다형성과 타입 변환
### 3-1 ) Java와 Kotlin 차이
- Java 에는 기본 타입이 있지만 Kotlin은 기본 타입이 없는 완벽한 객체 지향 언어이다.

### 3-2 ) 타입 변환
- 코틀린과 파이썬은 대소관계가 없다.
- Java와 C는 기본 타입 간 서열이 있어 자동 형변환이 된다.

```Java
// Java
int x = 5;
long z = x; //자동 형변환 (int → long)
```
```kotlin
// Kotlin
// val z: Long = x 오류 발생
val z: Long = x.toLong()
y = 10L.toInt()

```
## 4. Control Flow
- Kotlin의 if와 when은 모두 값을 반환하는 표현식이다.
### 4-1 ) if expression 식
```kotlin
val a = 1
val b = 2

val result = (if (a > b) a else b) // Returns a value: 2
println(result)

```
- 삼항 연산이 필요 없다.
### 4-2 ) when 
```kotlin
val add = when(a) {
    1-> 10
    2 -> 20
    else -> 30
}
```

## 5. Function
### 5-1 ) named arguments
```kotlin

fun sum(a: Int, b: Int = 10): Int { // b는 기본값 10 
 return a + b
}

fun main() {
    // 일반 호출
    println(sum(10, 20)) // 30

    // named arguments (순서 무관)
    println(sum(a = 10, b = 20)) // 30
    println(sum(b = 20, a = 10)) // 30

    // default parameter (b 기본 값 설정 했기때문에 생략가능)
    println(sum(10))      // 20
    println(sum(a = 10))  // 20
}
```
### 5-2 ) Null Safety
```kotlin
fun main() {
    var name: String = "홍길동"
    // name = null  // 오류: null 불가능

    var name2: String? = "홍길동" // null 허용 타입
    name2 = null                // 가능

    // 1) 직접 접근 시 에러
    // println(name2.toInt())   // null 때문에 안됨

    // 2) null 검사 후 접근
    if (name2 != null) {
        println(name2.toInt()) 
    }

    // 3) 안전한 호출
    println(name2?.toInt())     // null이면 실행 안됨 → null 반환

    // 4) 강제 단언 (!! 연산자) - 절대금지 null 이면 터진다.
    name = name2!!       

    // 5) ?:
    val nullString: String? = null
    println(nullString?.length ?: 0) // null이면 0으로 대체
}

```