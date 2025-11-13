# 예외(Exception)

코틀린의 모든 예외 클래스는 최상위 예외 클래스인 Throwable을 상속합니다. 예외는 크게 두 가지로 나뉩니다.

- Error: 시스템에 비정상적인 상황이 발생했을 경우이며 예측이 어렵고 복구가 불가능합니다.
- Exception: 시스템에서 포착 가능하여(try-catch) 복구 가능한 예외입니다.

```kotlin
try {
    // 예외가 발생할 수 있는 코드
} catch (e: NumberFormatException) {
    // 특정 예외 처리
} catch (e: Exception) {
    // 일반 예외 처리
} finally {
    // 항상 실행되는 코드
}

```

