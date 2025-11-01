# 캡슐화

## 전 날 리뷰

- 방어적인 코드에 대해 많이 생각해보자.
- 상수를 활용해서 매직넘버를 없앨 수 있으면 없애자.
- Exeption 처리를 할 때는 비지니스 로직은 넣지 않는다.

## 1. 캡슐화

- 휴먼 에러를 막기위한 것 중 하나이다.

### 1-1) private 키워드 붙이기

- 클래스/ 생성자 / 메서드
    - 가져올 때는 getter/setter를 활용해서 private 에서 가져오기
    - getter: 읽기 전용 프로퍼티를 구현할 때 사용
    - setter: 쓰기 전용 프로퍼티를 구현할 때 사용

```
프로퍼티란 ?!
  - 객체의 속성 값 
  - 직접 변수에 접근하지 않고 게터와 세터를 통해 접근
  - 코틀린은 게터/세터를 내장하고 있다. (var:get/set 가능, val:get 가능)
```

### 1-2) getter 재정의

```kotlin
class Student(
    var id: Int,
    val name: String,
    age: Int = 0,
) {
    // 읽기전용 만드는 방법 1
    private var _age = age
    val age: Int
        get() = _age

    // 읽기전용 만드는 방법 2
    var age2: Int = age
      private set // 세터를 막는다.
}


fun main() {
    val student = Student(0, "홍길동")
    student.id = 100; // 게터가 있다
}

```

### 1-3) setter 재정의

```kotlin
class Student(
  var id: Int,
  val name: String,
  age: Int = 0,
) { // get + set 만드는 방법 1
  private var _age = age
  var age: Int
    get() = _age
    set(value) {
      _age = value
    }

  fun study() {
    age = 10
  }
}

fun main() {
    val student = Student(0, "홍길동")
    student.id = 100; // 게터가 있다
}

```

### 1-4) getter / setter 의 메리트

- Read Only, Write Only 필드의 실현
- 필드의 이름 등, 클래스의 내부 설계를 자유롭게 변경 가능
- 필드로의 액세스를 검사 가능
- val 은 getter 를 기본적으로 내장, var 는 getter와 setter를 내장

### 2-1) require() 전제 조건

setter에서 값의 타당성을 검사한다.

```kotlin
require(조건식) { "조건을 만족하지 않을 때 보여줄 에러 메시지" }
```

- 조건이 false면 IllegalArgumentException 예외를 던진다.
  혹은

```kotlin
var score: Int = 0
    set(value) {
        if (value < 0) {
            throw IllegalArgumentException("점수는 음수일 수 없습니다.")
        }
        field = value
    }

```

### 왜 캡슐화를 해야하는가?

- 현실세계랑 맞추기 위해 (나는 공개를 원치않는데 공개가 될 수도 있음 그런 것들을 적용하기 위해)
- 외부개발자가 코드를 사용할 때 잘 사용할 수 있게

## 총 정리
### 1. 캡슐화의 개요
- 캡슐화를 하여 멤버나 클래스로의 접근을 제어할 수 있음

특히, 필드에 “현실세계에서 불가능한 값"이 들어가지 않도록 제어

### 2. 멤버에 대한 접근 지정
- private 멤버는, 동일 파일내에서만 접근 가능
- public 멤버는, 모든 클래스에서 접근 가능

### 3. 클래스에 대한 접근 지정
- 함수, 변수와 동일한 규칙

### 4. 프로퍼티 (property)
- getter/setter 를 캡슐화하여 필드처럼 직접 접근할 수 있도록 하는 문법적 요소
