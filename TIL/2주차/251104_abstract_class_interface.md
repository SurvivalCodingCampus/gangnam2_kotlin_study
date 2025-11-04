## 추상 클래스와 인터페이스

### 1. 추상 클래스(Abstract Class)

> 공통된 속성과 기능을 정의하되, 직접 인스턴스화할 수 없고 하위 클래스에서 구체화해야 하는 클래스

#### 인스턴스화

- 클래스로 부터 실제 동작가능한 객체(인스턴스)를 만드는 것

#### 추상 클래스

- 상속의 재료로 사용되는 클래스
- 상세 부분이 일부 미정인 클래스

#### 추상 클래스, 추상 메소드 코드 예시

```kotlin
// 추상 클래스
abstract class Character(
    var name: String,
    var hp: Int,
) {
    fun run() = println("$name 이 도망갔다")

    // 추상 메소드
    abstract fun attack(slime: Slime)
}
```

- 추상 클래스르 사용하면 오버라이드가 강제
    - 추상 클래스 안의 추상 메소드는 반드시 하위 클래스에서 override 해야 함
    ```kotlin
    // 추상 클래스
    abstract class Character {
        abstract fun attack()
        fun run() = println("도망갔다!")
    }
    
    // 하위 클래스에서 반드시 오버라이드해야 함
    class Hero : Character() {
        override fun attack() = println("검으로 공격!")
    }
    ```

- 추상 클래스는 인스턴스화가 금지
    - 추상 클래스는 설계도 역할만 하므로, Character()처럼 직접 객체를 만들 수 없음
    ```kotlin
    fun main() {
        // val c = Character() ❌ → 오류! 인스턴스화 불가
        val hero = Hero()      // ✅ 가능
        hero.attack()          // 출력: 검으로 공격!
        hero.run()             // 출력: 도망갔다!
    }
    ```

---

### 2. 인터페이스(Interface)

> 여러 클래스가 공통으로 가져야 할 동작의 약속을 정의한 틀

#### 추상 메소드만 가지는 추상 클래스 == 인터페이스

```kotlin
interface Human {
    fun speak()
}

// 자동으로 abstract 내장
interface Human {
    abstract fun speak()
}
```

- 인터페이스 안의 함수는 자동으로 추상 메서드(abstract) 로 간주
- 구현부 `{}`가 없음
- 인터페이스를 구현(implements) 하는 클래스는 반드시 override 필요
    ```kotlin
    class Person : Human {
        override fun speak() {
            println("안녕하세요!")
        }
    }
    ```

#### 인터페이스 효과

- 같은 인터페이스를 구현한 클래스들은 공통 메소드를 구현하도록 강제

```kotlin
interface Flyable {
    fun fly()  // 반드시 구현
}

class Bird : Flyable {
    override fun fly() = println("새가 날아간다 🕊️")
}

class Airplane : Flyable {
    override fun fly() = println("비행기가 이륙한다 ✈️")
}
```

- 어떤 클래스가 인터페이스를 구현하고 있다면, 적어도 그 인터페이스에 정의된 메소드를 가지고 있다는 것이 보장

```kotlin
fun startFlying(flyer: Flyable) {
    flyer.fly()  // Flyable을 구현했다면 무조건 fly() 존재
}

val bird = Bird()
startFlying(bird)   // 안전하게 호출 가능
```

- 상속은 단일 상속이지만 인터페이스는 여러개 구현 가능

```kotlin
interface Swimable {
    fun swim()
}
interface Flyable {
    fun fly()
}

class Duck : Swimable, Flyable {
    override fun swim() = println("오리가 헤엄친다 🦆")
    override fun fly() = println("오리가 날기도 한다 🕊️")
}
```

- 상속과 인터페이스 동시에 사용 가능

```kotlin
open class Animal {
    fun eat() = println("먹는다 🍽️")
}

interface Walkable {
    fun walk()
}

class Dog : Animal(), Walkable {
    override fun walk() = println("개가 걷는다 🐕")
}
```