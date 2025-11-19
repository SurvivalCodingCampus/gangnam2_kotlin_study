# DataSource 개념

아키텍쳐, 설계원칙

## 전 날 리뷰

- 돌아가고 있다면 손대지말고 놔두기.
- delay() 테스트를 하려고 한다면 코틀린 코루틴 테스트 라이브러리가 있다. 런블러킹 대싱 런테스트를 사용하면 딜레이가 스킵된다.
https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-test/
``` kotlin
main() : Unit // Unit 넣어주기
```
- 1차는 순차실행 너무 느리면 병렬 고민
- 서스펜드 : 딜레이 같이 간다.
- 기본으로 도는 쓰레드 : 메인쓰레드 , 오래 걸리는 동작 : 백그라운드 쓰레드
- data : 이퀄스 투스트링 해쉬코드 카피  . 카피 너무 중요하다

# DataSource란?

- 앱이 사용하는 원천 데이터 : 요리할 때 재료
    - 다양한 형태 : 파일. 텍스트, JSON, DB 등
- 앱은 단독으로 데이터를 만들어내지 않는다.
- 대부분의 앱은 외부에서 데이터를 받아와서 화면에 보여준다.

```kotlin
DataSource = 편의점, 마트, 창고
- 각각에서 물건을 직접 가져옴
- 실제 저장소 접근

Repository = 장보기 대행 서비스
- 상황에 맞게 다양한 곳을 조합
- 데이터 취합,로직,정책 제공
```

# DataSource의 역할

- 외부 데이터 저장소와 통신 : 서버(API), 데이터베이스(DB), 파일 같은 실제 저장소와 직접 연결되는 계층
- Raw 데이터 수신 및 처리 : 원본 데이터를 그대로 받아서 필요한 형태로 1차 가공
- CRUD 작업 수행

⇒ 실제 저장소에서 Raw 데이터를 가져오고, 앱이 사용할 수 있도록 최소한의 형태로 정리하는 계층

# DataSource의 종류

- Text (.txt)
- File (로컬 파일)
- JSON (웹 API에서 자주 사용)
- XML
- CSV (엑셀 같은 형식)
- RDBMS (MySQL, PostgreSQL 등 관계형 DB)
- NoSQL (MongoDB, Firebase Firestore 등)

## 예시 1 도서관 앱

- 도서관 책 관리 프로그램 예시
    - 데이터 소스 : 도서 DB
    - 앱에서 하는 일 : 책 제목, 저자 정보 받아오기
    - 화면에 보여주는 것 : 책 목록, 검색 결과 등

## 예시 2 메모장 앱

- 간단한 메모장 앱 예시
    - 저장 : 로컬 JSON 파일에 메모 저장
    - 불러오기 : 앱 실행시파일 읽어서 메모 리스트 작성
    - 출력 : 화면에 메모 목록 보여줌

# DataSource 이름 짓기

- 접두어로 저장소 유형 표시
- 구현 기술이 명확할 경우 해당 이름 사용
1. FileUserDataSource VS DatabaseUserDataSource
2. NetworkUserDataSource VS RemoteUserDataSource
- Impl 접미사를 사용하는 이름 관례
    - 구현체임을 명확히 표시
    - 인터페이스와 구현체 구분 용이
    - 많은 기업/프로젝트에서 채택하는 관례