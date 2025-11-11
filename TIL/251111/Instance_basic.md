# 전 날 리뷰

- 인터페이스 많을 수록 좋다. 로직으로 푸는 형식은 좋지 않다.
- 모든 영웅이 공격을 가지고 있는데 그걸 빼는 것은 힘들다. 예외가 있으면 인터페이스
- 바텀업이 개발하기 훨씬 쉽다.
- 등장인물 + 속성 다 적기 = 공통 뽑기 ⇒ 속성 명확하면 상속 아니면 인터페이스 ⇒ 종족은 크게 필요없다. 기능에 집중하면서 뺄 거 빼기 ⇒ 마커 인터페이스(빈 속성 붙이기)

추상화 클래스 < 인터페이스.
상속은 단 한 번만 가능하다.

# Object 클래스의 기본 기능

1. Java에서 모든 클래스는 Object 클래스의 메서드와 프로퍼티를 가지고 있다
   오브젝트는 상속하지 않아도 알어서 상속 받는다.

2. Java에서 Object 타입 변수에는 모든 인스턴스를 대입할 수 있다
3. Kotlin 에서는 Any, 하지만 근본은 Object를 따름

## <Object 클래스의 대표 메서드>

- toString() : 문자열 표현을 얻음. 디버깅 등 원하는 곳에 사용하면 된다.
- equals() : 비교 (Kotlin 에서는 == 과 동일함)
- hashCode() : 해시값을 얻음

toString : 디버깅 등 원하는대로

```kotlin

fun main() {
    val hereos = mutableListOf<Hero>() // <Int> <String> <Set>들어가는 거에 따라 값이 다르다.

    val h1 = Hero(name = "슈퍼맨", hp = 100)
    val h2 = Hero(name = "슈퍼맨", hp = 100)

    hereos.add(h1)
    println(hereos.size)

    hereos.add(h2)
    println(hereos.size)
}
```

- 값은 빠지는데 내가 만든 객체는 빠지지 않는다.

## equals() 재정의

- 룰 재정의를 위해 필요하다. ( 논리적으로 같은 객체 )

```kotlin
 override fun equals(other: Any?): Boolean {
    if (this === other) return true // 같은 객체면 true
    if (other !is Hero) return false// 타입 다르면 false

    if (hp != other.hp) return false// 각 필드 비교
    if (name != other.name) return false

    return true
}

println(h1 == h2) // 해쉬코드가 다르기 때문에 다른 값이 맞다.

// 자바에서 == 은 실제 주소비교
// 코틀린에는 == equals() === 실제 주소 비교가 있다.
```

- 내가 안쓴다고 해도 다른 사람들을 위해 서비스 차원으로 해주는 게 좋다.

list에서는 리무브를 해주면 값은 0이 나오지만 set에서는 1이 나온다.
set은 해쉬코드를 가지고 객체를 판단한다. 그래서 다르다.
list 에서는 동일성 판단을 equals 로 한다. equals()를 재정의 했으면 hashCode()에서도 수정을 해줘야 한다.

## hashCode() 재정의

```kotlin
override fun hashCode(): Int {
    var result = name.hashCode()
    result = 31 * result + hp
    return result
}

```

- 31은 소수라서 해시값이 고르게 퍼진다 -> 충돌이 줄어든다.
- equals 는 100개를 찾기 때문에 느리다(논리적 비교에 좋음). 해쉬코드(set,map)는 빠르다.
- 클래스내부에 또 다른 객체 타입의 프로퍼티가 있으면, equals(),hashcode()를 다 재정의 해줘야 한다.


- hashCode 값으로 1차 비교를 하고 equals()로 최종비교를 한다.
- hashCode가 다르면 equals를 안본다.

- 프리미티브타입은되는데 객체는 안된다. 그래서 equals()와 hashCode()의 결과가 항상 일관되게 나오도록 직접 맞춰주는 게 좋다 (= 버그 방지)

## 리스트에서 요소 정렬

- 원본은 그대로 유지하고, 정렬된 새 리스트를 반환한다.
- 코틀린은 sorted() 확장 함수로 새 리스르트를 만들어 리턴한다.

### 객체는 안된다.

- 사용자가 정의한 클래스는 어떤 기준으로 비교해야하는지를 컴파일러가 모른다.

1. Comparable 인터페이스 구현

```kotlin
class Slime(val name: String, val hp: Int) : Comparable<Slime> {
    override fun compareTo(other: Slime): Int {
        return this.hp.compareTo(other.hp) // HP 기준 오름차순
    }

    override fun toString() = "Slime(name=$name, hp=$hp)"
}

fun main() {
    val list = listOf(Slime("A", 10), Slime("B", 5), Slime("C", 20))
    val sorted = list.sorted()
    println(sorted)
}

```

2. sortedWith (직접 정의)

```kotlin
val sorted = list.sortedWith(compareBy({ it.name }, { it.hp }))

```

- 즉석에서 쓰는 게 자주 사용된다.

# 인스턴스 복사

1. 얕은 복사
```kotlin
class Address(
    var street: String
)

class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    fun shallowCopy() = Person(name, age, address) // address 그대로 참조
}

```
- 주소 객체는 같은 참조
- 내부 객체 또한 공유 된다. 복사본 수정시 원본도 영향을 받는다.

2. 깊은 복사
```kotlin
class Address(
    var street: String
) {
    fun deepCopy() = Address(street)
}

class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    fun deepCopy() = Person(name, age, address.deepCopy()) // address도 새로 생성
}

```
- 주소 객체도 새로 생성
- 복사 후 수정시 영향 X

## Data class
- 카피 기능을 제공하나 얕은 복사를 한다.
- 얕은 복사지만 인스턴스는 새로 만든다. 안에 있는 것들은 같이 쓴다.
- equals(),hashcode(),toString() 을 재정의 해준다. (자바에서는 롬복이 다 해준다.@data 같은 개념)
- 왜 얕은 복사? 비용적인 문제
- 요즘 트렌드 = 있는 데이터 수정X 복사를 하면 해결할 수 있게 된다. (코드 안정성 증가)
- 수정해서 쓰는 게 아니라 복사를 해서 쓰는 방식으로 간다.
