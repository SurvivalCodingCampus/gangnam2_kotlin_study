## Test Code 초기화 시점

### 1. `private` 키워드를 테스트 코드에 사용하는 이유

- 외부에서 접근할 필요가 없기 때문
- 테스트 코드도 하나의 클래스이므로 불필요한 외부 노출을 최소화

    ```kotlin
    class WandTest {
        private val validName = "마법지팡이"  // 내부 전용
        val testValue = 10                    // 외부 접근 가능 → 불필요한 노출
    }
    ```
- 테스트 간 간섭 방지
    - `val` : 불변으로 만들어 변경을 방지
    - `private` : 외부 접근을 차단하여 테스트 간 간섭을 최소화

### 2. `require()`와 `assertThrows()`의 차이

> require()`와 `assertThrows()`는 모두 **예외 처리와 관련된 코드**이지만,  
> 각각의 역할과 실행 시점이 다름

| 구분    | `require()`    | `assertThrows()`   |
|-------|----------------|--------------------|
| 위치    | 실제 클래스         | 테스트 클래스            |
| 역할    | 유효하지 않은 입력을 방어 | 예외가 정상적으로 발생하는지 검증 |
| 실행 시점 | 애플리케이션 실행 중    | 테스트 실행 중           |
| 관계    | 예외를 “발생시키는 쪽”  | 예외가 “발생했는지 확인하는 쪽” |

### 3. `assertFailsWith`와 예외 발생 시점

#### 잘못된 예시

```kotlin
@Test
fun `지팡이 생성 실패 - 마력 부족`() {
    val name = "마법지팡이"
    val power = 0.3

    // ❌ 예외가 여기서 이미 발생함
    val wand = Wand(name, power)

    // 이 시점에는 테스트가 이미 중단되어버림
    assertFailsWith<IllegalArgumentException> {
        wand
    }
}
```

#### 실행 순서

1. val wand = Wand(name, power)
   → 생성자 안의 require()가 실행되어 예외 발생
2. 예외가 assertFailsWith 블록 밖에서 발생
3. JUnit이 “예상치 못한 예외”로 인식 → 테스트 실패
4. 결과
    ```
   // 예외는 발생했지만, 테스트 프레임워크가 ‘의도된 실패’로 인식하지 못한 경우
    org.opentest4j.AssertionFailedError:
    Expected an exception of class java.lang.IllegalArgumentException to be thrown, but was completed successfully.
    ```

### 올바른 예시

```kotlin
@Test
fun `지팡이 생성 실패 - 마력 부족`() {
    val name = "마법지팡이"
    val power = 0.3

    // ✅ Wand 생성이 assertFailsWith 블록 안에 들어가야 함 
    assertFailsWith<IllegalArgumentException> {
        Wand(name, power)
    }
}
```

#### 실행 순서

1. assertFailsWith가 실행되며 내부 블록을 호출
2. 블록 안에서 Wand(name, power)가 실행됨
3. require(power in 0.5..100.0)에 걸려 IllegalArgumentException 발생
4. 테스트 프레임워크가 “예상된 예외 발생”으로 인식 → 테스트 성공

---

### 4. Kotlin 클래스 초기화 순서

| 단계 | 실행 순서             | 설명                                |
|----|-------------------|-----------------------------------|
| ①  | **주 생성자 파라미터 전달** | 인자로 받은 값이 단순히 생성자에 전달됨            |
| ②  | **프로퍼티 선언부 초기화**  | 프로퍼티에 값이 대입되지만, `setter`는 호출되지 않음 |
| ③  | **`init` 블록 실행**  | 생성자 초기화 직후 실행됨 — 유효성 검사에 사용       |
| ④  | **나중에 프로퍼티 변경 시** | `setter`가 호출되어 `require()` 동작     |

#### 예시

```kotlin
class Wand(
    name: String,
    power: Double
) {
    // Step ③: init 블록 — 생성자 초기화 시점 검사
    init {
        require(power in 0.5..100.0) { "마력은 0.5 이상 100.0 이하여야 합니다." }
    }

    // Step ②: 프로퍼티 선언부 — 초기화 시점에서는 setter 안 거침
    var power: Double = power
        set(value) {
            require(value in 0.5..100.0) { "마력은 0.5 이상 100.0 이하여야 합니다." }
            field = value
        }
}
```

#### 실행 순서

```kotlin
val wand = Wand("지팡이", 0.3)
```

| 순서 | 실행 구문                       | 설명                | require() 실행 여부        |
|----|-----------------------------|-------------------|------------------------|
| ①  | 생성자 파라미터 전달                 | `"지팡이"`, `0.3` 전달 | -                      |
| ②  | `var power: Double = power` | 내부 field에 값 직접 대입 | ❌ setter 안 호출됨         |
| ③  | `init` 블록 실행                | 유효성 검사 실행         | ✅ require() 작동         |
| ④  | 나중에 `wand.power = 200.0`    | 프로퍼티 변경           | ✅ setter의 require() 작동 |

> init은 "객체 생성 시점 검증" <br/>
> setter는 "프로퍼티 변경 시점 검증"

> 둘 다 써야 “생성과 변경” 모든 시점에서 안전하게 유효성 검사가 작동

#### 테스트 예시

지팡이의 마력(power)이 0.5보다 작을 경우 예외를 던지는지 확인

- Wand 클래스의 생성자나 init 블록 내부에서 유효성 검사 코드가 반드시 있어야 함

```kotlin
@Test
fun `지팡이 생성 실패 - 마력 부족`() {
    // given (준비)
    val name = validName        // "마법지팡이"
    val power = lowPower        // 0.4 (0.5 미만)

    // then (검증)
    assertFailsWith<IllegalArgumentException> {
        Wand(name, power)
    }
}
```

#### 예시 흐름

1. assertFailsWith 블록 내부에서 Wand(name, power) 실행
2. 생성자 호출 시 "마법지팡이"와 0.4 전달
3. init 블록이 실행되어 require() 검증 수행
4. 조건 불만족 → IllegalArgumentException 발생
5. 테스트 프레임워크(JUnit)가 예상된 예외 발생으로 판단 → 테스트 통과 ✅

#### 실패하는 경우

init 블록이 없이 setter 안에만 require()를 넣은 경우

- 생성자 초기화 시점에 setter가 호출되지 않기 때문

```kotlin
class Wand(
    name: String,
    power: Double
) {
    var power: Double = power
        set(value) {
            require(value in 0.5..100.0) { "마력은 0.5 이상 100.0 이하여야 합니다." }
            field = value
        }
}
```

#### 실패시 출력되는 에러 메세지

```bash
Expected an exception of class java.lang.IllegalArgumentException to be thrown, but was completed successfully.

```

→ “IllegalArgumentException이 발생해야 하는데
실제로는 아무 예외도 발생하지 않았다”는 뜻

#### 결론

> Wand 클래스의 require() 검사는
> 생성자 초기화 시점(init)과 프로퍼티 변경 시점(setter) <br/>
> 둘 다 있어야 모든 테스트가 정상 통과