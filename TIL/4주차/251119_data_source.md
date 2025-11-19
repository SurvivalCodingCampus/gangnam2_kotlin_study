## DataSource 개념

### DataSource 역할

- 외부 데이터 저장소와 통신
- Raw 데이터 수신 및 처리
- CRUD 작업 수행

> 데이터를 “가져오고", “정리해서", “보여주기 좋게 만드는" 역할

#### 데이터 흐름

> DB → Raw 데이터 추출 → Json 파싱 → 앱에서 사용 <br/>
> DB (파일) → JSON → Kotlin 객체 → UI

#### DataSource = 인터페이스(계약, 추상화)

> 이런 기능이 있어야 한다'만 적어둔 인터페이스

- 형태만 규정하고 구현은 하지 않는 역할
    ```kotlin
    interface StockDataSource {
        suspend fun getStockListings(): List<StockListing>
    }
    ```

#### DataSourceImpl = 실제 구현체(implementation)

> 인터페이스를 실제로 구현하여 ‘진짜 동작’을 담당하는 클래스

- 진짜로 CSV 읽고 JSON 파싱하고 LocalDate 변환하는 등의 구체적 "행동"이 들어감
    ```kotlin
    class StockDataSourceImpl : StockDataSource {
        override suspend fun getStockListings(): List<StockListing> {
            // 여기서 실제로 파일 읽기, DB 조회, API 호출 등을 수행
        }
    }
    ```

#### 디렉토리 구조

```text
/data_source
    ├─ TodoDataSource.kt
    └─ TodoDataSourceImpl.kt

/model
    └─ Todo.kt
```

### CSV 조작 헷갈렸던 점

- CSV는 줄 단위 파싱이 목적이므로 readLines()가 훨씬 자연스럽고 일반적
- kotlinx.serialization 은 CSV 포맷을 지원하지 않음
    - 직접 split 하거나 라이브 러리 사용
- drop(1)은 리스트에서 처음 요소를 제거하는 함수
    - 0 부터 시작이 아님
- Json에서 null 은 진짜 null 이지만 CSV 에서는 "null" 이라는 문자열이 들어옴
    ```kotlin
    if (parts[5] == "null") null else LocalDate.parse(parts[5])
    ```
