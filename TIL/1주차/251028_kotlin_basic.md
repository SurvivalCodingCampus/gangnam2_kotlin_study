## Kotlin 기본 문법 정리

###  📁 프로젝트 및 파일 구조

- `src` 폴더 → **새 폴더 생성 시 src 선택하면** 만들어짐
- **패키지 이름**은 소문자로 시작 (`com.example.kotlinstudy`)
- **파일 이름**은 대문자로 시작 (`Main.kt`)
- `Compact Middle Packages` 해제 → 실제 폴더 구조 확인 가능


### 📌 IntelliJ 단축키

| 기능 | 단축키 (Mac) |
| --- | --- |
| 선언부(정의로 이동) | `cmd + b` |
| 이전/다음 파일로 이동 | `cmd + [` / `cmd + ]` |

---

### 1. Print
Kotlin은 **Java 기반 언어**지만, 
불필요한 코드와 버그 가능성을 줄이기 위해 **더 안전하고 간결한 구조**를 지향
- 코드에서 실수할 가능성을 구조적으로 줄이고 읽고 쓰기 쉬운 방식으로 설계

    ex) Null Safety , 자동 타입 캐스팅 등등
g
```kotlin
package com.survivalcoding.kotlinstudy

fun main() {
    println("Hello World")
}

```

```java
@kotlin.internal.InlineOnly
public actual inline fun println(message: Any?) {
    System.out.println(message)
}

```

---
### 2. 함수 (Function)

#### 기본 선언

```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}

```

#### 축약형 (타입 추론 + 표현식 함수)

```kotlin
fun sum(a: Int, b: Int) = a + b

```

#### 리턴값이 없는 경우

```kotlin
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

```

- `Unit` → Kotlin 전용 “리턴 없음” 타입
    
    (Java의 `void`와 유사하지만 완전히 같지는 않음)
    
- `Unit`은 생략 가능 👇
    ```kotlin
    fun printSum(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }

    ```

---

### 3. 변수 (Variables)

| 키워드 | 의미 | 변경 가능성 | 예시 |
| --- | --- | --- | --- |
| `val` | value (값) | ❌ 불변 (읽기 전용) | `val x = 5` |
| `var` | variable (변수) | ✅ 가변 | `var y = 5` |

#### 타입 추론

```kotlin
val x = 5       // Int로 자동 추론
val s = "헬로"   // String으로 자동 추론

```

#### 변수 예시

```kotlin
var y = 5
y++  // 가능

```

**런타임 에러(Runtime Error)**

→ 프로그램 실행 중 발생하는 에러

**상수와 변수의 사용 기준**

| 구분 | 시점 | 키워드 | 변경 가능 | 설명 |
| --- | --- | --- | --- | --- |
| **컴파일 타임 상수** | 실행 전 결정 | `const val` | ❌ | 프로그램 시작 전 메모리에 올라감 |
| **런타임 상수** | 실행 중 결정 | `val` | ❌ | 실행 중 계산 결과로 결정 |
| **변수** | 실행 중 계속 변경 | `var` | ✅ | 반복문, 사용자 입력 등에 사용 |

**예시**

```kotlin
// 컴파일 타임 상수 (프로그램 실행 전)
const val PI = 3.14

// 런타임 상수 (실행 중 계산 가능)
val PI2 = 3.14

// 변수 (값 변경 가능)
var x = 0

```

- Java 와 비교
    - **Java**는 클래스 내부(`static`)에서만 상수 정의 가능
    - **Kotlin**은 **Top-level(파일 최상단)** 에서도 상수 선언 가능

        → 컴파일 타임에 미리 결정되므로 **성능상 이점**이 있음

- Kotlin Convention
    - **상수명:** 모두 대문자 + 언더스코어 (`PI`, `MAX_SIZE`)
    - **패키지명:** 소문자 (`com.example.app`)
    - **파일명:** 대문자로 시작 (`Main.kt`)
    - **함수/변수명:** 소문자로 시작 (`printSum`, `userCount`)
    - **Top-level 변수:** 함수 밖 선언 가능하지만 **메모리 낭비 주의**


### 4. 기본 타입 (Basic Types)

| **Category** | **Basic types** | **Example code** |
| --- | --- | --- |
| Integers | `Byte`, `Short`, `Int`, `Long` | `val year: Int = 2020` |
| Unsigned integers | `UByte`, `UShort`, `UInt`, `ULong` | `val score: UInt = 100u` |
| Floating-point numbers | `Float`, `Double` | `val currentTemp: Float = 24.5f`, `val price: Double = 19.99` |
| Booleans | `Boolean` | `val isEnabled: Boolean = true` |
| Characters | `Char` | `val separator: Char = ','` |
| Strings | `String` | `val message: String = "Hello, world!"` |


