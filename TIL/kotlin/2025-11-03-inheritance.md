# 상속(inheritance)

기존 클래스의 재사용과 확장

```kotlin
open class Hero(
    // 상속 허용은 open 키워드 사용.
    var name: String,
    var hp: Int,
) {
    open fun run() {
        println("hero run")
    }

    open fun attack(slime: Slime) {
        println("slime attack")
    }
}

class SuperHero(
    name: String,
    hp: Int,
) : Hero(name, hp) { // 상속 받을 때는 ':' 사용.
    override fun run() { // 기존 기능을 재정의(override)
        println("superhero run")
    }

    override fun attack(slime: Slime) {
        super.attack(slime)

        if (isFlying) {
            println("superhero 추가 공격")
        }
    }
}
```

1. 코틀린 클래스의 상속 기본

- 코틀린에서 클래스는 기본적으로 final로 선언되며, 상속이 불가능합니다.
- 부모 클래스에 있는 메소드를, 자식 클래스에서 재작성 할 경우 이것을 오버라이드 한다고 한다.
- 클래스나 메서드, 프로퍼티를 상속하거나 오버라이드(재정의)하려면 반드시 open 키워드를 적어 주어야 됩니다.

2. 생성자와 상속

- 상속받는 클래스는 부모 클래스의 생성자를 반드시 호출해야 합니다.
- 생성자에서 부모 생성자를 호출하려면 ':' 뒤에 생성자 인자를 넘깁니다.
- 객체 생성 시 부모 -> 자식 순서로 초기화가 진행됩니다.

3. 기타 특징

- 다중 상속은 지원하지 않습니다.
- 올바른 상속은 "is-a 원칙" 이라고 하는 규칙에 따른 상속을 말한다
  SuperHero is a Hero
  (SuperHero 는 Hero의 한 종류 이다)
