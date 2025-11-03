# Kotlin

## 상속 inheritance

상속은 개념 자체는 같다. 다만 Kotlin에서 사용 방법은 다르다.
Kotlin은 모든게 닫혀있다. 즉, 기본적으로 상속이 금지되어 있어서 `open` 키워드로 상속을 가능하게 해야 한다.
Java와 마찬가지로 상속받은 자식 클래스는 생성자에서 가장 처음 부모 클래스 생성자를 호출해야 한다. 

상속은 다음과 같이 할 수 있다:
```kotlin
open class Hero(var name: String, var hp: Int)

class SuperHero(
    name: String,
    hp: Int,
    var sword: Sword? = null,
) : Hero(name, hp) {
    // ...
}
```

### 다중상속
Java와 마찬가지로 다중상속이 불가능하다. 다만, 인터페이스 구현은 다중으로 할 수 있다.

### 오버라이드(override)
기본적인 내용은 Java의 오버라이드와 같고, 오버라이드는 상속과 마찬가지로 `open` 키워드를 사용해야만 가능하다.

```kotlin
open class Hero(var name: String, var hp: Int) {
    open fun run() {
        println("${name}이 도망쳤다")
    }
}

class SuperHero(
    name: String,
    hp: Int,
    var sword: Sword? = null,
) : Hero(name, hp) {
    override fun run() {
        println("${name}이 퇴각했다.")
    }
}
```

올바른 상속은 **"is-a 원칙"** 이라고 하는 규칙에 따른 상속을 말한다.  
"SuperHero is a Hero"  
(SuperHero는 Hero의 한 종류이다)
