# 설계 원칙, 디자인 패턴

## 좋은 설계 원칙이란?

널리 알려진 설계 원칙을 배우고 의식하며 개발을 하자

## 응집도와 결합도

응집도 (Cohesion)

- 모듈이 하나의 목적을 수행하는 요소들간의 연관성 척도
- 모듈 내부의 기능적인 응집 정도를 나타냄

결합도 (Coupling)

- 모듈이 다른 모듈에 의존하는 정도의 척도
- 모듈과 모듈간의 상호 결합 정도를 나타냄

## 응집도는 높게, 결합도는 낮게

- **높은 응집도** : 모듈이 하나의 특정 작업이나 기능에 집중
    - UserAuthentication 클래스 : 로그인, 로그아웃, 비밀번호 변경 기능
- 낮은 응집도 : 모듈이 여러 가지 서로 관련 없는 작업을 수행
    - Util 클래스 : 문자열 처리, 파일 읽기, 날짜 계산 기능
- **낮은 결합도** : 모듈이 서로 독립적으로 작동할 수 있을 때
    - UserAuthentication 클래스가 특정 클래스가 아니라 인터페이스를 통해 사용자 정보를 가져오는 경우
- 높은 결합도 : 모듈이 서로 강하게 연결되어 있을 때
    - UserAuthentication 클래스가 특정 클래스의 내부 구현에 직접 의존하는 경우

## 좋은 코드를 위해 의식해야 하는 6가지 코드 작성의 원칙

### DRY - Don't Repeat Yourself : 같은 것을 몇번씩 반복하지 말라

- 중복 코드가 있다면 메소드로 분리한다

### PIE - Program Intently and Expressively : 명확하고 표현력 있게 기술하자

- 애매한 이름은 쓰지 말자
- 누가 봐도 알기 쉬운 이름을 쓰자
- 컨벤션을 따르자
- 매직 넘버에 이름을 붙이자

### SRP - Single Responsibility Principle : 클래스에 주어진 책임은 1개뿐

- 단일 책임 원칙
- 1개의 클래스는 1개의 일만한다.
- 클래스는 하나의 기능이나 책임만을 가져야 하며, 그 책임이 변경될 때 해당 클래스만 수정하면 된다
- 하지만 적절한 수준의 클래스 분리를 유지하는 것이 중요하다.

### 단일 책임 원칙 - 한 클래스는 하나의 책임만 가진다

```kotlin
// bad
class TodoRepository {
    private val datasource = TodoDataSource()
    // ...
}

// good
class TodoRepository(
    private val dataSource: TodoDataSource,
) {
    // ...
}
```

외부 객체는 생성자로 주입 받아라

### OCP - Open Closed Principle : 개방 폐쇄 원칙

- 확장에 대해서는 열려있고 (확장은 자유롭고), 변경에 대해서는 닫혀있다 (의존 부분의 변경은 불필요)
- 즉, 수정 없이 확장 가능하도록 하자.
- Iterable, Comparator 등이 좋은 예
- String 의 경우는 상속 금지이므로 OCP에 반하는 클래스의 대표적인 예.
- 인터페이스를 적극 활용하여 확장 가능하게 하자.

### 개방 폐쇄 원칙 - 원본 코드를 수정없이 새로운 기능을 추가할 수 있다

```kotlin
// bad
fun attack(slime: Slime) {
    // ...
}

// good
fun attack(monster: Monster) {
    // ...
}
```

Slime, Goblin 각각 때리지 말고 Monster 때려라

### SDP - Stable Dependencies Principle : 안전한 것에 의존하라

- ATM 시스템을 예를 들면 암호 처리 같이 한번 완성되면 수정될 가능성이 없는 클래스에 의존할 만 하다
- 하지만 가장 좋은 것은 특정 클래스가 아니라 인터페이스에 의존하는 것이다
- 클래스는 생성자가 변하거나 할 수 있으나 인터페이스는 거의 그대로이니까.

Random, System.out.println …

```kotlin
interface RandomGenerator {
    fun nextInt(bound: Int): Int
}

class DefaultRandomGeneratro : RandomGenerator {
    private val random = Random()
    override fun nextInt(bound: Int): Int {
        return random.nextInt(bound)
    }
}

class Game(private val randomGenerator: RandomGenerator) {
    fun generateRandomNumber(bound: Int): Int {
        return randomGenerator.nextInt(bound)
    }
}
```

변경 가능성 : Random 을 직접 사용하는 대신, Random을 감싸는 인터페이스를 사용하라
그리고 의존성 주입을 받아라.

### ADP - Acyclic Dependencies Principle

- 의존성 비순환 원칙
- 의존 관계에 사이클이 발생되지 않게 한다

### ADP - 의존성 비순환 원칙

잘못된 구조 (순환 의존성)

```kotlin
class UserService(private val userRepository: UserRepository) {}
class UserRepository(private val userService: UserService) {}
```

## SOLID 원칙

### 단일 책임 원칙 - 한 클래스는 하나의 책임만 가진다

```kotlin
// bad
class TodoRepository {
    private val datasource = TodoDataSource()
    // ...
}

// good
class TodoRepository(
    private val dataSource: TodoDataSource,
) {
    // ...
}
```

외부 객체는 생성자로 주입 받아라

### 개방 폐쇄 원칙 - 원본 코드를 수정없이 새로운 기능을 추가할 수 있다

