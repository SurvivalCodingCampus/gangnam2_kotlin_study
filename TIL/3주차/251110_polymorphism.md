## 다형성 (Polymorphism)

### 다형성

> 하나의 타입(상위 클래스나 인터페이스)으로 여러 객체(하위 클래스)를 동일하게 다루는 것
> 같은 메서드를 호출해도 객체의 실제 타입에 따라 다르게 동작하게 됨

#### 예시코드

```kotlin
abstract class Monster {
    open fun run() = println("뚜벅뚜벅")
}

class Slime(val suffix: String) : Monster() {
    override fun run() = println("슬라임 $suffix 가 도망쳤다")
}

fun main() {
    val slime = Slime("A")                // (1) Slime 타입
    val monster: Monster = Slime("B")     // (2) Monster 타입(상위), 실제 객체는 Slime

    slime.run()
    monster.run()
}
```

- 상위 타입(Monster) 변수에 하위 타입(Slime) 객체를 대입 가능
- 변수의 선언 타입(Monster)이 아니라 실제 객체 타입(Slime)에 따라 메서드가 호출됨

#### 타입 캐스팅

> 객체의 실제 타입을 기준으로, 변수의 선언 타입을 다른 타입으로 변환하여 사용하는 것

```kotlin
fun main() {
    val monster: Monster = Slime("B")  // (1) 상위 타입 변수로 하위 클래스 객체 저장
    val slime: Slime = monster as Slime // (2) 다시 Slime 타입으로 캐스팅
}
```

- `val monster: Monster = Slime("B")`
    - Monster 타입으로 선언했지만, 실제 생성된 객체는 Slime 인스턴스
    - 참조 변수는 Monster, 실체는 Slime인 상태

- `val slime: Slime = monster as Slime`
- 여기서 monster는 실제로 Slime
- as 키워드를 이용해 Slime 타입으로 안전하게 변환 가능

#### 잘못된 타입 캐스팅

> 실제 객체의 타입과 일치하지 않는 하위 클래스로 강제 변환하려 할 때 발생하는 오류 <br/>
> 형제 클래스 간에는 상속 관계가 없기 때문에 캐스팅이 불가능

```kotlin
fun main() {
    val character: Character = Wizard(name = "해리포터", hp = 10)
    val hero: Hero = character as Hero  // ❌ 잘못된 캐스팅
}
```

- Character는 상위 클래스 (부모 클래스)
- Wizard와 Hero는 Character의 하위 클래스
- character 변수는 실제로 Wizard 객체를 가리키고 있지만 as Hero로 다른 하위 클래스 타입(Hero) 으로 강제 변환중
    - `ClassCastException: ...` 발생

#### 안전한 캐스팅

```kotlin
// if문으로 한번 확인
if (character is Hero) {
    val hero = character as Hero
} 
```

#### 스마트 캐스팅

> 코틀린이 컴파일러 수준에서 타입 검사를 자동으로 수행한 뒤,
> 그 이후 코드에서는 개발자가 명시적으로 캐스팅(as)을 하지 않아도 안전하게 하위 타입으로 인식하는 기능

```kotlin
// 가능한 경우
val character: Character = Wizard("해리포터", 10)

if (character is Wizard) {
    // 여기서 이미 character가 Wizard 타입으로 자동 변환됨!
    character.castSpell()   // ✅ Wizard 고유 메서드 사용 가능
}

// 불가능한 경우
var character: Character = Wizard("해리포터", 10)

if (character is Wizard) {
    character = Hero("슈퍼맨", 100)
    character.castSpell()   // ❌ 불가능 — 이미 다른 타입으로 변경됨
}
```

- var로 선언되어 있으면 중간에 다른 타입으로 바뀔 가능성이 있기 때문에 스마트 캐스팅이 적용되지 않음
- 스마트 캐스팅은 val(불변 변수) 에만 완전하게 적용

#### 강제 타입 캐스팅의 위험성

```kotlin
val thing1: Thing = Book()
val thing2: Thing = Computer()

val book3: Book = thing1 as Book   // ✅ 실제로 Book → 성공
val book4: Book = thing2 as Book   // ❌ 실제로 Computer → 런타임 오류 (ClassCastException)
```

- thing1, thing2의 선언 타입은 모두 Thing (상위 인터페이스)이지만 실제로 들어 있는 객체의 타입이 다름
    - thing1 → 실제 객체는 Book
    - thing2 → 실제 객체는 Computer, Book과 아무 상속 관계 없
- 단순히 `as Book` 으로 강제 변환하면 실제로 Book이 아닌 경우 런타임 오류 발생
    - is 로 안전한 캐스팅으로 해결 가능