# Flow

## Flow

- 데이터 스트림을 표현하기 위한 구조
- LiveData는 안드로이드의 Life cycle 과 깊게 연관되어 있는 반면 순수 코틀린 API
- 코틀린 공식 비동기 API
- **코루틴**에서 데이터 수집이 가능함

## 단일 값 vs 여러 값

```kotlin
// 단일 값 반환
suspend fun getUser(): User

// 여러 값을 순차적으로 방출
fun getUsers(): Flow<User>
```

- Flow는 **비동기**적으로 계산되는 데이터 **스트림**
- **코루틴**을 기반으로 동작
- 여러 값을 순차적으로 방출할 수 있음
- **Cold** Stream 방식 (수집하는 시점에 데이터 생성)

## flow() 빌더

```kotlin
// 게임 캐릭터의 상태 변화를 Flow로 표현
class GameCharacter(val name: String) {
    // 레벨업 이벤트를 발생시키는 Flow
    fun experienceFlow() = flow {
        var level = 1
        while (level <= 5) {
            delay(1000) // 1초마다 레벨업
            emit(level++)
        }
    }

    // HP 변화를 발생시키는 Flow
    fun hpFlow() = flow {
        var hp = 100
        while (hp > 0) {
            delay(500) // 0.5초마다 HP 감소
            hp -= 10
            emit(hp)
        }
    }
}
```

- flow 빌더는 코루틴을 사용하여 비동기 스트림을 생성하는데 사용됨
- emit() : Flow 내에서 값을 방출할 때 사용
- flow 빌더 내에서 suspend 함수 사용 가능

## launchIn()

Flow를 새로운 코루틴에서 수집하기 위한 함수. 주로 ViewModel에서 많이 사용됨

```kotlin
fun main() = runBlocking {
    val hero = GameCharacter("용사")

    // 레벨업 관찰
    hero.experienceFlow()
        .onEach { level -> println("${hero.name}가 ${level}레벨이 되었습니다.") }
        .launchIn(this)

    // HP 변화 관찰
    hero.hpFlow()
        .onEach { hp -> println("${hero.name}의 현재 HP: $hp") }
        .filter { hp -> hp < 50 } // HP가 50 미만일 때만
        .onEach { println("${hero.name}가 위험합니다!") }
        .launchIn(this)

    delay(5000) // 5초 동안 관찰
}
```

Flow는 다양한 변환 연산자를 제공

- map
- filter
- take
- onEach

## 1. 기본 Flow 생성과 수집 (collect) 예제

```kotlin
// 1. 기본 Flow 생성과 수집
println("\n1. 기본 Flow")
val basicFlow = flow {
    for (i in 1..3) {
        delay(100)
        println("Emmiting $i")
        emit(i)
    }
}

basicFlow.collect { value ->
    println("Collected: $value")
}
```

- collect() : Flow의 값을 소비하기 위해 사용되는 함수
- Flow 는 collect() 되는 시점에 값이 방출 됨 (Cold)

## 2. Flow 빌더 예제

```kotlin
flowOf(1, 2, 3).collect { println("flowOf: $it") }
(1..3).asFlow().collect { println("asFlow: $it") }
```

- 컬렉션을 Flow로 바꾸는 방법은 asFlow() 로 쉽게 가능하다
- flowOf() 로도 간단히 만들 수 있다

## 3. Flow 연산자 예제

```kotlin
flow {
    emit(1)
    emit(2)
    emit(3)
}.map { it * 2 }
    .filter { it > 2 }
    .map { println("Transformed: $it") }
```

- map
- filter

## 4. Flow 합치기 : Zip 연산자

```kotlin
val flow1 = flowOf("A", "B", "C")
val flow2 = flowOf(1, 2, 3)

flow1.zip(flow2) { a, b -> "$a$b" }
    .collect { println("Zipped: $it") }
```

- 두 개 이상의 Flow를 결합하여 새로운 Flow를 생성하는데 사용되는 연산자
- 각 Flow에서 방출된 값을 쌍으로 묶어 새로운 값을 생성
- 두 개의 Flow 가 모두 값을 방출할 때마다 호출

