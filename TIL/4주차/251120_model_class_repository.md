## Model Class, Repository 개념

### Model Class 의 책임과 역할

- 모델 객체 클래스의 속성에 대한 데이터를 조회할 수 있는 클래스
- 별도의 기능을 가지지 않는 순수한 클래스
- 데이터소스로 부터 받은 데이터를 앱에서 필요한 형태로 변환하여 앱 개발을 편리하게 해 주는 역할

#### 모델링 방법

> DDD (Domain Driven Design) / ORM (Object-relational mapping)

### Repository 패턴

> Repository = 도메인 데이터를 관리하는 “저장소 역할”을 하는 추상 계층 <br/>
> 비즈니스 로직에서 데이터가 “어디서 오는지”를 모르게 하여 의존성을 분리하는 패턴

#### Repository가 필요한 이유

- 데이터 소스 변경에 대한 유연성
    - `API → DB → 캐시 → 파일` 등 언제든 교체 가능
    - 개발 초반에는 `MockDataSourceImpl`
    - 나중에는 `ApiDataSourceImpl`
    - 캐싱이 필요하면 `CacheDataSourceImpl`
        - Repository는 변경 없이 그대로 사용 가능
- 테스트 용이성 (Testability ↑)
    - ViewModel이나 UseCase 테스트할 때 Repository만 MockK로 대체
    - API 통신 없어도 테스트 가능
    - 네트워크 느림/오류 걱정 없음
    - FakeDataSource와 MockK를 모두 쉽게 주입 가능
        - **Repository를 인터페이스로 만들어야 하는 가장 큰 이유**
- 비즈니스 로직의 중복 제거

- 데이터 소스에서 가져온 데이터를 필터링/정렬/변환하는 로직을 **중앙 집중화** 가능.
    - "완료된 Todo만 보여줘"
    - "username으로 정렬한 상위 10명만 반환"
    - "특정 postId의 댓글만 가져오기"
    - 이런 로직은 DataSource가 하는 일이 아님 → Repository가 담당.
- Presentation Layer(뷰/뷰모델)와 Data Layer 분리
    - ViewModel은 데이터가 API에서 오는지, 파일에서 오는지, 캐시에서 오는지 전혀 모름.
        - **ViewModel**: "Repository야, 유저 목록 줘"
        - **Repository**: "오케이, DataSource로부터 알아서 가져와서 정렬도 해줄게"
    - 관심사 분리(Separation of Concerns) 완성

#### Repository – DataSource 구조

- 일반적으로 아래 구조를 사용
    ```
    Presentation
       ↓
    Repository  ← 비즈니스 로직(정렬/필터링/합치기)
       ↓
    DataSource  ← 실제 데이터 접근(API/DB/File)
    
    ```

#### Repository와 DataSource의 역할 차이

| 계층             | 역할                                 |
|----------------|------------------------------------|
| **DataSource** | 실제 데이터 접근 (API, DB, 파일)            |
| **Repository** | 비즈니스 로직, 데이터 가공, 여러 DataSource 합치기 |

#### DataSource

- API 호출해서 JSON 파싱해오기
- 파일 읽기
- DB에서 SELECT

#### Repository

- `postId = 1`인 댓글만 골라내기
- username으로 정렬 후 10개만 잘라내기
- 캐시 + API + DB 조합해서 최종 데이터 반환

#### Repository가 인터페이스여야 하는 이유

- Fake 구현체 주입 가능
    ```
    MockUserDataSourceImpl → 실제 API 필요 없이 테스트 가능
    
    ```
- MockK로 Repository를 쉽게 대체 가능
    ```
    mockk<UserRepository>() → 원하는 응답 시뮬레이션 가능
    
    ```
- DI(의존성 주입) 구조에 잘 맞음

#### Repository 사용 장점

- 테스트 코드 작성이 쉬워짐
    - MockK 또는 FakeDataSource로 데이터 조작 가능
- API/DB 교체가 쉬움
    - Presentation/UseCase 코드 전혀 변경 없음
- 유지보수성 증가
    - 비즈니스 로직이 한 곳에 모여 있음.
- 구조가 깔끔해지고 역할이 명확해짐
    - 각 레이어가 할 일만 한다

#### Repository 사용시 주의

- Repository는 어떤 데이터를 전달할지에 집중
- Repository는 직접적인 데이터 조작이 아닌 필요한 데이터를 골라내는 일을 할 것
- 저장 매체를 다루는 코드는 DataSource 에서 하도록
- 복잡한 비즈니스 로직은 더 상위 계층으로

#### Repository 잘못된 사용 예시

```kotlin
//    (이건 사실 Repository가 아니라 DataSource)

class UserRepository {   // ← 잘못된 이름
    private val filePath = "users.txt"

    fun getUser(id: String): User? {
        return File(filePath).readLines()   // ← 데이터 소스 구현(파일 IO)
            .map { it.split(",") }
            .find { it[0] == id }
            ?.let { User(it[0], it[1]) }
    }
}
```