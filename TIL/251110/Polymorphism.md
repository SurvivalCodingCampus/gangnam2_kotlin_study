# 다형성

- 객체지향의 꽃, 인터페이스와 연관이 있다.
- 어떤 것을 이렇게도 부를 수 있고, 저렇게도 부를 수 있는 것

ex) 손흥민은 남자고, 축구선수이다.

소나타는 차이면서 기계이다.

## 공통 메소드를 통합

```kotlin
house.draw()
dog.draw()
car.draw()

// Interface 구현 : 무관한데 기능이 동일할 때 
interface DrawableP {
    fun draw()
}
```

- 다형성은 선언을 상위개념으로 한 다음에 실제 구체적인 것들을 따로 넣을 수 있게 해준다.
- d.draw를 콜 할 수 있지만 실제 어떤 객체인지는 알 수 없다.

```kotlin
val d: Drawable = elements[i] // 실제 타입은 런타임에 결정
d.draw() // 실제 구현체의 draw() 메서드가 호출된다.
```

ex) 볼을 찰 수 있다 라는 인터페이스 안에 손흥민, 나 , 선생님 등이 있다. 차는 건 같지만 내용은 다르다.

## when 식으로 타입체크 가능

```kotlin
val d: Drawable = elements[i]
when (d) {
    is Rectengle -> println("사각형이 선택됨")
    is House -> println("집이 선택됨")
    is Dog -> println("강아지가 선택됨")
}
d.draw()
```

## 다형성 활용법

```kotlin
val character: Character = Hero(name = "홍길동", hp = 100)
```

- 선언을 상위 개념으로 인스턴스 생성은 하위 개념으로 한다.
- 추상적인 선언 = 상세 정의로 인스턴스화

### 타입캐스팅

- 몬스터 안에 슬라임은 되지만 슬라임에 몬스터는 안된다. (상위 하위의 개념)
- as 를 붙여서 강제할 수 있지만 위험하다.

### 스마트캐스팅

- is 로 사전에 타입 체크가 가능하다.
- 자동으로 통과됐다고 본다.

### any

- 모든 타입을 담는다.

## 다형성 실패

- 예를 들어 캐릭터인데 소드를 넣는 경우
    - Sword는 Character의 하위 타입이 아니므로 컴파일 오류 발생
    - 즉, is-a 관계가 성립하지 않으면 다형성이 적용되지 않는다.

## 다형성의 메리트 (코드 중복 제거)

```kotlin
fun main() {
    val h1 = Hero("슈퍼맨, 100")
    val h2 = Wizard("해리포터, 50")
    // 모험 개시
    // 여관에 머물기
    h1.hp += 50
    h2.hp += 50

}

// -> 코드를 중복제거 (다형성의 메리트 : 동일 타입으로 취급)
fun main() {
}
val characters: List<Character> = listOf(
    Hero("슈퍼맨, 100"),
    Wizard("해리포터, 50")
)
characters.forEach { character ->
    character.hp += 50
}
```

### 다형성의 메리트 (메서드 오버로딩)

```kotlin
class Hero(name: String, hp: Int) : Character(name, hp) {
    override fun attack(slime: Slime) {
        //`~~
    }

    fun attack(goblin: Goblin) {
        // ~~~
    }
}
```

- 메서드 오버로딩 : 이름이 같고 Input 형식이 다른 메소드를 추가로 정의할 수 있다.

## 총 정리

- 타입간의 대입
    - 상속에 의한 is-a 관계가 성립한다면, 인스턴스를 부모 클래스 타입의 변수에 대입할 수 있다

- 인스턴스를 담는 상자의 타입 과 실제 내용의 타입 의 역할
    - 어떤 멤버를 이용할 수 있는가는 상자의 타입이 결정한다
      -멤버가 어떻게 움직이는지는 내용의 타입이 결정한다

- 취급 변경
    - as 키워드를 사용하여 타입 캐스팅을 수행한다
    - is 키워드를 사용하여 타입을 검사할 수 있다

- 다형성
    - 같은 부모를 가지는 다른 인스턴스를 동일시하여, 부모 클래스 타입에 담을 수 있다
    - 마찬가지로, 부모 클래스 타입의 인수나 리턴 값을 이용하여, 다른 클래스를 모아서 처리 가능
    - 동일시 취급 해도, 각각의 인스턴스는 각 클래스의 정의를 따르고 다른 동작을 한다.
