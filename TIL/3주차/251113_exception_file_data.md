## 예외처리, 파일 조작, 여러가지 데이터

### 예외 처리(Exception)

#### 예외

> 프로그램 실행 중 예상치 못한 문제가 발생했을 때 이를 알려주는 메커니즘 <br/>
> 적절히 처리하지 않으면 프로그램은 즉시 종료(crash)

#### 예외의 종류

- 문법 에러 (Syntax Error)
    - 코드가 문법에 맞지 않아서 컴파일 단계에 걸림
        - 괄호누락
        - 변수 타입 불일치
        - 오타
    - 실행되기 전이므로 try-catch로 잡을 수 없음

- 실행시 에러(Runtime Error)
    - 프로그램 실행 중에 발생하는 예외
    - 대부분 try–catch로 처리
        - `NumberFormatException`
          "10.5".toInt() → 정수가 아니라서 발생
        - `IllegalArgumentException` → 잘못된 인자 전달 시
        - `FileNotFoundException` → 없는 파일을 읽으려고 할 때
        - `IOException` → 파일 접근 오류
        - `SecurityException` → 파일 쓰기 권한 없음

- 논리 에러(Logic Error)
    - 문법도 맞고 실행도 되지만, 의도한 동작이 아니게 나오는 오류
    - 예외가 발생하지 않아도 잘못된 결과
    - try–catch와 무관
        - 테스트로 잡아야 함

#### try-catch-finally

- try : 예외가 발생할 가능성이 있는 코드를 작성
    ```kotlin
    try {
        someError()
    }
    ```
- catch : 예외를 잡아 처리
    ```kotlin
    catch (e: NumberFormatException) {
        println(e.message)
    }
    ```
    - 예외는 좁은 범위 → 넓은 범위 순으로
    ```kotlin
    catch (e: IllegalArgumentException)
    catch (e: NumberFormatException)
    catch (e: Exception)
    ```
- finally : 예외 발생 여부와 상관없이 항상 실행됨
    - 파일 닫기, 자원 해제 등에 활용
    ```kotlin
    finally {
        println("항상 실행")
    }
    ```

#### throw로 예외 발생

- 개발자가 의도적으로 오류를 발생시킴

```kotlin
throw Exception("에러 발생!")
```

### 파일 조작

| 구분        | 코드 예시                                         | 설명                  |
|-----------|-----------------------------------------------|---------------------|
| **파일 생성** | `File("save.txt").createNewFile()`            | 파일이 없으면 생성          |
| **파일 쓰기** | `File("save.txt").writeText("Hello, world!")` | 파일 없으면 생성, 있으면 덮어쓰기 |
| **파일 읽기** | `File("save.txt").readText()`                 | 파일 내용을 문자열로 반환      |

---

### 여러가지 데이터

#### 직렬화(Serialization)

> 객체(Object)를 저장하거나 전송할 수 있도록 문자열(Text) 또는 바이트(Byte) 형태로 변환하는 과정

#### 역직렬화(Deserialization)

> 직렬화된 데이터를 다시 객체로 되돌리는 과정

#### 직렬화 필요한 이유

| 상황            | 설명                                           |
|---------------|----------------------------------------------|
| **파일로 저장**    | 객체 상태를 파일(txt/json/…)로 저장하여 나중에 다시 사용할 때     |
| **네트워크 전송**   | 서버 ↔ 클라이언트 간 데이터를 주고받기 위해 텍스트 기반(JSON 등)이 필요 |
| **데이터베이스 저장** | 객체를 DB칼럼(text/json) 형태로 저장할 때                |
| **캐싱**        | 메모리·Redis 등에 저장하기 위해 문자열 형태로 변환              |

#### 직렬화 예시

- `@Serializable` 붙여서 객체 정의

```kotlin
import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val name: String,
    val age: Int
)
```

- 객체 → JSON 문자열 (직렬화)

```kotlin
import kotlinx.serialization.json.Json

val employee = Employee("홍길동", 30)
val json = Json.encodeToString(employee)

println(json)
```