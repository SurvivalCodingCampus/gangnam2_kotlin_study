## 캡슐화

### 1. 캡슐화(encapsulation)

> 객체 내부의 로직을 외부에서 직접 접근하지 못하게 하는 것

- 실수로 속성을 덮어쓰거나 잘못조작하는 휴먼에러 방지
- getter, setter 등을 통해서만 접근

---

### 2. 엑세스 제어

#### 접근 지정자

| 제한 범위  | 명칭        | 설정 방법         | 접근 가능한 범위  |
|--------|-----------|---------------|------------|
| 제한이 엄격 | `private` | `private` 키워드 | 자기 자신의 클래스 |
| 제한이 느슨 | `public`  | 기본 값          | 모든 클래스     |

#### Private

> 필드의 접근을 막으려면 private 키워드를 붙이면 외부에서, 다른 클래스에서 사용할 수 없다

| 기호  | 접근 제한자            | 설명                     | Kotlin 대응 키워드               | 접근 가능 범위         |
|-----|-------------------|------------------------|-----------------------------|------------------|
| `+` | public            | 어디서나 접근 가능             | `public` (기본값)              | 모든 클래스           |
| `-` | private           | 자기 자신의 클래스 내부에서만 접근 가능 | `private`                   | 해당 클래스 내부        |
| `~` | package (default) | **같은 패키지 내**에서만 접근 가능  | Kotlin에서는 `internal`이 가장 유사 | 같은 패키지(모듈) 내 클래스 |

---

### 3. getter, setter

#### 메서드를 경유한 필드 조작

| 구분         | 역할       | 사용 목적                    | 비고                                    |
|------------|----------|--------------------------|---------------------------------------|
| **getter** | 필드 값을 반환 | **읽기 전용 프로퍼티**를 구현할 때 사용 | 외부에서 값은 읽을 수 있지만 수정은 불가               |
| **setter** | 필드 값을 변경 | **쓰기 전용 프로퍼티**를 구현할 때 사용 | 잘 사용하지 않음 (데이터 변경 제어를 위해 제한하는 경우가 많음) |

#### getter 사용 방법 예시

```kotlin
class Hero(
    var name: String,
    hp: Int,                // 생성자 파라미터로만 사용
    var sword: Sword? = null
) {
    private var _hp = hp     // 내부에서 _로 선언
    val hp: Int
        get() = _hp          // getter 사용 (읽기 전용)
}

// 버전 2
class Hero(
    var name: String,
    hp: Int,                // 생성자 파라미터로만 사용
) {
    // 초기화

    var hp: Int = hp
        private set         //세터를 막음

}
```

##### getter, setter 예

```kotlin
var stringRepresentation: String
get() = this.toString()
set(value) {
    setDataFromString(value)
}
```

- get() : 객체의 문자열 표현을 반환 (toString() 호출)
- set(value) : 문자열을 받아 setDataFromString() 메서드를 통해 내부 데이터를 설정
- value : setter 블록에서 자동으로 제공되는 매개변수 이름 (별도로 정의하지 않아도 사용 가능)

#### getter, setter 사용시 장점

- Read Only, Write Only 필드의 실현
- 필드의 이름 등, 클래스의 내부 설계를 자유롭게 변경 가능
- 필드로의 액세스를 검사 가능
- val 은 getter 를 기본적으로 내장, var 는 getter와 setter를 내장

---

### 4. 타당성 검사

#### setter 에서 값의 타당성 검사

```kotlin
class Hero(
    name: String,
    var hp: Int,
    var sword: Sword? = null,
) {
    var name: String = name
        set(value) {
            if (value.length <= 1) {
                throw IllegalArgumentException("이름이 너무 짧습니다")
            }
            if (value.length >= 8) {
                throw IllegalArgumentException("이름이 너무 깁니다")
            }
            field = value  // backing field에 값 저장
        }
}
```

#### 생성자 파라미터와 프로퍼티의 관계

- var 또는 val 키워드가 없는 생성자 파라미터(name: String)는 멤버 프로퍼티가 아님
- 즉, 생성자 내부에서만 사용 가능하며 클래스 외부에서는 접근 불가
- 반면 var hp, var sword는 멤버로 포함되어 프로퍼티로 취급됨

#### backing field

- 프로퍼티의 실제 값을 저장하는 내부 필드
- var name 프로퍼티는 내부적으로 field라는 숨겨진 변수를 가지고 있으며,
  getter나 setter에서 이를 통해 값을 읽거나 변경함
- field는 getter/setter 블록 내부에서만 접근 가능하며, 외부에서는 사용할 수 없음

#### 코드 동작 요약

- Hero 객체 생성 시, 생성자에서 name 값이 전달됨
- 이후 name 변경 시 setter가 자동 호출되어 이름 길이를 검사
- 이름이 1자 이하이거나 8자 이상일 경우 IllegalArgumentException 발생
- 유효한 경우에만 field = value를 통해 실제 값이 변경됨

#### IllegalArgumentException -> require()로 표현가능

```kotlin
class Hero(
    name: String,
    var hp: Int,
    var sword: Sword? = null,
) {
    var name: String = name
        set(value) {
            require(value.length > 1) { "이름이 너무 짧습니다" }
            require(value.length < 8) { "이름이 너무 깁니다" }
            field = value
        }
}
```

---

## 컬렉션

### 1. 대표적인 컬렉션 자료 구조

- List : 순서 대로 쌓여있는 구조 (아이템의 중복 허용)
- Map : 키(key)와 값(value)의 쌍으로 저장 (키의 중복 불가)
- Set : 순서가 없는 집합 (중복 불가)

