# [Kotlin Coding 컨벤션](https://kotlinlang.org/docs/coding-conventions.html)

## IDE에서 스타일 구성하기

### 스타일 가이드 적용

1. `Settings/Preferences | Editor | Code Style | Kotlin`로 이동
2. `Set from...` 클릭
3. `Kotlin style guide` 선택

### 스타일 가이드 준수 확인

1. `Settings/Preferences | Editor | Inspections | General`로 이동
2. "Incorrect formatting" 검사 활성화
3. 스타일 가이드에 설명된 다른 문제들(명명 규칙 등)을 검증하는 추가 검사는 기본적으로 활성화됨

---

## 소스 코드 구성

### 디렉토리 구조

순수 Kotlin 프로젝트에서 권장되는 디렉토리 구조는 공통 루트 패키지가 생략된 패키지 구조를 따릅니다.

예: 프로젝트의 모든 코드가 `org.example.kotlin` 패키지와 그 하위 패키지에 있다면:

- `org.example.kotlin` 패키지의 파일은 소스 루트 바로 아래 배치
- `org.example.kotlin.network.socket`의 파일은 소스 루트의 `network/socket` 하위 디렉토리에 배치

### 소스 파일명

**단일 클래스/인터페이스가 있는 경우:**

- 파일명은 클래스명과 동일하게, `.kt` 확장자 추가
- 모든 타입의 클래스와 인터페이스에 적용

**여러 클래스가 있거나 최상위 선언만 있는 경우:**

- 파일의 내용을 설명하는 이름 선택
- Upper camel case 사용 (각 단어의 첫 글자를 대문자로)
- 예: `ProcessDeclarations.kt`

**파일명 규칙:**

- 파일명은 파일의 코드가 무엇을 하는지 설명해야 함
- `Util` 같은 무의미한 단어 사용 피하기

### 멀티플랫폼 프로젝트

플랫폼별 소스 세트의 최상위 선언이 있는 파일은 소스 세트 이름과 관련된 접미사를 가져야 합니다:

- `jvmMain/kotlin/Platform.jvm.kt`
- `androidMain/kotlin/Platform.android.kt`
- `iosMain/kotlin/Platform.ios.kt`

공통 소스 세트의 경우, 최상위 선언이 있는 파일은 접미사가 없어야 합니다:

- `commonMain/kotlin/Platform.kt`

**기술적 세부사항:** JVM은 최상위 멤버(함수, 프로퍼티)를 허용하지 않습니다. 이를 해결하기 위해 Kotlin JVM 컴파일러는 최상위 멤버 선언을 포함하는 래퍼 클래스("파일 파사드")를 생성합니다. 파일
파사드는 파일명에서 파생된 내부 이름을 가집니다.

JVM은 동일한 완전한 클래스명(FQN)을 가진 여러 클래스를 허용하지 않습니다. 이는 Kotlin 프로젝트를 JVM으로 컴파일할 수 없는 상황으로 이어질 수 있습니다.

```kotlin
jvmMain / kotlin / myPackage / Platform.kt
androidMain / kotlin / myPackage / Platform.kt
```

두 `Platform.kt` 파일이 모두 같은 패키지에 있으므로, Kotlin JVM 컴파일러는 두 개의 파일 파사드를 생성하며, 둘 다 `myPackage.PlatformKt` FQN을 가집니다. 이는 "중복
JVM 클래스" 오류를 발생시킵니다.

가장 간단한 해결 방법은 위의 가이드라인에 따라 파일 중 하나의 이름을 바꾸는 것입니다.

### 소스 파일 구성

여러 선언(클래스, 최상위 함수 또는 프로퍼티)을 동일한 Kotlin 소스 파일에 배치하는 것은 이러한 선언이 의미적으로 서로 밀접하게 관련되어 있고 파일 크기가 합리적인(몇 백 줄을 초과하지 않는) 한 권장됩니다.

특히, 클래스의 모든 클라이언트에 관련된 확장 함수를 정의할 때는 클래스 자체와 동일한 파일에 배치하세요. 특정 클라이언트에만 의미가 있는 확장 함수를 정의할 때는 해당 클라이언트의 코드 옆에 배치하세요. 어떤
클래스의 모든 확장을 보관하기 위해서만 파일을 만드는 것은 피하세요.

### 클래스 레이아웃

클래스의 내용은 다음 순서로 배치해야 합니다:

1. 프로퍼티 선언 및 초기화 블록
2. 보조 생성자
3. 메서드 선언
4. Companion object

메서드 선언을 알파벳순이나 가시성순으로 정렬하지 말고, 일반 메서드와 확장 메서드를 분리하지 마세요. 대신, 관련된 것들을 함께 배치하여 클래스를 위에서 아래로 읽는 사람이 무슨 일이 일어나는지의 논리를 따를 수
있도록 하세요. 순서를 선택하고(상위 수준을 먼저 또는 그 반대) 그것을 고수하세요.

중첩 클래스는 해당 클래스를 사용하는 코드 옆에 배치하세요. 클래스가 외부에서 사용되도록 의도되었고 클래스 내부에서 참조되지 않는다면, companion object 뒤 끝에 배치하세요.