#### Java와의 비교

Kotlin 예시

```kotlin
fun main() {
    val x: Int = 5 // 타입 추론 가능
    val s = "헬로"

    // 다형성 : 다른 타입끼리 대입 불가능
    // Java 에서 처럼 큰타입 -> 작은 타입 자동 형변환 안됨
    val z: Long = x // ❌ 오류 (Int → Long 자동 변환 불가)
}
```

  Java 예시

```java
public class JavaMain {
    static int a = 10; // 클래스 로드 시 메모리에 올라감

    public static void main(String[] args) {
        int i = 10;
        Integer ii = 10;

        long ll = i; // 자동 형변환
        char c = 'a';
        char cc = 10;
        float f = 10f;
        double d = 10.0;
        boolean bb = true;

        // 형 변환 (Casting)
        // 구겨 넣기 가능
        d = f;
        f = (float) d;

        String s = "hello world";
    }
}

```
Kotlin 변환시
```kotlin
val a: Int = 10
println(a.toLong()) // . 찍고 메서드 호출 가능

```

### 5. IF
Kotlin에서 `if`는 **문(statement)** 이 아니라 **식(expression)** 

즉, **값을 반환할 수 있음**
```kotlin
val a = 1
val b = 2
println(if (a > b) a else b) // if 자체가 결과값을 반환

```


### 6. when
`when`은 Kotlin의 **switch 대체**이자,

`if-else`보다 깔끔한 **식(expression)** 

```kotlin
val obj = "Hello"

when (obj) {
    "1" -> println("One")
    "Hello" -> println("Greeting")
    else -> println("Unknown")
}
// Greeting

```

- `when`도 반환값을 가질 수 있음

```kotlin
val ddd = when(a) {
    1 -> 10
    2 -> 20
    else -> 30
}

```
-  조건식 형태로도 사용 가능

```kotlin
fun main() {
    val trafficLightState = "Red"

    val trafficAction = when {
        trafficLightState == "Green" -> "Go"
        trafficLightState == "Yellow" -> "Slow down"
        trafficLightState == "Red" -> "Stop"
        else -> "Malfunction"
    }

    println(trafficAction) // Stop
}

```

### 7. for 문

#### Java

```java
for (int j = 0; j < 10; j++);

```

####  Kotlin

```kotlin
for (number in 1..5) {
    print(number)
}
// 12345

```

### 8. 함수의 매개변수

#### Named Arguments

함수 호출 시 인자 이름을 지정할 수 있음
- 순서가 바뀌어도 ok

```kotlin
sum(10, 20) // 일반 호출
sum(a = 10, b = 20) 
sum(b = 20, a = 10)

```

#### Default Parameter Value

매개변수의 기본값 지정 가능

```kotlin
fun sum(a: Int, b: Int = 10): Int {
    return a + b
}

sum(10)      // b는 기본값 10 사용
sum(a = 10)  // 동일

```

-> **Java에서는 이 기능이 없어**, 같은 이름의 메서드를 여러 번 만드는 **오버로딩(Overloading)** 으로 해결해야 함


- Java 오버로딩 예시

    ```java
    class Person {
        private int age;
        private String name;

        // 생성자 1
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // 생성자 2
        public Person() {
            this.name = "홍길동"; // 기본값 설정
        }
    }

    ```

---

### 9.  Null Safety (널 안전성)

Kotlin의 가장 큰 특징 중 하나!

```kotlin
var name: String = "홍길동"
name = null // ❌ 오류 (Non-null 타입)

```

```kotlin
var name2: String? = "홍길동"
name2 = null // ✅ 가능 (Nullable 타입)

```
?가 붙으면 “null 허용” 타입
즉, `String?`은 **null이 될 수도 있는 문자열**이라는 뜻

---

#### !! (Non-null assertion)

`!!`는 “**이건 절대 null이 아니야!**”라고 컴파일러에게 강제로 알려주는 연산자

```kotlin
name = name2!! // ❌ 절대 금지 

```
 정말 필요한 경우 외엔 쓰지 말기! → null이라면 프로그램이 그대로 터짐.

---

####  Elvis Operator (`?:`)

null일 때 **기본값을 대신 반환**하도록 하는 연산자.

```kotlin
fun main() {
    val nullString: String? = null
    println(nullString?.length ?: 0) // null이면 0 반환
}

```

| 코드 | 의미 |
| --- | --- |
| `?.` | null이 아닐 때만 접근 (safe call) |
| `?:` | null일 경우 오른쪽 값을 반환 (Elvis 연산자) |
