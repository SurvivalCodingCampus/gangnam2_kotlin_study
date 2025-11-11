## Instance 기본 조작

### Object 클래스의 기본 기능

1. Java에서 모든 클래스는 Object 클래스의 메서드와 프로퍼티를 가지고 있음
2. Java에서 Object 타입 변수에는 모든 인스턴스를 대입할 수 있음
3. Kotlin 에서는 Any, 하지만 근본은 Object를 따름

#### Object 클래스의 대표 메서드

- toString() : 문자열 표현을 얻음
- equals() : 비교 (Kotlin 에서는 == 과 동일함)
- hashCode() : 해시값을 얻음

#### 단축키

| 기능                 | 설명                      | 단축키 (macOS) | 
|--------------------|-------------------------|-------------| 
| **File Structure** | 현재 파일의 클래스·메서드·필드 구조 보기 | ⌘ F12       | 
| **Type Hierarchy** | 클래스 상속 및 구현 계층 구조 보기    | Control + H | 

---

### ToString()

> 객체를 문자열로 표현하는 메서드
> → 오버라이드 하여 원하는 결과를 얻도록 수정 가능

#### 기본 예시

```kotlin
class Hero(val name: String, val hp: Int)

fun main() {
    val hero = Hero("영웅", 100)
    println(hero.toString())
    // Hero@3f0ee7cb  ← 패키지 경로 + 클래스명 + 해시코드
}
```

- JVM이 내부적으로 만든 "임시 주소"처럼 보이는 식별자예요.
- 눈으로 본 적은 없지만, 객체가 메모리 어딘가에 존재한다는 느낌으로 봐도 무방

#### override 예시

```kotlin
class Hero(val name: String, val hp: Int) {
    override fun toString(): String {
        return "Hero(name='$name', hp=$hp)"
    }
}

fun main() {
    val hero1 = Hero("영웅", 100)
    val hero2 = Hero("영웅", 100)

    println(hero1.toString())  // Hero(name='영웅', hp=100)
    println(hero2.toString())  // Hero(name='영웅', hp=100)
}
```

- 재정의 하면 사람이 이해 가능한 형태로 출력 가능

---

### equals()

| 구분    | 의미            | 비교 기준           | 재정의 가능 여부                      |
|-------|---------------|-----------------|--------------------------------|
| `==`  | **값(내용) 비교**  | `equals()` 호출   | ✅ 가능 (`equals()` 오버라이드로 변경 가능) |
| `===` | **참조(주소) 비교** | 메모리 상의 동일 객체 여부 | ❌ 변경 불가 (JVM 레벨 비교)            |

#### Java와 Kotlin 비교

| 언어         | `==`의 의미           | `equals()` 역할      |
|------------|--------------------|--------------------|
| **Java**   | 주소(참조) 비교          | 내용 비교 (재정의 가능)     |
| **Kotlin** | 내용 비교 (`equals()`) | 내부적으로 `==`에 의해 호출됨 |

#### equals() 재정의

- equals()는 기본적으로 Object 클래스에 정의
- List, Set 등에서 같은 객체로 인식되게 하려면 반드시 equals()와 hashCode()를 재정의해야 함

1. 참조 동일성 검사

```kotlin
if (this === other) return true
```

2. 타입 검사

```kotlin
if (other !is Hero) return false
```

3. 속성 비교

```kotlin
if (hp != other.hp) return false
if (name != other.name) return false
```

4. 모두 같으면 true

```kotlin
return true
```

---

### hashcode()

> 객체를 식별하기 위한 정수값(Integer)으로
> JVM이 내부적으로 객체 주소 기반으로 생성

- Set, Map 등의 해시 기반 컬렉션에서 빠르게 객체를 찾기 위해 사용됨
- 먼저 hashCode()로 같은 버킷(그룹)에 속한 객체 후보를 찾은 뒤 equals()로 실제 동일한지 검사

#### hashcode() 재정의

```kotlin
class Hero(val name: String, val hp: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hero) return false
        return name == other.name && hp == other.hp
    }

    override fun hashCode(): Int {
        // 이름의 길이로 hashCode를 정의한 예 (비추천)
        return name.length
    }

    override fun toString(): String {
        return "Hero(name='$name', hp=$hp)"
    }
}
```

- equals()가 true면 hashCode도 같아야 함
    - 동등한 객체는 반드시 같은 해시값을 가져야 함
- hashCode가 같다고 equals()가 true일 필요는 없음
    - 해시 충돌 가능 (서로 다른 객체가 같은 해시값을 가질 수 있음)
- 같은 객체의 hashCode는 항상 동일해야 함
    - 실행 중에는 값이 바뀌면 안 됨 (mutable 값 기준 금지)

#### 정리

> List는 equals() 로만 비교하지만 <br/>
> Set과 Map은 hashCode() → equals() 순으로 비교

- equals()를 재정의하면 값 비교 규칙이 바뀜
- hashCode()를 재정의하면 Set/Map 내부의 동등성 판단 규칙이 바뀜
- 두 메서드를 항상 함께 일관성 있게 재정의해야 컬렉션에서 올바르게 동작
- hashCode 재정의 시 충돌과 성능 저하 주의

---

### sorted()

