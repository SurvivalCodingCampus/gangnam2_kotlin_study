# Kotlin

## Class

### 레퍼런스 타입과 참조
> 인스턴스(instance) : heap 영역 안에 확보된 메모리

인스턴스를 생성하면 heap 영역 안의 메모리에 추가가 되고 그 주소의 값이 변수에 할당된다.

Java의 GC(가비지 컬렉터)가 자동으로 인스턴스 관리를 하는 것 처럼 Kotlin도 알아서 관리해준다.

클래스를 인스턴스화 하여 이용하는 코드는 다음과 같다:
```kotlin
val hero = Hero("용사", 100)
```
Kotlin에서는 모든 타입이 레퍼런스 타입이다. `Int`, `Double`형 같은 기본형(Primitive type)뿐만 아니라 `String`도 **레퍼런스 타입**이다.

#### 모든 클래스는 반드시 1개 이상의 생성자를 가진다
생성자를 1개도 작성하지 않으면 기본 생성자가 있는 것으로 본다.

```kotlin
class Person

val person = Person()
```

#### companion object
companion object를 통해 공유 자원를 제공한다. (Java의 static과 동일)  
아니면 Top level 변수(상수)를 활용하면 된다.
```kotlin
const val heroMoney = 100

class Hero
```

```kotlin
class Hero(
    var name: String,
    var hp: Int = 50,
    var money: Int = 100
) {
    companion object {
        var MONEY = 100
        
        fun setReandomMoney() {
            MONEY = Random.nextInt(1000)
        }
    }
}
```
`companion object` 본문에서 `this`는 `companion object`의 자기 자신이다. (class와는 별개이다)

`const val`은 컴파일 타임에 대입될 수 있는 값을 사용하고, 런타임에 값이 결정되면 `const val`을 사용하지 못하고, `val`을 사용해야 한다.

## 정리

### 레퍼런스 타입의 참조
- 레퍼런스 타입 변수의 안에는 "인스턴스의 정보가 담겨있는 메모리 번지"가 존재한다
- 생성한 인스턴스 변수를 다른 변수에 대입하면 주소가 복사된다

### 생성자
- 기본값 정의로 생성자는 오버로딩 효과를 가진다
- 클래스에 생성자가 없는 경우, 컴파일러가 기본 생성자가 있다고 본다

### 정적 멤버
- `companion object`는
  - 각 인스턴스 별로 필드가 존재하지 않고, 공유 자원으로 쓰인다
  - 인스턴스를 생성하지 않아도 사용할 수 있다
  - 내부에서만 서로 접근이 가능하다