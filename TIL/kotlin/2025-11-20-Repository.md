# Model Class, Repository

### Model Class 의 책임과 역할

- 모델 객체 클래스의 속성에 대한 데이터를 조회할 수 있는 클래스
- 별도의 기능을 가지지 않는 순수한 클래스
- 데이터소스로 부터 받은 데이터를 앱에서 필요한 형태로 변환하여 앱 개발을 편리하게 해 주는 역할

모델 클래스는 대부분 `data class`로 만든다.

```kotlin
data class User(
    val id: Long,
    val name: String,
    val email: String,
)
```

`data class`를 쓰면 컴파일러가 자동으로 아래를 만들어 준다.

- `equals` / `hashCode`
- `toString`
- `copy`
- `componentN` (구조 분해 선언에 사용)

그래서 모델 클래스를 쓸 때 장점은:

- 값 기반 비교가 자동(`u1 == u2` → 속성 값이 같으면 true)
- 디버깅에 좋은 `toString` 자동
- `copy`로 일부 값만 바꾼 새 객체 만들기 쉬움
- 구조 분해로 코드 간결화

```kotlin
val user = User(1, "Kim", "kim@test.com")

val newUser = user.copy(name = "Lee")

val (id, name, email) = newUser
```

### Repository 패턴

Repository 패턴은 소프트웨어 개발에서 데이터 저장소에 접근하는 객체를 추상화하고,
데이터소스(DB, File 등) 와의 통신을 담당하는 객체를 캡슐화하는 디자인 패턴이다.

### Repository 의 책임과 역할

- 데이터 접근의 진입점
- 데이터 접근에 대한 추상화 계층
- 데이터 소스 은익
- 비즈니스 로직과 데이터 소스 사이의 중재자
- 데이터 매핑, 변환 담당

### Repository 패턴의 이점

- 데이터 접근 추상화
    - 데이터 소스 구현 세부사항 은닉
    - 일관된 인터페이스 제공
- 유지보수성 향상
    - 관심사 분리
    - 코드 재사용성
- 테스트 용이성
    - 데이터 소스 Mocking 가능
    - 단위 테스트 작성 용이
- 확장성
    - 새로운 데이터 소스 추가 용이
    - 기존 코드 수정 최소화
    - 인터페이스 기반 설계

```text
src/
└── main/
    └── kotlin/
        ├── data_source/
        │   ├── local/
        │   │   ├── AlbumLocalDataSourceImpl.kt
        │   │   └── UserLocalDataSourceImpl.kt
        │   ├── remote/
        │   │   ├── AlbumRemoteDataSourceImpl.kt
        │   │   └── UserRemoteDataSourceImpl.kt
        │   ├── AlbumDataSource.kt   // 인터페이스
        │   └── UserDataSource.kt    // 인터페이스
        │
        ├── repository/
        │   ├── AlbumRepository.kt           // 인터페이스
        │   ├── AlbumRepositoryImpl.kt       // 구현체
        │   ├── UserRepository.kt            // 인터페이스
        │   └── UserRepositoryImpl.kt        // 구현체
        │
        └── model/
            ├── Album.kt    // 모델 객체
            └── User.kt     // 모델 객체

```
