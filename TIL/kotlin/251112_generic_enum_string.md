# 제네릭 Generic
## `out` keyword
**읽기 전용(Covariance (공변성))**
```kotlin
class Pocket<out T>
```

```java
List<? extends T>
```

**쓰기 전용(Contravariance (반공변성))**
```kotlin
class Pocket<in T>
```

```java
List<? super T>
```

**둘 다 가능(Invariance (무변성))**
```kotlin
class Pocket<T>
```

# 문자열 String
## StringBuilder
- 쓰레드에 안전하지 않음

## StringBuffer
- 쓰레드에 안전함

**컴파일타임일 때는 스트링 풀에 들어가지만, 런타임일 땐 힙에 생성이 된다.** 