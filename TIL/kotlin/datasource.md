# DataSource 개념

## DataSource 란?

- 앱이 사용하는 원천 데이터
    - 마치 요리를 할 때 재료
    - 다양한 형태 : 파일, 텍스트, JSON, DB 등
- 앱은 단독으로 데이터를 만들어내지 않는다.
- 대부분의 앱은 외부에서 데이터를 받아와서 화면에 보여준다.

## DataSource의 역할

- 외부 데이터 저장소와 통신
- Raw 데이터 수신 및 처리
- CRUD 작업 수행

⇒ 즉, 데이터를 "가져오고", "정리해서", "보여주기 좋게 만드는" 역할

## DataSource의 종류

- Text (.txt 등)
- File (로컬 파일)
- JSON (웹 API에서 자주 사용)
- XML
- CSV (엑셀 같은 형식)
- RDBMS (MySQL, PostgreSQL 등 관계형 DB)
- NoSQL (MongoDB, Firebase Firestore 등)
- 등등

## 정리

- DataSource는 앱이 데이터를 가져오는 출발점
- 다양한 형태(JSON, CSV, DB 등)가 존재
- 데이터를 받아와서 객체로 변환하면 앱에서 쉽게 사용 가능

## 자주 나오는 질문

- JSON과 CSV의 차이점은?
    - 데이터 형식이 다르다.
- 왜 객체로 변환해야 하나요?
    - 편하게 사용하기 위해
- Impl이 붙은 클래스 이름은 무슨 의미인가요?
    - 구현체
