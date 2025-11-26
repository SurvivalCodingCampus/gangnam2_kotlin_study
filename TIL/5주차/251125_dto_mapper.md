## DTO, Mapper

### DTO (Data Transfer Object)

> 계층 간 데이터를 주고받기 위한 운반용 객체

- Controller ↔ Service ↔ Repository ↔ API ↔ Database
  같은 레이어 간 데이터를 옮기는 전용 객체
- 도메인 객체(Model)를 그대로 외부로 노출하지 않고, 외부에서 받아온 복잡하거나 깨진 JSON을 그대로 도메인에 넣지 않기 위해 중간에서 '완충 역할'을 하는 데이터 그릇

#### DTO가 필요한 이유

- 외부 데이터(JSON) 구조와 도메인 모델 구조를 분리하기 위해
    - API JSON 구조가 자주 바뀌는데 도메인 모델이 그 영향을 받으면 앱 전체가 흔들림
    - `API 구조 = DTO`, `앱 내부 구조 = Model` 로 분리해서 안정성 확보
- 잘못된 값이 들어오는 걸 막고 안정적으로 처리하기 위해
- 보안·캡슐화
    - Model 을 그대로 외부로 노출하면 불필요한 정보(예: 내부 id, 권한 정보 등)가 외부 API 응답에 노출될 수 있음

#### DTO 와 Model 차이

| 구분       | DTO                    | Model(도메인)            |
|----------|------------------------|-----------------------|
| 목적       | 데이터 전송용                | 비즈니스 로직, 앱 내부 상태      |
| 구조 안정성   | 외부 변화에 따라 자주 바뀜        | 안정적이어야 함              |
| 필드       | nullable 많음            | nullable 최소화          |
| 검증/보정    | 주로 DTO → Model 변환에서 처리 | Model은 무결성이 보장되어야 함   |
| 어디에서 사용? | API, Storage, JSON     | ViewModel, UI, Domain |

*`무결성`: 데이터가 “정상적이고 믿을 수 있는 상태를 유지하는 성질”

### Mapper

> DTO를 Model로 변환하거나, Model을 DTO로 변환하는 변환기(Translator) 역할을 하는 계층

#### Mapper 필요한 이유

- DTO는 무결성이 없다 → Model은 무결해야 한다
    ```kotlin
    data class Photo(
        val id: Int,              // Int 필수
        val type: PhotoType,      // null 불가
        val createdAt: LocalDate? // 파싱 실패 시 null
    )
    ```
    - DTO의 불완전성을 Model에서 정제해야 하는데 이 정제 로직을 Mapper가 담당
- DTO 구조와 Model 구조가 다르기 때문
    - DTO: 서버 JSON 구조에 맞춤
    - Model: 앱이 실제로 쓰는 구조
- Repository가 깔끔해짐
    - Repository는 데이터 소스를 다루는 계층인데 여기에 변환 로직이 섞이면 복잡해지고 테스트가 어려워짐

| 장점      | 설명                          |
|---------|-----------------------------|
| 무결성 유지  | DTO의 비정상 값을 Model에서 안전하게 처리 |
| 구조 분리   | 외부 API 변화가 Model에 영향을 주지 않음 |
| 테스트 용이  | Mapper만 따로 테스트 가능           |
| 재사용성 증가 | DTO → Model 변환 로직이 한 곳에 모임  |
