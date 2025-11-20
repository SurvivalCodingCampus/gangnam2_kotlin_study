## 테스트 이론

### Test Double

> 테스트를 진행하기 어려운 경우 테스트가 가능하도록 만들어주는 객체

- 참고 : https://tecoble.techcourse.co.kr/post/2020-09-19-what-is-test-double/

#### Mock 객체 활용

- Fake
    - 실제처럼 작동하는 간단한 대체 구현체
    - 실제 데이터 대신 고정된 mock 데이터를 반환함
- Stub
    - 정해진 값만 반환하는 단순한 객체
    - 로직은 없고, 호출 → 값 반환 형태
    - 예: “getUsers() 호출하면 항상 빈 리스트 반환해라”
- Mock
    - 행동을 검증하는 객체
    - 특정 메서드가 몇 번 호출되었는지, 어떤 값으로 호출되었는지 검사함
    - MockK, Mockito 같은 라이브러리를 사용해서 자동 생성
- Spy
    - 실제 객체를 감싸서 일부는 진짜 동작, 일부는 mock 동작
    - 사용 빈도 낮음

#### Fake와 Mock 이 활용되는 곳

- Fake(MockXXXDataSourceImpl)
- 구조가 실제 API랑 동일한지 미리 확인
    - 특정 데이터 패턴이 필요한 테스트 준비에 좋음
    - 반복되는 JSON 디코딩 없이 빠르게 테스트 가능
- Mock(MockK)
- Repository 로직만 검증하고 싶을 때 유용
    - 다양한 시나리오(0개, 1개, 100개 등) 쉽게 시뮬레이션 가능
    - Fake를 건드리지 않고도 상황을 마음대로 만들 수 있음