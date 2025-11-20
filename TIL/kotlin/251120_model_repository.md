# Test 이론
Spring Boot 프로젝트에서 테스트 코드를 구현할 때 `Mock`, `Stub`로 많이 사용했었는데 `Spy` 등은 사용한 적이 없었고, 필요성을 느끼진 못했다.

외부 API는 `Mock`, `Stub`을 사용해 로직 테스트에 초첨을 맞춰서 사용하고는 했었다.

# Model Class
Spring으로 했었을 땐 `Entity`, `DTO` 등으로 사용했고, 멤버변수를 사용하는 동작은 해당 클래스의 기능에 정의했었다.  
이런 얘기도 많이 있었다. "해당 객체에 메시지를 보내라" 대충 기능들을 객체에 구현하라는 얘기였다.

코틀린에서 `Model`은 별도의 기능을 가지지 않는 순수한 클래스로 사용한다고 한다.  
클래스의 속성에 대한 데이터를 조회만 하는 클래스로 사용한다.

# Repository 패턴
마찬가지로 Spring 프로젝트에서는 **Layered Architecture**를 많이 사용하는 것 같다.  
**Presentation Layer**는 클라이언트와 직접적으로 연결되는 부분으로 `Controller`로 사용했고,  
**Business Layer**는 비즈니스 로직을 담당해 `Service`,  `Persistence Layer`는 데이터 관리를 담당해 `Repository`로 사용했었다.

이게 무족건 이렇다 정해진건 아니지만, 관례로? 사용되는 것 같다.