```kotlin
// bad
fun attack(slime: Slime) {
    // ...
}

// good
fun attack(monster: Monster) {
    // ...
}
```

Slime, Goblin 각각 때리지 말고 Monster 때려라

### LSP - 리스코프 치환 원칙

is a 원칙을 지켜라

### 인터페이스 분리 원칙

인터페이스 하나에 다 때려 넣지 말고 여러개로 쪼개라
Bionic 만 구현하지 말고 Attackable, Moveable, Healable 처럼 기능별로 쪼개라

### 의존 관계 역전 원칙

메딕이 특정 객체를 치료하는 것이 아닌 Healable 인터페이스 구현체를 치료하는 것

일반 클래스에 직접 의존하는 예 (상사 -> 김대리)

- 상사: "김대리, 이거 보고서 오늘까지 완성해 줘!"
- 김대리: "네, 알겠습니다!"

의존성 역전 (DIP 적용 후): (상사 -> 역할 <- 김대리/박대리)

- 상사: "음... '보고서 작성 담당자'는 이 보고서를 오늘까지 완성해 줘."
- 김대리/박대리/최대리: (본인이 '보고서 작성 담당자' 역할을 할 수 있으므로) "네, 제가 하겠습니다!"

## 디자인 패턴

소프트웨어 디자인 패턴(software design pattern)은 소프트웨어 공학의 소프트웨어 디자인에서 특정 문맥에서 공통적으로 발생하는 문제에 대해 재사용 가능한 해결책이다.

디자인 패턴은 프로그래머가 어플리케이션이나 시스템을 디자인할 때 공통된 문제들을 해결하는데에 쓰이는 형식화 된 가장 좋은 관행이다.

결론 : 설계 원칙과 노하우를 정리한 것. 선배님들이 정리한 것을 공부하자.

## 디자인 패턴을 공부했을 때의 장점

- 개발자간에 커뮤니케이션이 원만해 진다
- 객체지향 설계 원칙의 이해도가 좋아진다

### 빌더 (서브웨이)

빌더 패턴은 복잡한 객체를 단계적으로 생성하는 데 유용 (StringBuilder)

```kotlin
// StringBuilder 객체를 생성하고, append를 체이닝하여 데이터 추가
val sentence = StringBuilder()
    .append("Name: ")
    .append(name)
    .append(", Age: ")
    .append(age)
    .append(" from ")
    .append(city)
    .toString() // 최종적으로 String으로 변환
```

### Factory 패턴 (맥도날드)

공장 : 물건을 만드는 곳
Factory 패턴 : 인스턴스를 만드는 패턴

```kotlin
class CarFactory {
    fun createCar(type: String): Car {
        return when (type) {
            "sedan" -> Sedan()
            "truck" -> Truck()
            "van" -> Van()
            else -> throw IllegalArgumentException("알 수 없는 자동차 타입입니다.")
        }
    }
}
```

### Singleton 패턴 (렌트카)

1개의 인스턴스만 생성되는 것을 보증하기 위한 패턴
인스턴스 생성을 여러번 시도해도 1개의 인스턴스가 공유됨
캐시나 공유 데이터, 처리의 효율화 등에 사용되는 테크닉

```kotlin
object RentCar {
    var count = 0
}

fun main() {
    val car1 = RentCar
    car1.count++
    val car2 = RentCar
    println(car2.count) // 1
}
```

### Decorator 패턴 (Jetpack Compose)

```kotlin
Scaffold(
    topBar = {
        // appBar 대신 TopAppBar 사용
        TopAppBar(title = { Text("App bar") })
    },
    floatingActionButton = {
        FloatingActionButton(onClick = { /* Do something */ }) {
            Text("Button")
        }
    }
) { paddingValues -> // Content padding을 받음
}
```

### Facade 패턴 - 내부를 감추고 심플하게

- 복잡한 하위 시스템을 단순화 하기 위한 패턴
- 데이터 접근 계층 : 데이터 소스 처리 몰라도 됨. Repository
- 라이브러리 사용 : 복잡한 네트워크 통신 몰라도 됨. HttpClient

### Strategy (전략 패턴) - 갈아 끼우기 쉽게

런타임에 알고리즘을 동적으로 교체할 수 있도록

- 알고리즘 교체 용이성
- OCP 준수
- 조건문 제거

```kotlin
interface GameAI
class NoramlAI : GameAI
class HardAI : GameAI

class Game(ai: GameAI)

val game1 = Game(NormalAI())
val game2 = Game(HardAI())
```

### Observer 패턴

옵저버 패턴(observer pattern)은 객체의 상태 변화를 관찰하는 관찰자들, 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는
디자인 패턴이다.

주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다. 발행/구독 모델로 알려져 있기도 하다.

#### 옵저버 패턴의 예 : 콜백 함수

콜백 함수를 활용한 예.

```kotlin
class Button(
    private val onPressed: () -> Unit
) {
    fun click() = onPressed.invoke()
}

val button = Button(
    onPressed = {
        println("클릭")
    }
)
button.click()
```

## 아키텍처 디자인 패턴

소프트웨어를 작성함에 있어 코드 뿐만 아니라 전체적인 **구조**(Architecture)에 대한 좋은 패턴도 존재합니다.

가장 대중적인 패턴들은 다음과 같은 내용이 있습니다.

- MVC
- MVC2
- MVP
- MVVM
- MVI
