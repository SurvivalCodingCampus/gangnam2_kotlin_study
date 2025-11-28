# 설계 원칙, 디자인 패턴

# 설계 원칙

## 응집도와 결합도

- 응집도 (Cohesion) : 모듈이 하나의 목적을 수행하는 요소들간의 연관성 척도
- 결합도 (Coupling) : 모듈이 다른 모듈에 의존하는 정도의 척도

## 응집도는 높게, 결합도는 낮게

- 높은 응집도 : 모듈이 하나의 특정 작업이나 기능에 집중
- 낮은 결합도 : 모듈이 서로 독립적으로 작동할 수 있을 때

## 좋은 코드를 위한 6가지 원칙

- DRY - Don’t Repeat Yourself : 같은 것을 몇번씩 반복하지 말라. 중복 코드가 있다면 메소드로 분리한다.
- PIE - Program Intently and Expressively : 명확하고 표현력 있게 기술하자. 애매한 이름 말고 확실히 알 수 잇게 사용하자
- SRP - Single Responsibility Principle : 클래스에 주어진 책임은 1개뿐. 단일 책임 원칙. 외부 객체는 생성자로 주입 받아라
- OCP - Open Closed Principle : 개방 폐쇄 원칙. 확장은 열려있고 변경에 대해서는 닫혀있다. 수정 없이 확장 가능하도록 하자
- SDP - Stable Dependencies Principle : 안전한 것에 의존하라. 인터페이스 의존하자
- ADP - Acyclic Dependencies Principle.

## SOLID 원칙

- SPR - Single Responsibility Principle: 한 클래스는 하나의 책임만 가진다.
- OCP - Open/Closed Principle : 원본 코드를 수정없이 새로운 기능을 추가할 수 있다.
- LSP - Liskov Substitution Principle : 리스코프 치환 원칙. is-a 원칙을 지켜라
- ISP - Interface Segregation Principle : 인터페이스 분리 원칙. 하나에 다 넣지 말고 여러개로 쪼개라
- DIP - Dependency Inversion Principle : 의존 관계 역전 원

# 디자인 패턴

## GoF의 23가지 디자인 패턴

- 생성 패턴
    - 추상 팩토리
    - 빌더 : StringBuilder 객체를 생성하고, append를 체이닝하여 데이터 추가
    - 팩토리메서드 : 물건을 만드는 곳(=체인:똑같음), 인스턴스를 만드는 패턴
    - 프로토타입
    - 싱글턴 : 인스턴스 생성을 여러번 시도해도 1개의 인스턴스가 공유됨
- 구조 패턴
    - 어댑터
    - 브리지
    - 컴퍼지트
    - 데커레이터 : 기존 객체에 새로운 기능을 겹겹이 덧붙이는 패턴. 커피에 우유 추가 → 시럽 추가 → 휘핑 추가
    - 퍼사드 : 복잡한 내부 시스템을 간단한 인터페이스 하나로 감싸는 패턴. 영화 보기 버튼 → 조명, 커튼, 음향 자동 제어
    - 플라이웨이트
    - 프록시
- 행위 패턴
    - 책임 연쇄
    - 커맨드
    - 인터프리터
    - 이터레이터 : 컬렉션 안에 있는 요소들을 순서대로 하나씩 꺼내며 탐색하는 패턴
    - 미디에이터
    - 메멘토
    - 옵서버 : 객체의 상태 변화를 관찰하는 관찰자들. 콜백 함수
    - 테이트
    - 스트래티지 : 런타임에 알고리즘을 동적으로 교체할 수 있도록
    - 템플릿 메서드
    - 비지터

# 아키텍쳐 디자인 패턴

- 소프트웨어를 작성함에 있어 코드 뿐만 아니라 전체적인 구조(Architecture)에 대한 좋은 패턴도 존재합니다.
