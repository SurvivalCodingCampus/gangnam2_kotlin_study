# 제네릭

### 전 날 리뷰

- toLocalDate() : 타입은 투로컬데이트
- 타입체크하고 왜 이퀄스가 되는지 확인해보기 toString()까지 넣어줘야 한다.
- LocalDateTime : 불변. 까고 들어가면 필드에 final이 붙으면 불변이다. (ctrl + B)
- 년월일이 같으니까 시분초도 달랐을 때 테스트가 되는지 확인

```kotlin
val items = listOf(3, 2, 1, 5, 6)
val sorted = items.sortedByDescending { it }
println(sorted) // [6, 5, 3, 2, 1]
```

- 불변을 복사하는 건 무의미하다. 각자 가져가야 하는 것이라면 복사하는 게 맞다.
- 불변의 값을 바꾸려면 새로 만들어야 한다. 카피를 해서 바꿔주자. = 변수를 없애는 길이다.
- 자바 cloneable 인터페이스로 구현한다. 안에 불변이나 값이 있을 때 강제성이 없어서 구리다.

### 타입이 없다면(Any)?

- 런타임 에러가 나기 쉽다.
- IDE가 컴파일 에러를 미리 찾을 수 없다.

## 제네릭

- 사용하는 시점에 타입을 원하는 형태로 정의할 수 있음.
- 타입 안전효과가 있다.

```kotlin
// ex
List<E> Class{} 
Map<K, Y> Class{}
// E 는 element (요소)다.
```

### Advanced

1. 읽기 전용(읽기 전용 (Covariance (공변성)) : Poket<Out T>
2. 쓰기 전용 (Contravariance (반공변성)): Poket<in T>
3. 둘 다 됨 (Invariance (무변성)): Poket<T>

- 기본적으로 일반 제네릭을 사용한다.

## 열거형(enum)

- 정해둔 값만 넣어둘 수 있는 타입
- 모든 처리를 강제할 수 있다.

# 문자열

## 문자열 조작

### 문자열 처리 (결합)

1. "Hello" + "Kotlin" => "Hello Kotlin"
2. ${수식}을 활용한 문자열 결합

### 문자열 처리 (일부 떼어내기)

```kotlin
val string = "Hello"
println(string.substring(0, 2)) // "He"
```

### 문자열 처리 (일부 치환)

```kotlin
val string = "Hello"
println(string.replace("ll", "xx")) // "Hexxo"
```

### 문자열 처리 (분리)

```kotlin
val string = "1,2,3"
val parts = string.split(',')
parts.forEach(::println)
```

### 문자열 처리 (대소문자 변경)

```kotlin
val string = "HELLO"
println(string.lowercase())
```

### 문자열 처리 (검색)

```kotlin
val string = "HELLO"
println(string.indexOf('E'))
```

### 문자열 처리 (내용 비교)

```kotlin
val s1 = "KOTLIN"
val s2 = "kotlin"

println(s1 == s2) // false
println(s1.lowercase() == s2.lowercase()) // true
```

### 문자열 처리 (내용 비교)

```kotlin
val s1 = "KOTLIN"

println(s1.length) // 6
println(s1.isEmpty()) // false
```

### 문자열 처리 (검색)

```kotlin
val s1 = "Kotlin and Android"

println(s1.contains("Kotlin")) // true
println(s1.endsWith("Android")) // true
println(s1.indexOf("Kotlin")) // 0
println(s1.lastIndexOf("A")) // 11
```

### 문자열 처리 (변환)

```kotlin
val s1 = "Kotlin and Anfroid"

println(s1.lowercase()) // 소문자로
println(s1.uppercase()) // 대문자로
println(s1.trim()) // 좌우 공백 제거
println(s1.replace("and", "or")) // 소문자로
```

## 문자열 결합 방법

1. +연산
2. String interpolation
3. StringBuilder
4. StringBuffer (Java보다 중요도 떨어짐)

### StringBuilder

- append()메서드 결합한 결과를 내부 메모리(버퍼)에 담아두고 toString()으로 결과를 얻음

```kotlin
val sb = StringBuilder("Kotlin")

sb.append("and")
    .append("Android")
println(sb.toString())
```
- String 인스턴스는 불변 객체다. 그래서 +연산자를 하면 메모리에 계속해서 생긴다.
- StringBuilder는 비동기/단일 스레드에 적합. StringBuffer는 동기화 포함(스레드 안전)이지만 Kotlin에선 거의 필요 없어 중요도 낮음.
