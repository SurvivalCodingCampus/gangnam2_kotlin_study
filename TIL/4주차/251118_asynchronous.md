## 비동기 (Asynchronous)

### 용어 정리

#### 동기

> 한 작업이 끝날때까지 기다렸다가 다음 작업을 시작함

- 동기 프로그래밍
  - 코드가 순서대로 실행 
  - 작업이 완료될 때까지 프로그램이 중단될 수 없음 
  - 모든 작업은 이전 작업의 실행이 완료될 때까지 기다려야 함 
  - 코드의 실행 순서가 예측 가능


#### 비동기

> 기다리지 않고 다른 작업을 시작함

- 비동기 프로그래밍
  - 여러 작업이 병렬로 실행될 수 있음
  - 한 작업이 완료 여부와 관계없이 다음 작업을 시작할 수 있음
  - 작업의 완료 순서를 예측할 수 없음
  - I/O 작업이나 네트워크 요청과 같이 시간이 오래 걸리는 작업에 유용
- 비동기를 처리하는 방식
  - Java의 Thread, 콜백, Future 방식
  - Kotlin의 Coroutine


#### 동시성 (Cocurrency)

> 여러 작업을 번갈아가면 처리하는 것 

- 여러 작업이 논리적으로 동시에 실행되는 것처럼 보이는 개념
- 시분할 방식으로 여러 스레드를 활용해 동시성을 구현할 수 있음


#### 병렬성 (Parallelism)

> 여러 작업을 실제로 동시에 처리하는 것

- 여러 작업이 물리적으로 동시에 실행되는 개념
- 멀티코어 환경에서 실제로 여러 스레드가 병렬로 실행될 수 있음

### 코루틴 (Coroutine)

#### 단일 스레드의 문제

- 모든 인스턴스는 main 스레드에서 생성되며 처리 
- Thread 를 Block 하는 동안 (sleep 메서드) 프로그램이 멈춤

#### 콜백 기준 동기화 방식의 문제

- 코드의 깊이가 깊어지고 관리하기 어려워짐
- 콜백 지옥
- 디버깅이 어려움
- 병렬처리의 어려움

#### Coroutine

- Kotlin 표준 병행 프로그래밍 API 
- 코루틴은 오래 걸리는 작업을 수행하는 방법 중 우아하고 효율적인 방법 중 하나
- 콜백 기반 코드를 순차 코드로 변환할 수 있음
- 순차 코드는 읽기 쉽고 에러 처리가 편함


#### Coroutine과 suspend 함수 사용

```kotlin
// 메인 스레드
fun runMain(): Job = GlobalScope.launch {
   val data = Weathers.tomorrow()
   println("내일 날씨는: ${data}")
}


suspend fun Weathers.tomorrow(): String {
   delay(2000) // 2초가 처리
   return "맑음"
} // 스레드가 블록되지 않음
```

#### 일반적인 멀티태스킹과 코루틴

- 일반적으로는 하나의 코루틴이 특정한 스레드에서 동작 
- 코틀린 코루틴은 suspend와 resume을 통해 스레드를 양보 
- 코루틴은 비동기식이며 스레드를 차단하지 않음
- 코루틴은 일시 중단 함수를 사용하여 비동기 코드를 순차적으로 만듦

#### Coroutine 사용시 이점

- 경량
  - 코루틴은 실행 중인 스레드를 차단하지 않는 정지(suspend)를 지원하여 메모리를 절약하면서 많은 동시 작업을 처리
- 메모리 누수 감소
  - 스레드를 활용한 동기화는 휴먼 에러에 의한 메모리 누수나 데드락과 같은 위험이 존재하지만, 코루틴은 안전
- 스레드보다 가볍고 효율적
- 많은 안드로이드 API 가 지원

#### Coroutine 주요 컨셉
- 다른 언어의 async, await 같은 키워드가 제공되지 않음
- 대신 정지 함수를 활용한 안전하고 에러가 발생하지 않는 비동기 처리에 중점을 두고 있음 

```kotlin
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}
```

#### Coroutine scope

- 코루틴은 스코프에 의존적
    ```kotlin
    fun main() = runBlocking {     // runBlocking 스코프(코루틴 스코프)를 만든다
        launch {                   // 이 스코프 안에서 새로운 코루틴을 시작할 수 있다
            delay(1000L)
            println("World!")
        }
        println("Hello")           // launch 코루틴과는 별개로 즉시 실행됨
    }                              // runBlocking 끝날 때까지 내부 코루틴을 기다린다
    ```

#### Coroutine Builder

> 새로운 코루틴을 시작하게 해주는 함수들 <br/>
> → 예: runBlocking, launch, async, withContext 등

- 코루틴 빌더의 역할
  - 코루틴의 생명주기를 관리하는 CoroutineScope를 생성함
  - 같은 스코프 안에서는 여러 코루틴을 독립적으로 실행할 수 있음
    ```kotlin
    fun main() = runBlocking {       // 현재 스레드를 블로킹하는 코루틴 빌더
    
        launch {                    // 현재 스레드를 블로킹하지 않는 코루틴 빌더
            delay(1000L)
            println("World!")
        }
    
        println("Hello")            // launch는 비동기라 Hello가 먼저 출력됨
    }
    ```
    - launch로 실행한 코루틴은 비동기적으로 동작하므로 Hello가 먼저 출력됨 → launch는 현재 스레드를 블로킹하지 않음

#### Coroutine Scope 정리

- 모든 코루틴을 추적하여 코루틴이 실행되어야 하는 시기를 관리하는 구성요소
- 모든 비동기 작업은 특정 스코프에서 실행되어야 함
- 코루틴은 스코프에 의존적이다
- 적절한 스코프가 없으면 전역적인 스코프인 GlobalScope를 사용 가능 (비추천)

#### Job

- CoroutineBuilder 에 의해 작성된 코루틴
- launch 는 Job을 리턴
- Job 을 통해 실행중인 코루틴을 제어
    ```kotlin
    fun main(): Unit = runBlocking {
        println(1)
    
        val job: Job = launch {
            delay(1000L)
            println(2)
        }
    
        job.join()
        println(3)
    // 출력 
    // 1
    // 2 
    // 3
    }
    ```
- join() 은 해당 코루틴내의 처리가 끝나는 것을 기다림
- cancle() 을 통해 코루틴 취소