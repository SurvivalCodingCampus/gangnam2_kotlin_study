# Dto, Mapper

DTO는 있어도 되고 없어도 되지만 서버의 데이터를 믿지 못한다.

## DTO (Data Transfer Object)

- 잘못된 데이터를 안전하게 받아서 처리할 곳이 필요하다
- DTO : 데이터 소스를 모델 클래스로 변환하는 과정에서 **순수**하게 클래스에 담기 위한 중간 전달 객체
- Json → DTO → Model Class
- 잘못된 데이터 소스 (Json)를 받더라도 안 터지게 하려는 클라이언트 개발자의 방어 수단

### DTO 만드는 방법

1. 모든 필드를 Nullable로 하고 직렬화되게
2. Json 을 받아들이기 편한 플러그인 사용

## DTO를 모델 클래스로 변환

- 순수한 데이터 소스 (DTO) 를 원하는 모델 클래스로 변환하기 위한 로직은 별도의 mapper 를 통해 변환 함
- Json → DTO → mapper → Model Class

### DTO를 모델로 변경했을 때의 장점

- Boolean 필드는 is 접두어 사용 (코틀린 컨벤션)
- Nullable 타입(?) 제거로 안전성 향상
- 도메인 모델은 순수 코틀린 타입 사용

### Mapper 코드 예시

```kotlin
// TodoMapper.kt
fun TodoDto.toTodo(): Todo {
    return Todo(
        userId = userId ?: 0,
        id = id ?: 0,
        title = title ?: "제목 없음",
        isCompleted = completed ?: false,
    )
}
```

맵퍼는 Dto 를 모델 클래스로 변환하는 유틸 메소드이다.
확장함수 활용 추천
Nullable 을 **non-Nullable**로 변환하는 것이 핵심 => 왜? 내가 사용하기 편하니까
Dto 전체를 변환하는 것이 아니다. **필요한 부분**만 변환하는 것이다.

### Mapper 작성시 extension을 선호하는 이유

- DTO 는 자동으로 만들고 수정하지 않는다 (무지성, 다른 코드 개입 no, 실수 방지)
- mapper 는 복잡한 로직이 포함될 수 있어서 인간이 작성, 문제 있으면 여기만 살핀다
- DTO와 mapper 코드를 분리

### 추천 폴더 구조

Json → DTO → Mapper를 활용하여 모델 클래스로 변환 → 모델 클래스

```text
- data_source
  - TodoDataSource.kt
- dto
  - TodoDto.kt
- mapper
  - TodoMapper.kt
- model
  - Todo.kt
- repository
  - TodoRepository.kt
```

## DTO가 필요한 이유

- Model Class 는 non-nullable 값만 가지고 있도록 한다
- Json 데이터는 null 값을 포함할 수 있음 (문서에 명시되어 있지 않더라도…)
- Map -> Model Class 변환시 null 값 등의 예외를 사전에 걸러내기 용이함
- 불완전한 코드가 포함될 것 같다면 DTO를 도입하자
- Json 값에 예외가 없다면 반드시 DTO를 도입할 필요는 없다
