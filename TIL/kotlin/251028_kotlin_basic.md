# Kotlin

## Kotlin 특징
- Null에 안전
- 확장 함수
- 코루틴
- JVM 기반 언어
- java와 다르게 Class를 가질 필요가 없다(빈 파일 가능)
- **`;`** 세미콜론 사용하지 않음
- **`Unit`** : java의 void와 유사

## 기본 문법 (Basic Syntax)
```kotlin
fun main() {  
    println("Hello World")
}
```

## 키보드 입력 (Input)
```kotlin
fun main() {
    val reader = readln()
    val readerLine = readLine()
}
```

## 함수 (Funcations)
`fun` 키워드를 사용해서 함수를 선언한다.

```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 위의 내용을 단축시킬 수 있다
fun sum(a: Int, b: Int) = a + b
```

### 명명된 인수 (Named arguments)
함수 호출할 때 이름을 명칭할 수 있다. 명명하기 때문에 인수의 순서가 상관없다.

```kotlin
fun main() {
    sum(a = 10, b = 20)
    sum(b = 10, a = 20)
}

fun sum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
```

### 기본 값 (Default value)
파라미터에 `=`로 기본 값을 지정할 수 있다.  
kotlin에서는 오버로딩을 굳이 하지 않고 **default value** 로 지정을 대체할 수 있다.

```kotlin
fun main() {   
    sum(a = 10, b = 20)
    sum(b = 10, a = 20)
}

fun sum(a: Int, b: Int = 0): Unit {
    println("sum of $a and $b is ${a + b}")
}
```

## 문자열 템플릿 (String Templates)
문자열에 `$`, `{}`로 **변수와 식(expression)** 을 사용할 수 있다.

```kotlin
fun sum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
```

## 변수 (Variables)
- **`val`** : Read-Only 변수(상수). 런타임 상수
- **`var`** : 변경 가능한 변수
- **`Top level`** : `main()`, `Class` 등 외부에 선언된 변수, 함수 등
  - **`const val`** : 컴파일타임 상수

> Intellij에서 Kotlin 코드 Decompile 확인 방법  
> Actions > Show Kotlin Bytecode > Decompile

## 기본 유형 (Basic Types)
Primitive Type이 존재하지 않고, 전부 Reference Type

| Category               | Basic types                        | Example code                                                     |
| ---------------------- | ---------------------------------- | ---------------------------------------------------------------- |
| Integers               | `Byte`, `Short`, `Int`, `Long`     | `val year: Int = 2020`,<br>`val number: Long = 200L`             |
| Unsigned integers      | `UByte`, `UShort`, `UInt`, `ULong` | `val score: UInt = 100u`                                         |
| Floating-point numbers | `Float`, `Double`                  | `val currentTemp: Float = 24.5f`,<br>`val price: Double = 19.99` |
| Booleans               | `Boolean`                          | `val isEnabled: Boolean = true`                                  |
| Characters             | `Char`                             | `val separator: Char = ','`                                      |
| Strings                | `String`                           | `val message: String = "Hello, world!`                           |

## 타입 캐스팅
java에서는 작은 크기의 타입은 큰 크기의 타입에 대입하면 자동 캐스팅 해주고, 큰 것에서 작은 것으로 대입하려면 명시적 캐스팅을 해야 한다.   
그러나 kotlin에서는 자동 캐스팅이 없다. 다음과 같이 해야 한다.

```kotlin
fun main() {
    val x = 5
    val z: Long = x.toLong()
}
```

## 조건문 (Control Flow)
### if
if를 **식(expression)** 으로 사용할 수 있다.

```kotlin
fun main() {
    val a = 1
    val b = 2

    val result = if (a > b) a else b
    println(result)
}
```

### when
when를 **식(expression)** 으로 사용할 수 있다.

```kotlin
val obj = "Hello"

when (obj) {
    "1" -> println("One")
    "Hello" -> println("Greeting")
    else -> println("Unknown")     
}
```

```kotlin
val obj = "Hello"

val result = when (obj) {
    "1" -> println("One")
    "Hello" -> println("Greeting")
    else -> println("Unknown")     
}
println(result)
```

## 범위 Ranges
- `1..4` : 1부터 4까지 증가
- `4 downTo 1` : 4부터 1까지 감소

## 반복문 Loops
while은 java와 동일하다. for는 방식이 다른데 아래와 같이 반복문을 사용할 수 있다.  
`repeat`, `for (i in 0..5)`, `x.forEach {}` 등이 있다.

```kotlin
// 0 until 10(times)
repeat(10) {
}

for (i in 0..10) {
}
```

## Null Safety
타입 선언에 `?`가 없으면 `null`을 허용하지 않고, 있으면 허용한다.

```kotlin
// val name: String = null compile error

// String nullable Type
var name: String = "200"
println(name.toInt())

var name2: String? = "10"
name2 = null

if (name2 != null) {
  println(name2.toInt())
} else {
  println("null")
}
println(name?.toInt()) // 안전한 호출

// !!로 null이 아님을 보증 (절대 금지)
name = name2!!
```

## 엘비스 연산자 (Elvis operator)
`?:`를 사용해서 값이 null이면 `?:` 뒤의 값으로 대체한다.

```kotlin
fun main() {
    val nullString: String? = null
    println(nullString?.length ?: 0)
    // 0
}
```
