# DataSource 개념

### DataSource 란?

- 앱이 사용하는 원천 데이터
    - 마치 요리를 할 때 재료
    - 다양한 형태: 파일, 텍스트, JSON, DB 등
- 앱은 단독으로 데이터를 만들어내지 않는다.
- 대부분의 앱은 외부에서 데이터를 받아와서 화면에 보여준다.

### Impl 접미사를 사용하는 이름 관례

- Impl 접미사는 보통 **어떤 인터페이스의 구체 구현 클래스** 라는 것을 표시하기 위해 붙이는 이름 관례입니다.
- `SomethingImpl` 이라는 이름은 “`Something` 인터페이스의 구현체(implementation)”라는 의미로 쓰입니다.
    - 예:
        - `UserRepository` (인터페이스)
        - `UserRepositoryImpl` (구현 클래스)
- 코드에서 `Impl`을 보면 “이건 딱히 특별한 의미를 갖는 도메인 객체라기보다는, 인터페이스를 만족시키기 위한 구현체”라는 신호가 됩니다.

```kotlin
  interface OrderService {
    fun placeOrder(...)
}

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {
    override fun placeOrder(...) {
        ...
    }
}
  ```

### JSON과 CSV의 차이점은?

CSV는 **Comma-Separated Values** 의 약자입니다.  
JSON은 **JavaScript Object Notation** 의 약자입니다.

| 구분      | JSON                                  | CSV                                   |
|---------|---------------------------------------|---------------------------------------|
| 풀네임     | JavaScript Object Notation            | Comma-Separated Values                |
| 데이터 구조  | 계층적 구조 (객체·배열 중첩 가능)                  | 2차원 테이블(행·열) 구조                       |
| 표현 방식   | 키–값 쌍, 중괄호/대괄호 사용                     | 쉼표로 컬럼 구분, 줄 단위로 행 표현                 |
| 적합한 데이터 | 중첩·복잡한 도메인 모델, API 응답                 | 단순 표 형태 데이터, 통계·로그·리포트                |
| 타입 표현   | 문자열, 숫자, 불리언, null, 객체, 배열 등 타입 구분 가능 | 기본적으로 모두 문자열로 저장, 타입은 읽는 쪽에서 해석       |
| 인간 가독성  | 구조가 보이고 이해하기 쉬움(포매팅 시)                | 간단하면 쉽지만, 컬럼/행 많으면 가독성 떨어짐            |
| 파일 크기   | 메타 정보(키 이름) 때문에 비교적 큼                 | 같은 내용 기준 더 작음                         |
| 파싱 난이도  | 구조 파싱 필요하지만 라이브러리 풍부                  | 규칙이 단순, 빠르게 읽기 쉬움                     |
| 도구 호환   | 웹/모바일/백엔드 언어 대부분에서 기본 지원              | 엑셀, 구글 시트, 통계/BI 도구와 호환 매우 좋음         |
| 대표 사용처  | REST API, 설정 파일, NoSQL 저장, 앱 간 데이터 교환 | 데이터 분석, 엑셀 파일 교환, DB 일괄 import/export |

