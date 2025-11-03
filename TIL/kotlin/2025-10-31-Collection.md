# 컬렉션(Collection)

코틀린의 컬렉션은 여러 객체를 저장하고 관리하는 컨테이너로, 자바의 컬렉션을 기반으로 만들어졌습니다.  
코틀린은 자체 컬렉션을 제공하지 않고 표준 자바 컬렉션을 활용함으로써 자바 코드와 상호작용할 때 변환 없이 같은 클래스를 사용할 수 있게 했습니다.  
다만 코틀린은 자바보다 더 많은 기능을 컬렉션에서 제공합니다.

## 핵심 특징: 불변 vs 가변

코틀린의 가장 중요한 특징은 불변(Immutable)과 가변(Mutable) 컬렉션을 구분한다는 것입니다.  
이는 코틀린이 다른 프로그래밍 언어와 구별되는 특징입니다.

## 컬렉션의 종류

### List

listOf(): 수정 불가 리스트
mutableListOf(): 수정 가능 리스트

Array 도 있으나 가급적 List 사용함.

### List의 탐색 방법

```kotlin
for (name in names) {
    println(name)
}

names.forEach {
    println(it)
}

names.forEach { name -> println(name) }

names.forEach(::println)
```

### Set

중복 값을 허용하지 않는 집합
getter는 제공하지 않기 때문에 반복이 필요하면 iterator()를 사용하거나 forEach()를 사용

List의 contains 보다 압도적으로 빠름

```kotlin
val lottoSet = setOf(1, 2, 3, 4)

println(lottoSet.contains(1)) // true
println(lottoSet.contains(5)) // false
```

### Iterator

List나 Set은 요소를 탐색할 수 있는 iterator 를 제공한다.

```kotlin
val subjects = listOf(10, 50, 100, 100, 50)
val iterator = subjects.iterator()

while (iterator.hasNext()) {
    println(iterator.next())
}
```

```kotlin
val lottoSet = setOf(1, 5, 10, 101, 50)
val iterator = lottoSet.iterator()

while (iterator.hasNext()) {
    println(iterator.next())
}
```

### Map

키(key):값(value)의 쌍으로 이루어진 요소를 담는 자료구조.
키의 중복은 허용되지 않음.

```kotlin
val gildong = mapOf(
    "name" to "길동",
    "id" to 0,
    "age" to 20,
)
```

### 컬렉션 선택

- key, value 쌍: Map
- 중복 가능: List
- 중복 불가: Set
- 순서 중요: List
- 순서 안 중요: Set
- 검색 속도 중요: Set



