## 4-1. Flow 합치기 : Combine 연산자

```kotlin
val flow1 = flowOf(1, 2, 3)
val flow2 = flowOf("A", "B", "C")

flow1.zip(flow2) { number, letter ->
    "$number = $letter"
}.collect { value ->
    println(value) // 1 - A, 2 - B, 3 - C 출력
}
```

- zip
    - 모든 flow가 값을 방출해야 새로운 값을 생성
    - 방출 순서 보장
    - 모든 Flow 값이 필요할 때
    - 두 개의 API 결과를 동시에 가져와야 할 때

```kotlin
val flow1 = flowOf(1, 2, 3).onEach { delay(100) } // 0.1초 대기
val flow2 = flowOf("A", "B", "C").onEach { delay(200) } // 0.2초 대기

flow1.combine(flow2) { number, letter ->
    "$number = $letter"
}.collect { value ->
    println(value) // 1 - A, 2 - B, 3 - C 출력
}
```

- combine
    - 하나의 Flow가 값을 방출할 때마다 가장 최근의 값을 사용하여 새로운 값을 생성
    - 방출 순서 보장 못 함
    - 방출될 때마다 다른 Flow의 최신 값을 사용하고 싶을 때- 실시간 검색에서 사용자 입력과 필터를 결합하고자 할 때

## 5. 에러 처리

```kotlin
flow {
    emit(1)
    throw RuntimeException("에러 발생!")
}.catch { e ->
    println("에러 캐치: ${e.message}")
    emit(-1)
}.onCompletion { cause ->
    println("완료${cause?.let { ": ${it.message}" } ?: ""}")
}.collect { println("값: $it") }
```

- catch : 에러를 캐치할 수 있다
- onCompletion : Flow 의 수집이 완료되었을 때 실행할 작업을 정의. 수집 중에 발생한 예외 정보도 전달받을 수 있음

## 6. StateFlow 예제

```kotlin
val stateFlow = MutableStateFlow(0)
val job = launch {
    stateFlow.collect { println("StateFlow: $it") }
}

delay(100)
stateFlow.value = 1
delay(100)
stateFlow.value = 2
delay(100)
job.cancel()
```

- StateFlow는 코루틴에서 제공하는 특별한 **핫 스트림** Flow 임
- 상태 변화를 관찰하고, 최신 상태를 유지하는데 유용함. 안드로이드에서 주로 UI 상태 관리에 사용됨
- 항상 최신 상태를 유지 (소비되지 않고 마지막 값이 남아 있음) - 특이한 핫 스트림
- Thread Safe
- StateFlow 는 읽기 전용이며, 상태를 변경하려면 MutableStateFlow를 사용

## 7. 병렬 처리

```kotlin
(1..5).asFlow()
    .flatMapMerge { num ->
        flow {
            delay(100)
            emit("처리된 $num")
        }
    }
    .collect { print(it) }
```

- flatMapMerge : 여러 개의 Flow를 병합하여 단일 Flow로 만드는데 사용
- 병렬 처리를 지원하여, 여러 Flow 의 결과를 동시에 수집
- 방출된 값의 순서가 보장되지 않는다

## 8. 컨텍스트 전환

```kotlin
flow {
    println("Flow: ${Thread.currentThread().name}")
    emit(1)
}.flowOn(Dispatchers.IO)
    .collect {
        println("Collect: ${Thread.currentThread().name}")
        println("값: $it")
    }
```

- flowOn은 Flow의 연산을 특정 디스패처에서 실행하도록 지정 가능

## 9. debounce 예제

```kotlin
flow {
    emit("A")
    delay(100)
    emit("B")
    delay(90)
    emit("C")
    delay(110)
    emit("D")
}.debounce(100)
    .collect { println("Debounced: $it") }
```

- debounce : 이벤트 스트림에서 불필요한 이벤트를 줄이고, 성능을 최적화하는데 유용
- 연타 방지, API 호출횟수 컨트롤 등에 활용
