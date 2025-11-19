# 2025-11-18 TIL

## 오늘 배운 내용의 핵심 키워드 : 비동기 프로그래밍, 코루틴
---

## 1. 오늘 배운 것

### 비동기 프로그래밍

* 동기 vs 비동기 : 동기는 한 작업이 끝날 때 까지 기다렸다가 다음 작업을 시작하는 방식이고 비동기는 한 작업이 끝날 때 까지 기다리지 않고 다른 작업을 시작하는 방식
* 동시성 vs 병렬성 : 동시성은 여러 작업을 번갈아가면서 처리하는 것으로 동시에 처리되는 것 처럼 보이는 것이고 병렬성은 여러 작업을 실제로 동시에 처리하는 것으로 물리적으로 동시에 처리하는 것이다. (멀티코어)
* 비동기를 처리하는 방법에는 java의 Thread, 콜백, Future, kotlin의 Coroutine이 있다.

### 코루틴

* 단일 Thread의 문제점 : 모든 인스턴스는 main 스레드에서 생성되며 처리되고 Thread를 block하는 동안 프로그램이 멈춤
* 코루틴을 사용하면 Thread를 블록시키지 않고 비동기를 처리할 수 있다.
* 코루틴은 suspend와 resume을 통해 스레드를 양보하는 방식으로 비동기 코드를 순차적으로 만듦
* 코루틴은 무엇보다도 스레드를 직접 건들지 않기 때문에 데드락과 같은 문제를 예방할 수 있고 휴먼에러를 최소화 시킬 수 있다.

### 코루틴 활용

* 코루틴은 코루틴 scope내에서만 사용 가능하다

```kotlin
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}
```

* 코루틴 빌더는 새로운 코루틴을 시작하는 함수를 말한다. runBlocking, withContext, launch, async 등이 있다.
* launch : 결과가 필요없는 비동기 작업을 처리할 때 사용되고 job객체를 반환하여 이 job을 이용하여 코루틴을 컨트롤 할 수 있다.

```kotlin
fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("Hello World!")
    }
}
```

* async : 결과가 필요한 비동기 작업을 처리할 때 사용되고 Deferred객체를 반환하여 Deferred객체를 통해 결과값을 제공 받을 수 있다.

```kotlin
fun main() = runBlocking {
    val result = async {
        delay(1000L)
        return@async "Hello world"
    }
    println(result.await()) //Hello world
}
```

* runBlocking : 코루틴과 일반 코드를 연결하는 코드로 Kotlin하는 동안에만 사용, Unit Test에서도 사용

```kotlin
fun main() = runBlocking {
    //코루틴 scope
}
```

* delay : 코루틴을 ms단위로 일시정지하는 일시정지 함수(suspend function)

```kotlin
fun main() = runBlocking {
    launch {
        delay(1000L) //1000ms(1초)간 대기
    }
}
```

* 코루틴의 수명은 runBlocking이나 launch와 같은 CoroutineScope 내에서 결정된다.
* 코루틴은 기본적으로 순차 실행이다.

```kotlin
fun main() = runBlocking {
    val time = measureTimeMillis {
        val test1 = coroutineTest1()
        val test2 = coroutineTest2()
    }
    println(time)

}

suspend fun coroutineTest1(): Int {
    delay(1000L)
    return 1
}

suspend fun coroutineTest2(): Int {
    delay(1000L)
    return 2
}
```

* 코루틴을 병렬로 실행시키려면 async 코루틴 빌더와 await함수를 활용하면 된다.

```kotlin
fun main() = runBlocking {
    val time = measureTimeMillis {
        val deferred1 = async {
            coroutineTest1()
        }
        val deferred2 = async {
            coroutineTest2()
        }
        val test1 = deferred1.await()
        val test2 = deferred2.await()
    }
    println(time)
}

suspend fun coroutineTest1(): Int {
    delay(1000L)
    return 1
}

suspend fun coroutineTest2(): Int {
    delay(1000L)
    return 2
}
```

* job은 실행중인 코루틴을 제어할 수 있는 객체이다.
* join()을 통해 코루틴내의 처리가 끝나는 것을 기다릴 수 있고, cancel을 통해 코루틴을 취소할 수도 있다.

```kotlin
fun main(): Unit = runBlocking {
    val job = launch {
        repeat(3) {
            coroutineTest()
        }
    }
    launch {
        delay(2000L)
        job.cancel()
        println("코루틴 취소")
    }
}

suspend fun coroutineTest() {
    delay(1000L)
    println("CoroutineTest 실행")
}
```

* Dispatcher : 코루틴이 어떤 스케쥴러에 의해 수행될지를 지정할 수 있다.
* Dispatcher의 종류는 Default, Main, IO, Unconfied가 있다.

  | 디스패처 | 스레드 유형 | 주요 특징 | 사용 목적 |
  | :---: | :---: | :---: | :---: |
  | **`Dispatchers.Default`** | 백그라운드 스레드 풀 | 🔹 **CPU 코어 수**에 비례하여 스레드를 생성합니다. (연산용) | CPU에 부하를 줄 만한 **연산 집약적** 처리 (예: 큰 `List` 정렬, JSON 파싱, 복잡한 알고리즘 실행 등) |
  | **`Dispatchers.Main`** | 메인 스레드 | 🔹 **메인(UI) 스레드**에 연결되는 디스패처입니다. | UI 업데이트, UI 관련 이벤트 처리 등 **메인 스레드**에서만 실행되어야 하는 작업 |
  | **`Dispatchers.IO`** | 백그라운드 스레드 풀 | 🔹 상대적으로 많은 수의 스레드를 생성합니다. | **Input/Output 조작**에 최적화된 작업 (예: 네트워크 통신, 파일 읽고 쓰기, DB 접근 등) |
  | **`Dispatchers.Unconfined`** | 특정 스레드 없음 | 🔹 코루틴이 시작된 스레드에서 실행되지만, 일시 중단 후 재개 시에는 어떤 스레드가 될지 한정하지 않습니다. | 공식 문서에서는 **특정 상황** (예: 테스트 코드) 외에는 보통 사용하지 않도록 명시하고 있습니다. |

* withContext()로 Dispatcher를 전환할 수 있다.

```kotlin
fun main(): Unit = runBlocking {
    launch {
        coroutineTest1()
    }

    launch {
        coroutineTest2()
    }
}

suspend fun coroutineTest1() {
    withContext(Dispatchers.IO) {
        delay(1000L)
        println("CoroutineTest1를 IO디스패쳐에서 실행")
        println(Thread.currentThread())
    }
}

suspend fun coroutineTest2() {
    delay(2000L)
    println("CoroutineTest2를 그냥 실행")
    println(Thread.currentThread())
}
/* 실행결과
CoroutineTest1를 IO디스패쳐에서 실행
Thread[#22,DefaultDispatcher-worker-1,5,main]
CoroutineTest2를 그냥 실행
Thread[#1,main,5,main]
*/
```

## 2. 오늘 발생한 문제

* 없습니다.

## 3. 몰랐었던 내용


* 코루틴 개념에 대해 모호했었는데 이번 기회에 개념을 확립한 것 같습니다. 