```kotlin
import java.time.LocalDateTime

class UserAccount(private val userId: String) {

    // 1. 프로퍼티 선언 및 초기화 블록
    val creationTime: LocalDateTime = LocalDateTime.now()

    // 외부에 노출되지만 내부에서만 변경 가능
    var isActive: Boolean = true
        private set

    private var email: String = ""
    private val transactions = mutableListOf<Transaction>()

    init {
        println("INFO: User account instance created for ID: $userId")
    }

    // 2. 보조 생성자
    constructor(userId: String, initialEmail: String) : this(userId) {
        this.email = initialEmail
        println("INFO: Initial email set to $initialEmail")
    }

    // 3. 메서드 선언 (논리적 흐름: 상위 수준 -> 하위 수준)
    // --- 상위 수준 (High-level) 핵심 비즈니스 메서드 ---

    /**
     * 계정에 새로운 거래를 기록하고 잔액을 업데이트합니다.
     * (핵심 기능이므로 가장 먼저 배치)
     */
    fun recordTransaction(amount: Double, type: TransactionType) {
        // 중첩 클래스 'Transaction' 사용
        val newTransaction = Transaction(amount, type)
        transactions.add(newTransaction)

        // 하위 수준 헬퍼 메서드 호출
        logTransaction(newTransaction)
    }

    /**
     * 사용자의 이메일을 업데이트합니다.
     */
    fun updateEmail(newEmail: String): Boolean {
        // 확장 메서드 사용 (일반 메서드와 분리하지 않음)
        if (newEmail.isValidEmailFormat()) {
            this.email = newEmail
            return true
        }
        return false
    }

    // --- 하위 수준 (Low-level) 헬퍼 메서드 ---

    /**
     * 거래 기록을 시스템 로그에 남깁니다.
     * (recordTransaction을 보조하므로 바로 아래에 배치)
     */
    private fun logTransaction(transaction: Transaction) {
        println("LOG: Transaction recorded - ${transaction.type} ${transaction.amount}")
    }

    /**
     * 주어진 문자열이 유효한 이메일 형식인지 확인하는 확장 함수입니다.
     * (updateEmail을 보조하므로 근처에 배치)
     */
    private fun String.isValidEmailFormat(): Boolean {
        return this.contains("@") && this.length > 5
    }

    // 4. Companion object
    companion object {
        const val MIN_USER_ID_LENGTH = 5

        /**
         * 팩토리 메서드: 유효성 검사를 통해 사용자 인스턴스를 생성합니다.
         */
        fun createDefaultUser(id: String): UserAccount? {
            return if (id.length >= MIN_USER_ID_LENGTH) {
                UserAccount(id, "default@example.com")
            } else null
        }
    }

    // 5. 중첩 클래스 (내부에서만 참조되므로, Companion object 바로 아래에 배치)

    /**
     * 거래 정보를 담는 데이터 클래스입니다. (recordTransaction 메서드에서 사용)
     */
    data class Transaction(val amount: Double, val type: TransactionType)

    enum class TransactionType {
        DEPOSIT, WITHDRAWAL, FEE
    }
}
```

### 인터페이스 구현 레이아웃

인터페이스를 구현할 때, 구현 멤버를 인터페이스의 멤버와 동일한 순서로 유지하세요(필요한 경우 구현에 사용되는 추가 private 메서드가 섞여 있을 수 있음).

### 오버로드 레이아웃

항상 오버로드를 클래스에서 서로 옆에 배치하세요.

---

## 명명 규칙

### 패키지 및 클래스 명명 규칙

Kotlin의 패키지 및 클래스 명명 규칙은 매우 간단합니다:

**패키지명:**

- 항상 소문자
- 언더스코어 사용 안 함 (`org.example.project`)
- 여러 단어 이름 사용은 일반적으로 권장되지 않음
- 여러 단어를 사용해야 한다면, 그냥 연결하거나 camel case 사용 (`org.example.myProject`)

**클래스 및 객체명:**

- Upper camel case 사용

```kotlin
open class DeclarationProcessor { /*...*/ }

object EmptyDeclarationProcessor : DeclarationProcessor() { /*...*/ }
```

### 함수명

함수, 프로퍼티 및 지역 변수의 이름은 소문자로 시작하고 언더스코어 없이 camel case를 사용합니다:

```kotlin
fun processDeclarations() { /*...*/
}
var declarationCount = 1
```

**예외:** 클래스의 인스턴스를 생성하는 데 사용되는 팩토리 함수는 추상 반환 타입과 동일한 이름을 가질 수 있습니다:

```kotlin
interface Foo { /*...*/ }

class FooImpl : Foo { /*...*/ }

fun Foo(): Foo {
    return FooImpl()
}
```

### 테스트 메서드명

테스트에서(그리고 오직 테스트에서만), 백틱으로 둘러싸인 공백이 있는 메서드명을 사용할 수 있습니다. 이러한 메서드명은 Android 런타임에서 API 레벨 30부터만 지원됩니다. 테스트 코드에서는 메서드명에
언더스코어도 허용됩니다.

```kotlin
class MyTestCase {
    @Test
    fun `ensure everything works`() { /*...*/
    }

    @Test
    fun ensureEverythingWorks_onAndroid() { /*...*/
    }
}
```

### 프로퍼티명

**상수명** (`const`로 표시되거나, 커스텀 `get` 함수가 없고 깊이 불변인 데이터를 보유하는 최상위 또는 object `val` 프로퍼티):

