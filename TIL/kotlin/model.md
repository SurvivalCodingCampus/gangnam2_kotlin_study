# Model

## Model Class의 책임과 역할

- 모델 객체 클래스의 속성에 대한 데이터를 조회할 수 있는 클래스
- 별도의 기능을 가지지 않는 순수한 클래스
- 데이터소스로 부터 받은 데이터를 앱에서 필요한 형태로 변환하여 앱 개발을 편리하게 해 주는 역할

## Model Class

```kotlin
data class User(
    val name: String,
    val email: String,
)
```

- View에 보여질 데이터를 담는 객체
    - View == 눈에 보이는 부분
- 비슷한 용어들
    - 도메인 모델
    - Entity
    - DTO
    - POJO
    - VO
    - 데이터 클래스 (4종 세트) equals(), hashCode(), toString(), copy()

## 모델링 방법

- DDD (Domain Driven Design)
- ORM (Object-relational mapping)

### DDD (Domain Driven Design)

- Domain 의 정의
    - 유사한 업무의 집합
    - 특정 상황(주문, 결재, 로그인)이나 특정 객체(유저, 손님)가 중심이 될 수 있음
- 모델 클래스
    - 도메인을 data 클래스로 작성한 것

### ORM (Object-relational mapping)

- ORM 의 정의
    - 데이터 소스가 DB 인 경우 DB 와 모델간 상호 변환을 도와주는 기법
    - ORM은 DB 를 활용할 경우에 따로 살펴봐도 됨
    - 지금은 이런게 있네 하고 넘어가자
