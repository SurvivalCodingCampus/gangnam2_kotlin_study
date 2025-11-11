# 다형성(Polymorphism 多形性)

여러 가지 형태를 가질 수 있는 능력

예:  
손흥민은 남자고, 축구선수이다.  
소나타는 차이면서, 기계이다.

- 공통 메소드를 통합
- Interface 정의
- Interface 구현

### when 식으로 타입 체크 가능

```kotlin
val d: Drawable = elements[i]
when (d) {
    is Rectangle -> println("사각형이 선택됨")
    is House -> println("집이 선택됨")
    is Dog -> println("강아지가 선택됨")
}
```

```kotlin

class Character(
    var name: String,
    var hp: Int,
) {
    fun attack(slime: Slime) {

    }
}

class Wizard(
    name: String,
    hp: Int,
    var wand: Wand? = null,
    var mp: Int = 100,
) : Character(name, hp) {
    override fun attack(slime: Slime) {

    }

    fun fireball(slime: Slime) {

    }
}

// 에러 없는 구문
fun main() {
    val wizard = Wizard(name = "해리포터", hp = 50)
    val slime = Slime("A")

    wizard.attack(slime)
    wizard.fireball(slime)
}

// 에러 발생
fun main() {
    val wizard = Wizard(name = "해리포터", hp = 50)
    val character: Character = wizard
    val slime = Slime("A")

    character.attack(slime)
    character.fireball(slime) // 에러 발생
}
```

컴파일러는 **선언된 타입(Character)** 만을 기준으로 코드의 안전성을 검증합니다. 컴파일러는 다음과 같이 판단합니다:​

- "character는 Character 타입이다"
- "Character 클래스를 열어보니 attack() 메서드만 있고 fireball()은 없다"
- "따라서 character.fireball()은 타입 안전성 위반이다" → 컴파일 에러 발생

### 다운캐스팅

자식 클래스의 고유 메서드를 사용하려면 **다운캐스팅(down-casting)** 이 필요합니다.

방법 1: as 연산자 (명시적 캐스팅)

```kotlin
(character as Wizard).fireball(slime)
```

- 영구적으로 타입을 변환
- 잘못된 타입이면 ClassCastException 발생

방법 2: is 연산자 (스마트 캐스팅)

```kotlin
if (character is Wizard) {
    character.fireball(slime) // if 블록 안에서 자동으로 Wizard로 캐스팅됨
}
```

- 안전하게 타입 체크 후 자동 캐스팅
- if 블록 내에서만 일시적으로 캐스팅됨

방법 3: as? 연산자 (안전한 캐스팅)

```kotlin
(character as? Wizard)?.fireball(slime)
```

캐스팅 실패 시 null 반환 (예외 발생 안 함)

### 정리

타입간의 대입

- 상속에 의한 is-a 관계가 성립한다면, 인스턴스를 부모 클래스 타입의 변수에 대입할 수 있다.

인스턴스를 담는 상자의 타입과 실제 내용의 타입의 역할

- 어떤 멤버를 이용할 수 있는가는 상자의 타입이 결정한다.
- 멤버가 어떻게 움직이는지는 내용의 타입이 결정한다.

취급 변경

- as 키워드를 사용하여 타입 캐스팅을 수행한다.
- is 키워드를 사용아여 타입 검사할 수 있다.

다형성

- 같은 부모를 가지는 다른 인스턴스를 동일시하여, 부모 클래스 타입에 담을 수 있다.
- 마찬가지로, 부모 클래스 타입의 인수나 리턴 값을 이용하여, 다른 클래스를 모아서 처리 가능.
- 동일시 취급 해도, 각각의 인스턴스는 각 클래스의 정의를 따르고 다른 동작을 한다.

### 연습문제 1

- (1)

```kotlin
val item: Item = Sword()
```

Sword 인스턴스

Sword 를 생성했지만 컴파일러에게는 Item 로 보임.

- (2)

```kotlin
val a: Monster = Slime
```

Slime 인스턴스

Slime 을 생성했지만 컴파일러에게는 Monster 로 보임.

### 연습문제 2

1. a()
2. y1.a() // "Aa"
   y2.a() // "Ba"

### 연습문제 3

1. List<Y>

```kotlin
fun main() {
    val obj: X = A()
    // obj.a() // ok

    val y1: Y = A()
    val y2: Y = B()
    // y1.a()
    // y2.a()

    val list: List<Y> = listOf(y1, y2)

    for (i: Y in list) {
        println(i.a())
    }
}
```





