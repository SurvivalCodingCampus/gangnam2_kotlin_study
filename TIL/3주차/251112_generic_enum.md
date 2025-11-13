## 제네릭, 열거형 (generic, enum)

### generic

> 타입(type)을 변수처럼 다루는 문법

- 클래스나 함수가 특정 타입에 고정 되지 않음
- 사용자 시점에 타입을 지정할 수 있음

#### 기본 예시

```kotlin
class StrongBox<E> {
    private var data: E? = null

    fun put(item: E) {
        data = item
    }

    fun get(): E? = data
}
```

- < E > 가 제네릭 타입의 매개 변수
    - E는 "Element"의 약자
- E, T, K, V 를 많이 씀

#### 제네릭을 사용하지 않았을 경우

> 타입이 고정되지 않으니까 Any나 Object로 처리

```kotlin
class StrongBox {
    private var data: Any? = null
    fun put(item: Any) {
        data = item
    }
    fun get(): Any? = data
}

val box = StrongBox()
box.put("Hello")

// ❌ String인지 모르기 때문에 매번 캐스팅 필요
val str = box.get() as String
println(str.length)
```

- 타입을 직접 변환(casting)해야 함
- 잘못된 타입으로 변환하면 런타임 오류 발생 (ClassCastException)

#### 제네릭을 사용할 경우

- **타입 안정성**: 잘못된 타입 저장 불가
- **형변환 불필요**: as 없이 바로 사용 가능
- 컴파일 타임에 오류 발견 가능

#### 제네릭 함수

```kotlin
fun <T> identity(value: T): T {
    return value
}

val a = identity(123)     // T = Int
val b = identity("Hello") // T = String
```

#### 고급

- 무변성 (Invariance)

> 타입이 정확히 일치해야만 대입 가능 — List<Any>에 List<String>을 넣을 수 없음

```kotlin
val strings: List<String> = listOf("A")
val anys: List<Any> = strings // ❌ 오류 (무변성)
```

- 공변성 (Covariance, out)

> 자식 → 부모 방향 대입 허용 (out) — 읽기 전용에서 안전

```kotlin
val strings: List<String> = listOf("A")
val anys: List<out Any> = strings // ✅ 가능 (공변성)
```

- 반공변성 (Contravariance, in)

> 부모 → 자식 방향 대입 허용 (in) — 쓰기 전용에서 안전

```kotlin
val anyPrinter: (Any) -> Unit = { println(it) }
val stringPrinter: (String) -> Unit = anyPrinter // ✅ 가능 (반공변성)
```

---

### enum

> 서로 관련된 상수들을 묶어서 관리하기 위한 타입
> → 값이 몇 개로 정해져 있는 경우에 사용

```kotlin
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}
```

#### when

```kotlin
fun describe(dir: Direction) = when (dir) {
    Direction.NORTH -> "위쪽"
    Direction.SOUTH -> "아래쪽"
    Direction.EAST -> "오른쪽"
    Direction.WEST -> "왼쪽"
}
```

- num 클래스는 when 과 조합으로 모든 처리를 강제할 수 있음