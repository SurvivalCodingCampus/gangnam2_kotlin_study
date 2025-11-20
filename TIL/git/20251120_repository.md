# Architecture

## 오늘 배운것

과제 리뷰
- use() 메소드는 closeable interface 구현체를 사용하고 있는것들에서만 사용할 수 있다
- toon 포맷이 뜨고 있다(인공지능이 이해하기 쉬운 포맷이라고함)

개념
- 테스트 이론 
    - 좋은 Unit Test의 6가지 조건
      - Fast (빠르고)
      - Reliable (믿을 수 있고)
      - Independent (독립적인)
      - Ease of Maintenance (유지 관리가 쉽고)
      - Nearly compacted code (거의 압축적인 코드)
      - Dependencies should be less (의존성이 적어야 한다)

- 테스트 Double 에는 여러가지가 있지만 전부 다 통틀어서 Mocks로 친다
- Repository
    - 불러온 데이터들을 가공해서 전달하는 역할
    - 당근: Model
    - 당근을 가져오는것: DataSource
    - 당근을 가공하는것: Repository