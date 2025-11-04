## 상속 (inheritance)

### 1. 상속

> 상위 클래스의 속성과 메서드를 하위 클래스가 물려받아 재사용하거나 확장하는 것

#### 복사 붙여 넣기의 문제점

- 추가, 수정에 시간이 걸림
- 소스의 파악이나 관리가 어려워 짐

#### Kotlin 은 기본적으로 상속 금지

- Kotlin에서는 클래스가 final(즉, 상속 불가)로 선언되는 것이 기본값
- 아무 표시도 안 하면 하위 클래스가 extends할 수 없음

```kotlin
class Hero {}   // ❌ 기본적으로 final — 상속 불가능
```

→ 이런 경우 SuperHero : Hero() 처럼 상속하려 하면 오류 발생

#### open 키워드를 사용해야 상속 가능

```kotlin
open class Hero(
    var name: String,
    var hp: Int,
)
```

#### 하위 클래스 정의 구조

```kotlin
class SuperHero(
    name: String,
    hp: Int,
    var sword: Sword? = null,
) : Hero(name, hp) {}
```

- `:` 뒤의 Hero(name, hp) 는 부모 클래스의 생성자 호출
- Kotlin에서는 상속할 때 반드시 부모 클래스의 생성자 명시적 호출 필요
  → Java의 super(name, hp) 와 같은 개념

> 부모 클래스(Hero)의 생성자에서 초기화가 필요한 값(name, hp)을 하위 클래스가 직접 전달해야 한다는 것

#### super 생성자 호출 필수인 이유

1️⃣ 부모 클래스의 생성자 → 2️⃣ 자식 클래스의 생성자 순으로 실행

- Hero(name, hp)를 호출해야 부모의 프로퍼티(name, hp)가 먼저 초기화
- 그 후에 SuperHero의 고유 속성(sword, isFlying)이 초기화됨

#### 다중 상속은 코틀린에서 불가능

> **여러 부모 클래스에서 같은 멤버를 상속받을 때 생기는 모호성과 충돌을 방지하기 위해**
---

### 2. 오버라이드

#### 오버라이드

> 부모 클래스의 메서드를 자식 클래스에서 재정의하는 것 → 기존 기능을 새롭게 정의하거나 확장

#### super 키워드

```kotlin
override fun attack(slime: Slime) {
    super.attack(slime)   // 부모의 attack() 먼저 실행
    if (isFlying) {
        println("$name 이 $slime 을 공격했다")
        slime.hp -= 5
        println("5포인트의 추가 피해를 입혔다")
    }
}
```

- super는 부모 클래스의 멤버(메서드, 프로퍼티) 에 접근할 때 사용하는 키워드
    - 부모 클래스의 기본 로직(Hero.attack())을 그대로 실행
    - 그 뒤에 자식 클래스의 추가 동작을 이어서 수행 가능
- “super로 부모 기능 + 자식 기능 추가”라는 구조

#### 생성자를 호출하지 않았을 때 에러가 나는 이유

```kotlin
class SuperHero : Hero {
    var isFlying: Boolean = false

    override fun attack(slime: Slime) {
        super.attack(slime)
    }
}
```

- Hero 클래스의 생성자(Hero(name: String, hp: Int))가 파라미터를 요구하기 때문
- Kotlin에서는 부모 클래스의 주 생성자를 반드시 명시적으로 호출해야 함

---

### 3. 올바른 상속

#### 올바른 상속

> “is-a 원칙” 이라고 하는 규칙에 따른 상속

- ex) SuperHero is a Hero
  (SuperHero 는 Hero의 한 종류 이다)

#### is-a 원칙

> 자식 클래스는 부모 클래스의 한 종류(is a kind of parent) 여야 한다는 규칙

#### 잘못된 상속

> 현실 세계의 등장인물 사이에 개념적으로 is-a 관계가 되지 못 함에도 불구하고 상속을 사용한 경우

- ex) 필드로 이름과 가격을 가지는 Item 클래스 (약초, 포션 를 상속 받는 House)

#### 잘못된 상속을 하면 안되는 이유

- 클래스를 확장할 때 현실세계와의 모순이 발생
    - 논리적으로 일관된 계층 구조를 유지하기 위해
- 객체 지향의 3대 특징 중 1가지 “다형성" 을 이용할 수 없게 됨
    ```kotlin
    // 잘못된 상속 예시 - 포션은 무기가 아니기 때문에 개념적으로 잘못
    class HealthPotion : Weapon("체력포션, 0")
    ```

---

### 4. 구체화와 일반화의 관계

> 자식클래스 일 수록 구체화, 부모 클래스 일 수록 추상적인 것으로 일반화

#### puml 문법

| 관계                         | UML 기호     | PlantUML 문법 | 의미         |
|----------------------------|------------|-------------|------------| 
| 상속 (Generalization)        | 실선 + 빈 삼각형 | `--         | >`         | 자식 → 부모      |
| 구현 (Interface Realization) | 점선 + 빈 삼각형 | `..         | >`         | 클래스가 인터페이스를 구현 |
| 연관 (Association)           | 실선         | `-->`       | 객체 간 참조 관계 |
| 의존 (Dependency)            | 점선 + 화살표   | `..>`       | 일시적 의존 관계  |
| 집합 (Aggregation)           | 속이 빈 마름모   | `o--`       | 부분-전체 관계   |
| 포함 (Composition)           | 속이 찬 마름모   | `*--`       | 강한 포함 관계   | 

- 표에서 마크다운 문법과 충돌해서 이상하게 보이는 것들
    - 상속 --|>
    - 구현 ..|>

#### puml 주석

| 구분      | 문법          | 설명            |
|---------|-------------|---------------|
| 한 줄 주석  | `' 주석내용`    | 일반적인 설명       |
| 여러 줄 주석 | `/' ... '/` | 긴 설명, 여러 줄 주석 |