> 정렬하는 메서드 <br/>
> List< T >.sorted() 는 T가 비교 가능한 타입일 때만 사용 가능함 <br/>
> (String, Int, Double 등은 이미 Comparable 구현 완료) <br/>

#### 확장 함수 관계

```mathematica
Iterable
  ↑
Collection
  ↑
List
  ↑
MutableList
```

- sorted() 는 Iterable<T>의 확장 함수
    - 그래서 List, Set, MutableList 모두 사용 가능

#### comparable

| 항목        | 설명                                                 |
|-----------|----------------------------------------------------|
| **인터페이스** | `Comparable<T>`                                    |
| **메서드**   | `compareTo(other: T): Int`                         |
| **반환 규칙** | `음수 → this < other`, `0 → 같다`, `양수 → this > other` |

- 내가 만든 클래스를 정렬하기 위해서 재정의 필요
    ```kotlin
    class Hero(
        val name: String,
        val hp: Int
    ) : Comparable<Hero> {
        // 이름 기준 내림차순 정렬 (-1 붙이기)
        override fun compareTo(other: Hero): Int {
            return -this.name.compareTo(other.name)
        }
    
        override fun toString(): String = "Hero(name='$name', hp=$hp)"
    }
    
    fun main() {
        val heroes = listOf(
            Hero("홍길동", 100),
            Hero("이순신", 200),
            Hero("한석봉", 150)
        )
    
        val sortedHeroes = heroes.sorted()
        println(sortedHeroes)
    }

#### Comparator

> 기존 클래스 수정 없이 외부에서 정렬 기준 지정 가능

```kotlin
fun main() {
    val heroes = listOf(
        Hero("홍길동", 100),
        Hero("이순신", 200),
        Hero("한석봉", 150)
    )

    // 이름 기준 오름차순
    val sortedByName = heroes.sortedWith { a, b ->
        a.name.compareTo(b.name)
    }

    // 체력 기준 내림차순
    val sortedByHp = heroes.sortedWith { a, b ->
        b.hp.compareTo(a.hp)
    }

    println(sortedByName)
    println(sortedByHp)
}
```

- sortedWith { a, b -> ... } 내부의 람다식이 곧 Comparator 구현체

---

### copy()

#### 복사 의미

| 개념                       | 뜻                     | 설명                        |
|--------------------------|-----------------------|---------------------------|
| **레퍼런스 연결**              | 같은 객체를 **참조만 복사**     | 복사된 종이에 같은 주소를 써둔 느낌      |
| **얕은 복사 (shallow copy)** | 내부 필드 값만 그대로 새 객체에 복사 | 사진 찍은 사본, 겉보기엔 같지만 독립된 종이 |
| **깊은 복사 (deep copy)**    | 내부의 **참조 객체까지 새로 생성** | 전체 구조를 완전히 복제             |

#### 레퍼런스 연결

```kotlin
val h1 = Hero("홍길동", 100)
val h2 = h1  // 단순 레퍼런스 복사

println(h1 === h2) // true → 같은 객체 (주소 공유)
```

- h2는 h1과 같은 객체를 가리킴
    - 하나의 인스턴스에 두 개의 이름표만 붙인 상태

#### 얕은복사

```kotlin
data class Hero(val name: String, val hp: Int)

fun main() {
    val h1 = Hero("홍길동", 100)
    val h2 = h1.copy()        // 내용만 같은 새 객체 생성
    val h3 = h1.copy(name = "이순신") // 일부 수정도 가능

    println(h1 === h2) // false → 다른 객체 (주소 다름)
    println(h1 == h2)  // true  → 내용 같음 (equals true)
    println(h3)        // Hero(name=이순신, hp=100)
}
```

- copy()가 얕은 복사를 지원하는 이유
    - 필드 값만 그대로 복사하므로 연산이 간단
    - 복사 후 원본을 수정하지 않고 새 객체로 다룸
    - 기존 데이터를 바꾸지 않고 “새 버전”을 만들어 사용하는 방식
    - String, Int, LocalDate 등은 내부 상태가 변하지 않기 때문에 얕은 복사로 충분

#### 깊은 복사가 필요한 경우

```kotlin
class Address(
    var street: String
) {
    // Address의 deepCopy: 내부 값(street)만 새 Address로 복사
    fun deepCopy() = Address(street)
}

class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    // Person의 deepCopy: Address까지 복사된 새로운 객체 생성
    fun deepCopy() = Person(name, age, address.deepCopy())
}
```

- 내부 객체까지 완전히 독립된 새 인스턴스 생성
    - 클래스마다 deepCopy() 메서드를 직접 재정의해야 함
    - 내부에 또 다른 참조 객체가 있다면 그 객체의 deepCopy()도 호출해야 함

#### data class 자동 생성된 메서드

| 메서드            | 역할                                           |
|----------------|----------------------------------------------|
| **equals()**   | 두 객체의 **내용(프로퍼티 값)** 이 같으면 같다고 판단            |
| **hashCode()** | `Set`, `Map` 등에서 **동등성 판단용 해시값** 제공          |
| **toString()** | 객체의 내용을 사람이 읽기 좋은 문자열로 표현                    |
| **copy()**     | **얕은 복사(shallow copy)** 기능 제공 (필드 값만 그대로 복사) |