- 모두 대문자, 언더스코어로 단어 구분 ([screaming snake case]((https://en.wikipedia.org/wiki/Snake_case)))

```kotlin
const val MAX_COUNT = 8
val USER_NAME_FIELD = "UserName"
```

**동작이 있는 객체나 변경 가능한 데이터를 보유하는 최상위 또는 object 프로퍼티:**

- Camel case 이름 사용

```kotlin
val mutableCollection: MutableSet<String> = HashSet()
```

**싱글톤 객체에 대한 참조를 보유하는 프로퍼티:**

- object 선언과 동일한 명명 스타일 사용 가능

```kotlin
val PersonComparator: Comparator<Person> = /*...*/
```

**Enum 상수:**

- 모두 대문자, 언더스코어로 구분된 이름 (screaming snake case) 또는
- Upper camel case 이름 사용
- 사용에 따라 선택

```kotlin
enum class Color { RED, GREEN }
enum class Color { Red, Green }
```

### Backing 프로퍼티명

클래스에 개념적으로 동일하지만 하나는 공개 API의 일부이고 다른 하나는 구현 세부사항인 두 개의 프로퍼티가 있는 경우, private 프로퍼티의 이름에 언더스코어를 접두사로 사용합니다:

```kotlin
class C {
    private val _elementList = mutableListOf<Element>()

    val elementList: List<Element>
        get() = _elementList
}
```

### 좋은 이름 선택하기

**클래스명:**

- 일반적으로 명사 또는 명사구
- 클래스가 무엇인지 설명
- 예: `List`, `PersonReader`

**메서드명:**

- 일반적으로 동사 또는 동사구
- 메서드가 무엇을 하는지 말함
- 메서드가 객체를 변경하는지 또는 새 것을 반환하는지 제안해야 함
- 예: `close`, `readPersons`
- `sort`는 컬렉션을 제자리에서 정렬
- `sorted`는 컬렉션의 정렬된 사본을 반환

**이름의 목적:**

- 엔티티의 목적이 무엇인지 명확히 해야 함
- 이름에 무의미한 단어(`Manager`, `Wrapper`) 사용 피하기

### 약어 사용 규칙

선언 이름의 일부로 약어를 사용할 때 다음 규칙을 따르세요:

**2글자 약어:**

- 두 글자 모두 대문자 사용
- 예: `IOStream`

**3글자 이상 약어:**

- 첫 글자만 대문자로
- 예: `XmlFormatter`, `HttpInputStream`

---

## 포맷팅

### 들여쓰기

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Tabs and Indents

**4칸 스페이스** 사용. 탭 사용하지 마세요.

중괄호의 경우, 구문이 시작되는 줄의 끝에 여는 중괄호를 배치하고, 닫는 중괄호는 여는 구문과 수평으로 정렬된 별도의 줄에 배치합니다.

```kotlin
if (elements != null) {
    for (element in elements) {
        // ...
    }
}
```

### 가로 공백

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Spaces

**이항 연산자 주위에 공백 넣기** (`a + b`)

- 예외: "범위" 연산자 주위에는 공백 넣지 않기 (`0..i`)

**단항 연산자 주위에 공백 넣지 않기** (`a++`)

**제어 흐름 키워드와 해당 여는 괄호 사이에 공백 넣기** (`if`, `when`, `for`, `while`)

#### 주요 생성자 선언, 메서드 선언 또는 메서드 호출에서 여는 괄호 앞에 공백 넣지 않기

```kotlin
class A(val x: Int)

fun foo(x: Int) {
    ...
}

fun bar() {
    foo(1)
}
```

**`(`, `[` 뒤 또는 `]`, `)` 앞에 절대 공백 넣지 않기**

**`.` 또는 `?.` 주위에 절대 공백 넣지 않기**

- `foo.bar().filter { it > 2 }.joinToString()`
- `foo?.bar()`

**`//` 뒤에 공백 넣기**

- `// This is a comment`

#### 타입 매개변수를 지정하는 데 사용되는 꺾쇠괄호 주위에 공백 넣지 않기

- `class Map<K, V> { ... }`

**`::` 주위에 공백 넣지 않기**

- `Foo::class`, `String::length`

**nullable 타입을 표시하는 데 사용되는 `?` 앞에 공백 넣지 않기**

- `String?`

일반적인 규칙으로, 어떤 종류의 가로 정렬도 피하세요. 식별자의 이름을 다른 길이의 이름으로 바꾸는 것이 선언이나 사용의 형식에 영향을 주어서는 안 됩니다.

### 콜론

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Spaces > Other > Before colon / After colon

다음 시나리오에서 `:` 앞에 공백을 넣으세요:

**타입과 상위타입을 구분할 때:**

```kotlin
interface Foo : Bar
```

**상위클래스 생성자 또는 동일 클래스의 다른 생성자에 위임할 때:**

```kotlin
class FooImpl : Foo {
    constructor(x: Int) : this(x, 0)
    constructor(x: Int, y: Int) : super(x, y)
}
```

**`object` 키워드 뒤:**

```kotlin
object DefaultListener : MouseAdapter() { ... }
```

선언과 그 타입을 구분하는 `:` 앞에는 공백을 넣지 마세요:

```kotlin
fun foo(a: Int): String {
    ...
}
```

`:` 뒤에는 항상 공백을 넣으세요.

### 클래스 헤더

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Wrapping and Braces

몇 개의 주요 생성자 매개변수가 있는 클래스는 한 줄로 작성할 수 있습니다:

```kotlin
class Person(id: Int, name: String)
```

더 긴 헤더를 가진 클래스는 각 주요 생성자 매개변수가 들여쓰기와 함께 별도의 줄에 있도록 형식을 지정해야 합니다. 또한 닫는 괄호는 새 줄에 있어야 합니다. 상속을 사용하는 경우, 상위클래스 생성자 호출 또는
구현된 인터페이스 목록은 괄호와 같은 줄에 있어야 합니다:

```kotlin
class Person(
    id: Int,
    name: String,
    surname: String
) : Human(id, name) {
    // ...
}
```

여러 인터페이스의 경우, 상위클래스 생성자 호출이 먼저 위치해야 하고 그 다음 각 인터페이스가 다른 줄에 위치해야 합니다:

```kotlin
class Person(
    id: Int,
    name: String,
    surname: String
) : Human(id, name),
    KotlinMaker {
    // ...
}
```

긴 상위타입 목록을 가진 클래스의 경우, 콜론 뒤에 줄 바꿈을 넣고 모든 상위타입 이름을 수평으로 정렬하세요:

```kotlin
class MyFavouriteVeryLongClassHolder :
    MyLongHolder<MyFavouriteVeryLongClass>(),
    SomeOtherInterface,
    AndAnotherOne {

    fun foo() { /*...*/
    }
}
```

클래스 헤더가 길 때 클래스 헤더와 본문을 명확히 구분하려면, 클래스 헤더 뒤에 빈 줄을 넣거나(위의 예처럼) 여는 중괄호를 별도의 줄에 배치하세요:

```kotlin
class MyFavouriteVeryLongClassHolder :
    MyLongHolder<MyFavouriteVeryLongClass>(),
    SomeOtherInterface,
    AndAnotherOne {
    fun foo() { /*...*/
    }
}
```

생성자 매개변수에는 일반 들여쓰기(4칸)를 사용하세요. 이렇게 하면 주요 생성자에 선언된 프로퍼티가 클래스 본문에 선언된 프로퍼티와 동일한 들여쓰기를 갖게 됩니다.

### 수식어(Modifier) 순서

선언에 여러 수식어가 있는 경우, 항상 다음 순서로 배치하세요:

```text
public / protected / private / internal
expect / actual
final / open / abstract / sealed / const
external
override
lateinit
tailrec
vararg
suspend
inner
enum / annotation / fun // `fun interface`의 수식어로
companion
inline / value
infix
operator
data
```

모든 어노테이션을 수식어 앞에 배치하세요:

```kotlin
@Named("Foo")
private val foo: Foo
```

라이브러리를 작업하는 경우가 아니라면, 중복 수식어(예: `public`)는 생략하세요.

### 어노테이션

어노테이션은 첨부된 선언 앞에 동일한 들여쓰기로 별도의 줄에 배치하세요:

```kotlin
@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude
```

인수가 없는 어노테이션은 같은 줄에 배치할 수 있습니다:

```kotlin
@JsonExclude @JvmField
var x: String
```

인수가 없는 단일 어노테이션은 해당 선언과 같은 줄에 배치할 수 있습니다:

```kotlin
@Test
fun foo() { /*...*/
}
```

### 파일 어노테이션

파일 어노테이션은 파일 주석(있는 경우) 뒤, `package` 문 앞에 배치되며, `package`와 빈 줄로 구분됩니다(파일을 대상으로 하고 패키지를 대상으로 하지 않는다는 점을 강조하기 위해).

```kotlin
/** 라이센스, 저작권 등 */
@file:JvmName("FooBar")

package foo.bar
```

### 함수

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Wrapping and Braces > Function declaration parameters

함수 시그니처가 한 줄에 맞지 않는 경우, 다음 구문을 사용하세요:

```kotlin
fun longMethodName(
    argument: ArgumentType = defaultValue,
    argument2: AnotherArgumentType,
): ReturnType {
    // body
}
```

함수 매개변수에 일반 들여쓰기(4칸)를 사용하세요. 생성자 매개변수와의 일관성을 보장하는 데 도움이 됩니다.

단일 표현식으로 구성된 본문을 가진 함수의 경우 표현식 본문 사용을 선호하세요:

```kotlin
fun foo(): Int {     // 나쁨
    return 1
}

fun foo() = 1        // 좋음
```

### 표현식 본문

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Wrapping and Braces > Assignment statement

함수에 첫 번째 줄이 선언과 같은 줄에 맞지 않는 표현식 본문이 있는 경우, 첫 번째 줄에 `=` 기호를 배치하고 표현식 본문을 4칸 들여쓰세요:

```kotlin
fun f(x: String, y: String, z: String) =
    veryLongFunctionCallWithManyWords(andLongParametersToo(), x, y, z)
```

### 프로퍼티

매우 간단한 읽기 전용 프로퍼티의 경우, 한 줄 형식을 고려하세요:

```kotlin
val isEmpty: Boolean get() = size == 0
```

더 복잡한 프로퍼티의 경우, 항상 `get`과 `set` 키워드를 별도의 줄에 배치하세요:

```kotlin
val foo: String
get() { /*...*/ }

var bar: String
private set
```

초기화자가 있는 프로퍼티의 경우, 초기화자가 긴 경우 `=` 기호 뒤에 줄 바꿈을 추가하고 초기화자를 4칸 들여쓰세요:

```kotlin
private val defaultCharset: Charset? =
    EncodingRegistry.getInstance().getDefaultCharsetForPropertiesFiles(file)
```

### 제어 흐름 문

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Wrapping and Braces > 'if()' statement / 'when'
> statement

`if` 또는 `when` 문의 조건이 여러 줄인 경우, 항상 문의 본문 주위에 중괄호를 사용하세요. 조건의 각 후속 줄을 문 시작에 대해 4칸 들여쓰세요. 조건의 닫는 괄호를 여는 중괄호와 함께 별도의 줄에
배치하세요:

```kotlin
if (condition1 &&
    condition2
) {
    // body
}
```

이는 조건과 문 본문을 정렬하는 데 도움이 됩니다.

`else`, `catch`, `finally` 키워드와 do-while 루프의 `while` 키워드를 앞의 중괄호와 같은 줄에 배치하세요:

```kotlin
if (condition) {
    // body
} else {
    // else part
}

try {
    // body
} finally {
    // cleanup
}
```

`when` 문에서 분기가 한 줄 이상인 경우, 인접한 case 블록과 빈 줄로 구분하는 것을 고려하세요:

```kotlin
private fun parsePropertyValue(propName: String, token: Token) {
    when (token) {
        is Token.ValueToken ->
            callback.visitValue(propName, token.value)

        Token.LBRACE -> { // ...
        }
    }
}
```

짧은 분기는 조건과 같은 줄에 중괄호 없이 배치하세요:

```kotlin
when (foo) {
    true -> bar() // 좋음
    false -> {
        baz()
    } // 나쁨
}
```

### 메서드 호출

긴 인수 목록에서는 여는 괄호 뒤에 줄 바꿈을 넣으세요. 인수를 4칸 들여쓰세요. 밀접하게 관련된 여러 인수를 같은 줄에 그룹화하세요:

```kotlin
drawSquare(
    x = 10, y = 10,
    width = 100, height = 100,
    fill = true
)
```

인수 이름과 값을 구분하는 `=` 기호 주위에 공백을 넣으세요.

### 체인 호출 래핑

체인 호출을 래핑할 때, `.` 문자 또는 `?.` 연산자를 단일 들여쓰기와 함께 다음 줄에 배치하세요:

```kotlin
val anchor = owner
    ?.firstChild!!
    .siblings(forward = true)
    .dropWhile { it is PsiComment || it is PsiWhiteSpace }
```

체인의 첫 번째 호출은 일반적으로 그 앞에 줄 바꿈이 있어야 하지만, 코드가 그렇게 하는 것이 더 의미가 있다면 생략해도 괜찮습니다.

### 람다

람다 표현식에서는 중괄호 주위와 본문에서 매개변수를 구분하는 화살표 주위에 공백을 사용해야 합니다. 호출이 단일 람다를 취하는 경우, 가능한 한 괄호 밖으로 전달하세요:

```kotlin
list.filter { it > 10 }
```

람다에 레이블을 할당하는 경우, 레이블과 여는 중괄호 사이에 공백을 넣지 마세요:

```kotlin
fun foo() {
    ints.forEach lit@{
        // ...
    }
}
```

여러 줄 람다에서 매개변수 이름을 선언할 때, 첫 번째 줄에 이름을 배치하고 그 뒤에 화살표와 줄 바꿈을 배치하세요:

```kotlin
appendCommaSeparated(properties) { prop ->
    val propertyValue = prop.get(obj)  // ...
}
```

매개변수 목록이 한 줄에 맞지 않을 만큼 긴 경우, 화살표를 별도의 줄에 배치하세요:

```kotlin
foo {
        context: Context,
        environment: Env
    ->
    context.configureEnv(environment)
}
```

### 후행 쉼표

> [!info] IntelliJ 설정: Settings > Editor > Code Style > Kotlin > Other > Use trailing comma

후행 쉼표는 일련의 요소에서 마지막 항목 뒤의 쉼표 기호입니다:

```kotlin
class Person(
    val firstName: String,
    val lastName: String,
    val age: Int, // 후행 쉼표
)
```

후행 쉼표 사용의 여러 이점:

- 버전 관리 diff가 더 깔끔함 - 변경된 값에 모든 초점이 맞춰짐
- 요소를 추가하고 재정렬하기 쉬움 - 요소를 조작할 때 쉼표를 추가하거나 삭제할 필요가 없음
- 코드 생성을 단순화, 예를 들어 객체 초기화자의 경우. 마지막 요소도 쉼표를 가질 수 있음

후행 쉼표는 전적으로 선택 사항입니다 – 코드는 그것 없이도 여전히 작동합니다. Kotlin 스타일 가이드는 선언 사이트에서 후행 쉼표 사용을 권장하고 호출 사이트에서는 재량에 맡깁니다.

IntelliJ IDEA 포맷터에서 후행 쉼표를 활성화하려면, `Settings/Preferences | Editor | Code Style | Kotlin`로 이동하고, Other 탭을 열고 Use trailing
comma 옵션을 선택하세요.

**후행 쉼표를 사용할 수 있는 곳:**

**열거형:**

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST, // 후행 쉼표
}
```

**값 인수:**

```kotlin
fun shift(x: Int, y: Int) { /*...*/
}
shift(
    25,
    20, // 후행 쉼표
)
val colors = listOf(
    "red",
    "green",
    "blue", // 후행 쉼표
)
```

**클래스 프로퍼티 및 매개변수:**

```kotlin
class Customer(
    val name: String,
    val lastName: String, // 후행 쉼표
)
class Customer(
    val name: String,
    lastName: String, // 후행 쉼표
)
```

**함수 값 매개변수:**

```kotlin
fun powerOf(
    number: Int,
    exponent: Int, // 후행 쉼표
) { /*...*/
}
constructor(
    x: Comparable< Number >,
y: Iterable<Number>, // 후행 쉼표
) {}
fun print(
    vararg quantity: Int,
    description: String, // 후행 쉼표
) {
}
```

**선택적 타입이 있는 매개변수(setter 포함):**

```kotlin
val sum: (Int, Int, Int) -> Int = fun(
    x,
    y,
    z, // 후행 쉼표
): Int {
    return x + y + x
}
```

**인덱싱 접미사:**

```kotlin
class Surface {
    operator fun get(x: Int, y: Int) = 2 * x + 4 * y - 10
}

fun getZValue(mySurface: Surface, xValue: Int, yValue: Int) =
    mySurface[
        xValue,
        yValue, // 후행 쉼표
    ]
```

**람다의 매개변수:**

```kotlin
fun main() {
    val x = {
            x: Comparable<Number>,
            y: Iterable<Number>, // 후행 쉼표
        ->
        println("1")
    }
}
```

**when 항목:**

```kotlin
fun isReferenceApplicable(myReference: KClass<*>) = when (myReference) {
    Comparable::class,
    Iterable::class,
    String::class, // 후행 쉼표
        -> true
    else -> false
}
```

**컬렉션 리터럴(어노테이션에서):**

```kotlin
annotation class ApplicableFor(val services: Array<String>)

@ApplicableFor(
    [
        "serializer",
        "balancer",
        "database",
        "inMemoryCache", // 후행 쉼표
    ]
)
fun run() {
}
```

**타입 인수:**

```kotlin
fun <T1, T2> foo() {}
fun main() {
    foo<
            Comparable<Number>,
            Iterable<Number>, // 후행 쉼표
            >()
}
```

**타입 매개변수:**

```kotlin
class MyMap
MyKey,
MyValue, // 후행 쉼표
> {}
```

**구조 분해 선언:**

```kotlin
data class Car(val manufacturer: String, val model: String, val year: Int)

val myCar = Car("Tesla", "Y", 2019)
val (
    manufacturer,
    model,
    year, // 후행 쉼표
) = myCar
val cars = listOf<Car>()
fun printMeanValue() {
    var meanValue: Int = 0
    for ((
        _,
        _,
        year, // 후행 쉼표
    ) in cars) {
        meanValue += year
    }
    println(meanValue / cars.size)
}
```

### 문서 주석

더 긴 문서 주석의 경우, 별도의 줄에 여는 `/**`를 배치하고 각 후속 줄을 별표로 시작하세요:

```kotlin
/**
 * 이것은 여러 줄로 된
 * 문서 주석입니다.
 */
```

짧은 주석은 한 줄에 배치할 수 있습니다:

```kotlin
/** 이것은 짧은 문서 주석입니다. */
```

일반적으로 `@param` 및 `@return` 태그 사용을 피하세요. 대신 매개변수와 반환 값에 대한 설명을 문서 주석에 직접 통합하고, 언급되는 곳마다 매개변수에 대한 링크를 추가하세요. 주요 텍스트의 흐름에
맞지 않는 긴 설명이 필요한 경우에만 `@param`과 `@return`을 사용하세요.

```kotlin
// 피하기:

/**
 * Returns the absolute value of the given number.
 * @param number The number to return the absolute value for.
 * @return The absolute value.
 */
fun abs(number: Int): Int { /*...*/
}

// 선호:

/**
 * Returns the absolute value of the given [number].
 */
fun abs(number: Int): Int { /*...*/
}
```

---

## 중복 구조 피하기

일반적으로, Kotlin에서 특정 구문 구조가 선택 사항이고 IDE에 의해 중복으로 강조 표시되는 경우, 코드에서 생략해야 합니다. "명확성을 위해" 불필요한 구문 요소를 코드에 남겨두지 마세요.

### Unit 반환 타입

함수가 Unit을 반환하는 경우, 반환 타입을 생략해야 합니다:

```kotlin
fun foo() { // ": Unit"이 생략됨
}
```

### 세미콜론

가능한 한 세미콜론을 생략하세요.

### 문자열 템플릿

간단한 변수를 문자열 템플릿에 삽입할 때 중괄호를 사용하지 마세요. 더 긴 표현식에만 중괄호를 사용하세요:

```kotlin
println("$name has ${children.size} children")
```

[멀티 달러 문자열 보간](https://kotlinlang.org/docs/strings.html#multi-dollar-string-interpolation) 사용하여 달러 기호 문자 `$`를 문자열 리터럴로
처리하세요:

```kotlin
val KClass<*>.jsonSchema: String
get() = $$"""  
        {
            "$schema": "https://json-schema.org/draft/2020-12/schema",
            "$id": "https://example.com/product.schema.json",
            "$dynamicAnchor": "meta",
            "title": "$${simpleName ?: qualifiedName ?: "unknown"}",
            "type": "object"
        }
        """
```

---

## 언어 기능의 관용적 사용

### 불변성

변경 가능한 데이터보다 불변 데이터를 사용하는 것을 선호하세요. 초기화 후 수정되지 않는 경우 항상 지역 변수와 프로퍼티를 `var`보다 `val`로 선언하세요.

변경되지 않는 컬렉션을 선언하려면 항상 불변 컬렉션 인터페이스(`Collection`, `List`, `Set`, `Map`)를 사용하세요. 팩토리 함수를 사용하여 컬렉션 인스턴스를 생성할 때, 가능한 한 불변
컬렉션 타입을 반환하는 함수를 항상 사용하세요:

```kotlin
// 나쁨: 변경 가능한 컬렉션 타입 사용
fun validateValue(actualValue: String, allowedValues: HashSet<String>) {
    ...
}

// 좋음: 불변 컬렉션 타입 사용
fun validateValue(actualValue: String, allowedValues: Set<String>) {
    ...
}

// 나쁨: arrayListOf()는 변경 가능한 컬렉션 타입인 ArrayList<T>를 반환
val allowedValues = arrayListOf("a", "b", "c")

// 좋음: listOf()는 List<T>를 반환
val allowedValues = listOf("a", "b", "c")
```

### 기본 매개변수 값

오버로드된 함수를 선언하는 것보다 기본 매개변수 값을 가진 함수를 선언하는 것을 선호하세요.

```kotlin
// 나쁨
fun foo() = foo("a")
fun foo(a: String) { /*...*/
}

// 좋음
fun foo(a: String = "a") { /*...*/
}
```

### 타입 별칭

코드베이스에서 여러 번 사용되는 함수형 타입 또는 타입 매개변수가 있는 타입이 있는 경우, 그것에 대한 타입 별칭을 정의하는 것을 선호하세요:

```kotlin
typealias MouseClickHandler = (Any, MouseEvent) -> Unit
typealias PersonIndex = Map<String, Person>
```

이름 충돌을 피하기 위해 private 또는 internal 타입 별칭을 사용하는 경우, [Packages and Imports](https://kotlinlang.org/docs/packages.html)에 언급된
`import ... as ...`를 선호하세요.

### 람다 매개변수

짧고 중첩되지 않은 람다에서는 매개변수를 명시적으로 선언하는 대신 `it` 규약을 사용하는 것이 권장됩니다.

```kotlin
// 'it' 컨벤션을 사용하는 추천 코드
val numbers = listOf(1, 5, 2)
val doubled = numbers.map { it * 2 }
// 'it'은 (1, 5, 2)의 각 요소입니다.

println(doubled) // 출력: [2, 10, 4]

// (참고) 명시적으로 선언한 경우 - 불필요하게 장황함
val doubledExplicit = numbers.map { number -> number * 2 }
```

매개변수가 있는 중첩 람다에서는 항상 매개변수를 명시적으로 선언하세요.

```kotlin
// 중첩된 람다 (예: 'forEach' 안의 'map')
val matrix = listOf(listOf(1, 2), listOf(3, 4))

matrix.forEach { row -> // 바깥 람다: 파라미터 명시적 선언 (row)
    row.map { element -> // 안쪽 람다: 파라미터 명시적 선언 (element)
        println("Row: $row, Element: $element")
        // 만약 안쪽 람다에서 'it'을 사용하면 'element'를 의미함
        // 바깥 람다에서는 'row' 대신 'it'을 사용할 수도 있지만, 
        // 중첩을 고려해 명시적 선언이 더 명확합니다.
    }
}
```

### 람다에서의 반환

람다에서 여러 레이블 반환을 사용하는 것을 피하세요. 람다가 단일 종료 지점을 갖도록 재구성하는 것을 고려하세요.

```kotlin
fun containsNegative(list: List<Int>): Boolean {
    list.forEach {
        if (it < 0) {
            println("음수 발견: $it")
            return@forEach true // ERROR: 람다의 반환 값이 아닌 forEach의 단일 스텝을 종료함
            // return@forEach는 실제로 'forEach'의 다음 루프를 실행하도록 할 뿐,
            // containsNegative 함수를 종료하고 'true'를 반환하지 못합니다.
            // 원하는 결과를 얻으려면 'throw'를 사용하거나, 익명 함수로 변환해야 합니다.
        }
    }
    return false
}
```

그것이 불가능하거나 충분히 명확하지 않은 경우, 람다를 익명 함수로 변환하는 것을 고려하세요.

```kotlin
fun containsNegativeSafe(list: List<Int>): Boolean {
    list.forEach(
        fun(element: Int) { // 익명 함수로 변환
            if (element < 0) {
                println("음수 발견: $element")
                return true // 'containsNegativeSafe' 함수를 종료하고 'true'를 반환
            }
        }
    )
    return false // 음수를 발견하지 못한 경우
}

println(containsNegativeSafe(listOf(1, 2, -3, 4))) // 출력: 음수 발견: -3 \n true
```

람다의 마지막 문에 레이블 반환을 사용하지 마세요.

```kotlin
// 권장하지 않음: 불필요한 라벨 붙은 반환
val result = listOf(1, 2, 3).map {
    val doubled = it * 2
    return@map doubled // 마지막 문장에 return@map 사용 (불필요)
}

// 추천: 마지막 표현식이 자동으로 반환됩니다.
val resultRecommended = listOf(1, 2, 3).map {
    val doubled = it * 2
    doubled // 이 값이 map 람다의 반환 값이 됩니다.
}

println(resultRecommended) // 출력: [2, 4, 6]
```

### 명명된 인수

메서드가 동일한 원시 타입의 여러 매개변수를 취하거나 `Boolean` 타입의 매개변수를 가질 때, 문맥에서 모든 매개변수의 의미가 절대적으로 명확하지 않는 한 명명된 인수 구문을 사용하세요.

```kotlin
drawSquare(x = 10, y = 10, width = 100, height = 100, fill = true)
```

### 조건문

`try`, `if`, `when`의 표현식 형태를 사용하는 것을 선호하세요:

```kotlin
return if (x) foo() else bar()

return when (x) {
    0 -> "zero"
    else -> "nonzero"
}
```

위는 다음보다 선호됩니다:

```kotlin
if (x)
    return foo()
else
    return bar()

when (x) {
    0 -> return "zero"
    else -> return "nonzero"
}
```

### if versus when

이진 조건에는 `when`보다 `if`를 사용하는 것을 선호하세요. 예를 들어, `if`와 함께 이 구문을 사용하세요:

```kotlin
if (x == null) ... else ...
```

`when`과 함께 이것 대신:

```kotlin
when (x) {
    null -> // ...
    else -> // ...
}
```

세 개 이상의 옵션이 있는 경우 `when` 사용을 선호하세요.

### when 표현식의 가드 조건

여러 boolean 표현식을 [가드 조건](https://kotlinlang.org/docs/control-flow.html#guard-conditions-in-when-expressions)이 있는 `when`
표현식이나 문에서 결합할 때 괄호를 사용하세요:

```kotlin
when (status) {
    is Status.Ok if (status.info.isEmpty() || status.info.id == null) -> "no information"
}

when (x) {
    in 1..10 -> println("cheap")
    (x > 100 && canAfford(x)) -> println("expensive")
    else -> println("unavailable")
}
```

다음 대신:

```kotlin
when (status) {
    is Status.Ok if status.info.isEmpty() || status.info.id == null -> "no information"
}

when (x) {
    in 1..10 -> println("cheap")
    x > 100 && canAfford(x) -> println("expensive")
    else -> println("unavailable")
}
```

### 조건에서 nullable Boolean 값

조건문에서 nullable `Boolean`을 사용해야 하는 경우, `if (value == true)` 또는 `if (value == false)` 검사를 사용하세요.

### 루프

루프보다 고차 함수(`filter`, `map` 등)를 사용하는 것을 선호하세요. 예외: `forEach` (forEach의 수신자가 nullable이거나 forEach가 더 긴 호출 체인의 일부로 사용되지 않는 한
일반 `for` 루프를 사용하는 것을 선호).

여러 고차 함수를 사용하는 복잡한 표현식과 루프 사이에서 선택할 때, 각 경우에 수행되는 작업의 비용을 이해하고 성능 고려 사항을 염두에 두세요.

### 범위에 대한 루프

개방형 범위를 반복하려면 `..<` 연산자를 사용하세요:

```kotlin
for (i in 0..n - 1) { /*...*/
} // bad
for (i in 0..<n) { /*...*/
} // good
```

### 문자열

문자열 연결보다 문자열 템플릿을 선호하세요.

일반 문자열 리터럴에 `\n` 이스케이프 시퀀스를 포함하는 것보다 여러 줄 문자열을 선호하세요.

여러 줄 문자열에서 들여쓰기를 유지하려면, 결과 문자열에 내부 들여쓰기가 필요하지 않을 때는 `trimIndent`를, 내부 들여쓰기가 필요할 때는 `trimMargin`을 사용하세요:

```kotlin
fun main() {
    println(
        """
        Not
        trimmed
        text
        """
    )

    println(
        """
        Trimmed
        text
        """.trimIndent()
    )

    println()

    val a = """Trimmed to margin text:
          |if(a > 1) {
          |    return a
          |}""".trimMargin()

    println(a)
}
```

[Java와 Kotlin 여러 줄 문자열](https://kotlinlang.org/docs/java-to-kotlin-idioms-strings.html#use-multiline-strings)의 차이점을
배우세요.

### 함수 vs 프로퍼티

일부 시나리오에서는 인수가 없는 함수가 읽기 전용 프로퍼티와 상호 교환 가능할 수 있습니다. 의미론이 유사하지만, 언제 하나를 다른 것보다 선호할지에 대한 몇 가지 스타일 규약이 있습니다.

기본 알고리즘이 다음과 같을 때 함수보다 프로퍼티를 선호하세요:

- 예외를 throw하지 않음
- 계산이 저렴함(또는 첫 실행 시 캐시됨)
- 객체 상태가 변경되지 않았다면 호출 시마다 동일한 결과를 반환함

### 확장 함수

확장 함수를 자유롭게 사용하세요. 주로 객체에서 작동하는 함수가 있을 때마다, 해당 객체를 수신자로 받아들이는 확장 함수로 만드는 것을 고려하세요. API 오염을 최소화하려면 확장 함수의 가시성을 의미가 있는 만큼
제한하세요. 필요에 따라 지역 확장 함수, 멤버 확장 함수 또는 private 가시성이 있는 최상위 확장 함수를 사용하세요.

### 중위 함수

유사한 역할을 하는 두 객체에서 작동할 때만 함수를 `infix`로 선언하세요. 좋은 예: `and`, `to`, `zip`. 나쁜 예: `add`.

수신자 객체를 변경하는 경우 메서드를 `infix`로 선언하지 마세요.

### 팩토리 함수

클래스에 대한 팩토리 함수를 선언하는 경우, 클래스 자체와 동일한 이름을 부여하지 마세요. 팩토리 함수의 동작이 왜 특별한지 명확히 하는 별개의 이름을 사용하는 것을 선호하세요. 정말로 특별한 의미론이 없는 경우에만
클래스와 동일한 이름을 사용할 수 있습니다.

```kotlin
class Point(val x: Double, val y: Double) {
    companion object {
        fun fromPolar(angle: Double, radius: Double) = Point(...)
    }
}
```

다른 상위클래스 생성자를 호출하지 않고 기본값이 있는 매개변수가 포함된 단일 생성자로 축소할 수 없는 여러 오버로드된 생성자가 있는 객체가 있는 경우, 오버로드된 생성자를 팩토리 함수로 바꾸는 것을 선호하세요.

### 플랫폼 타입

플랫폼 타입의 표현식을 반환하는 public 함수/메서드는 Kotlin 타입을 명시적으로 선언해야 합니다:

```kotlin
fun apiCall(): String = MyJavaApi.getProperty("name")
```

플랫폼 타입의 표현식으로 초기화된 모든 프로퍼티(패키지 수준 또는 클래스 수준)는 Kotlin 타입을 명시적으로 선언해야 합니다:

```kotlin
class Person {
    val name: String = MyJavaApi.getProperty("name")
}
```

플랫폼 타입의 표현식으로 초기화된 지역 값은 타입 선언이 있을 수도 있고 없을 수도 있습니다:

```kotlin
fun main() {
    val name = MyJavaApi.getProperty("name")
    println(name)
}
```

### 스코프 함수 apply/with/run/also/let

Kotlin은 주어진 객체의 컨텍스트에서 코드 블록을 실행하는 함수 세트를 제공합니다: `let`, `run`, `with`, `apply`, `also`. 귀하의 경우에 적합한 스코프 함수를 선택하는 지침은
Scope Functions를 참조하세요.

---

## 라이브러리에 대한 코딩 컨벤션

라이브러리를 작성할 때, API 안정성을 보장하기 위해 추가 규칙 세트를 따르는 것이 권장됩니다:

- **항상 멤버 가시성을 명시적으로 지정** (public API로 선언을 실수로 노출하는 것을 방지하기 위해)
- **항상 함수 반환 타입과 프로퍼티 타입을 명시적으로 지정** (구현이 변경될 때 실수로 반환 타입을 변경하는 것을 방지하기 위해)
- **모든 public 멤버에 대해 [KDoc](https://kotlinlang.org/docs/kotlin-doc.html) 주석을 제공** (새로운 문서가 필요하지 않은 override는 제외, 라이브러리에
  대한 문서 생성을 지원하기 위해)

라이브러리를 위한 API를 작성할 때 고려해야 할 모범 사례와 아이디어에 대해 자세히
알아보려면 [Library authors' guidelines](https://kotlinlang.org/docs/api-guidelines-introduction.html)를 참조하세요.
