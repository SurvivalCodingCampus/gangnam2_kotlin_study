# Result 패턴

## 서버에 데이터 요청시 예상되는 상황

- 성공 (Success)
- 실패 (Error, Failure) : 실패의 종류가 하나가 아님
    - 네트워크 연결이 아예 안 되어 있음
    - 네트워크 불안정으로 타임아웃 발생
    - 논리적으로 잘못된 값
    - 그냥 내가 판단했을 때 에러임
    - 등등

## 에러처리의 기본 try - catch

- 기본적으로 예외는 try - catch 를 활용하여 처리 한다.
- 런타임 에러 뿐만 아니라 논리적인 오류나 예외 상황에 대한 처리를 하기에는 부족하다.
- Result 패턴은 성공, 실패시 처리에 유용한 패턴이다.

## Result 패턴 사용시 효과

- enum 과 동일하게 when 과 조합하여 모든 처리를 강제할 수 있다
- 성공과 실패를 처리할 수 있다

```kotlin
val repository = TodoRepository()

val result = repository.getTodo(1)

when (result) {
    is Result.Error -> TODO()
    is Result.Success -> TODO()
}
```

## Result 클래스

```kotlin
sealed class Result<out D, out E> {
    data class Success<out D>(val data: D) : Result<D, Nothing>()
    data class Error<out E>(val error: E) : Result<Nothing, E>()
}
```

## Result 패턴 사용시 장점

1. 타입 안전성 향상

```kotlin
sealed class Result<out D, out E> {
    data class Success<out D>(val data: D) : Result<D, Nothing>()
    data class Error<out E>(val error: E) : Result<Nothing, E>()
}

// 성공이면 T, 실패면 E만 보이니까 Nullable 필요 x
fun getUser(): Result<User, NetworkError> = TODO()
```

2. 에러 처리 강제성 (컴파일러가 모든 케이스 처리를 강제함)

```kotlin
when (val result = getUser()) {
    is Result.Success -> showUser(result.data)
    is Result.Error -> showError(result.error) // 둘 다 안 쓰면 컴파일러가 경고/에러
}
```

3. 에러 타입의 명확한 문서화

```kotlin
sealed class NetworkError {
    object NetworkUnavailable : NetworkError()
    object Timeout : NetworkError()
    data class HttpError(val code: Int) : NetworkError()
}

interface UserRepository {
    suspend fun getUser(id: String): Result<User, NetworkError>
    // 시그니처만 봐도 어떤 에러가 오는지 알 수 있음
}
```

4. try - catch 남용 방지

```kotlin
// Repository 안에서만 try-catch
override suspend fun getUser(id: String): Result<User, NetworkError> =
    try {
        val dto = api.getUser(id)
        Result.Success(dto.toDomain())
    } catch (e: IOException) {
        Result.Error(NetworkError.NetworkUnavailable)
    } catch (e: SocketTimeoutException) {
        Result.Error(NetworkError.Timeout)
    }

// 호출부는 when 만 사용
when (val result = userRepository.getUser("123")) {
}
```

5. 비즈니스 로직과 에러 처리 분기

```kotlin
// Domain / Repository 쪽: 비즈니스 + 매핑
suspend fun login(id: String, pw: String): Result<User, LoginError> = TODO()

// UI 쪽: 에러 -> 메시지/상태 매핑
when (val result = login(id, pw)) {
    is Result.Success -> uiState = UiState.LoggedIn(result.data)
    is Result.Error -> uiState = UiState.Error(toMessage(result.error))
}
```

6. Nullable 타입 사용 감소

```kotlin
// 나쁜 예: User? + null이면 에러
fun findUserBad(id: String): User? = TODO()

// 좋은 예: 성공/실패를 분리
fun findUser(id: String): Result<User, UserError> = TODO()

when (val result = findUser("123")) {
    is Result.Success -> {
        val user: User = result.data // non-null
    }
    is Result.Error -> {}
}
```

7. 테스트 용이성

```kotlin
@Test
fun `login 성공 시 홈으로 이동`() {
    val fakeRepo = object : UserRepository {
        override suspend fun getUser(id: String) =
            Result.Success(User(id = "123", name = "Test"))
    }
}
```

8. 패턴 매칭을 통한 가독성 향상

```kotlin
fun toErrorMessage(error: NetworkError): String =
    when (error) {
        NetworkError.NetworkUnavailbale -> "네트워크를 확인해 주세요."
        NetworkError.Timeout -> "요청 시간이 초과되었습니다."
        is NetworkError.HttpError -> "서버 오류 (${error.code}) 가 발생했습니다."
    }

// Result + when 조합으로 "성공/실패 + 세부 에러"를 한 눈에
when (val result = repo.getPhotos()) {
    is Result.Success -> showPhotos(result.data)
    is Result.Error -> showToast(toErrorMessage(result.error))
}
```
