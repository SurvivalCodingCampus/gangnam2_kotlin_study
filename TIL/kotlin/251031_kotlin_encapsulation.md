# Encapsulation 캡슐화

Kotlin에서 접근 제한자는 `private`, `public`만 존재하고 기본 값은 `public`이다.

Java에서는 캡슐화를 하기 위해 필드에 `private`를 사용하고 `getter`, `setter`로 필드에 접근하는데
Kotlin에서는 기본 생성자에 `private`로 선언하면 `getter`도 생성이 안되기 때문에 그렇게 하지 않는다.
또한, `getter`. `setter` 정의를 클래스 본문 변수 선언 밑에 1 depth에 `get()`, `set()` 정의한다.

다음과 같은 방법들로 `private` 접근 제어자 변수를 선언한다:

**데이터를 외부에 노출하는 방법 (읽기 전용)**
```kotlin
class Hero(
    var name: String,
    hp: Int,    // 생성자 파라미터로만 사용
    var sword: Sword? = null
) {
    private var _hp = hp    // 내부에서 _로 선언
    val hp: Int
        get() = _hp
}
```
**`private` 접근 제한자를 변수에 사용하지 않고 `private set`으로 선언** 
```kotlin
class Hero(var name: String, hp: Int = 100) {
    var hp: Int = hp
        private set // private set: 세터를 막음
}
```

Kotlin에서 `val`, `var`를 생성자에 붙여서 선언해야 `getter`, `setter`를 생성해줌
즉, `val`, `var`가 없으면 멤버가 아니다.

## require() 확장함수
예외 처리를 `throw Exception()` 대신 함수로만 처리할 수 있다.
기본으로 `IllegalArgumentException`으로 예외를 발생한다.

```kotlin
class Hero(
    name: String,
    var hp: Int,
    var sword: Sword? = null,
) {
    var name: String = name
        set(value) {
            require(value.length > 1) { "이름이 너무 짧습니다" }
            require(value.length < 8) { "이름이 너무 깁니다" }
            field = value
        }
}
```

# Collections 컬렉션

Java와 동일하게 `List`, `Set`, `Map` 등이 존재하고, 불변, 변경 가능한 컬렉션을 만들 수 있다는 것도 같다.
다만, Kotlin에서는 변경 가능한 컬렉션을 만드는 것은 함수명 자체로 표시하고 있다.

**불변 List**
```kotlin
val list = listOf(1, 2, 3)
```

**변경 가능한 List**
```kotlin
val list = mutableListOf(1, 2, 3)
```
## List 탐색 방법

```kotlin
for (name in names) {
    println(name)
}

names.forEach {
    println(it)
}

names.forEach { name ->
    println(name)
}

names.forEach(::println)
```

## Map

```kotlin
val gildong = mapOf(
    "name" to "홍길동",
    "age" to 20
)

gildong.entries.forEach {
    println(it.key)
    println(it.value)
}
```
