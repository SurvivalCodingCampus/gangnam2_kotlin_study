# Network

웹 개발을 하려면 어느정도의 네트워크는 알아야 한다. 요청, 응답을 하기 때문이다.

## HTTP(HyperText Transfer Protocol)
- HTTP Method를 이용해서 데이터 조회, 저장, 수정, 삭제 등을 할 수 있다.
- Stateless 프로토콜은 요청 후 연결이 끊는다. 상태 정보를 모르기 때문에 `Cookie`, `Session`으로 저장해서 사용하기도 한다. 이제는 `Token`을 많이 사용한다.

## OSI-7 계층
예전에도 봤지만 매번 까먹게 되는 OSI-7 계층이다...

- 1계층: Physical Layer 물리 계층
- 2계층: DataLink Layer 데이터 링크 계층
- 3계층: Network Layer 네트워크 계층
- 4계층: Transport Layer 전송 계층
- 5계층: Session Layer 세션 계층
- 6계층: Presentation Layer 표현 계층
- 7계층: Application Layer 응용 계층

## TCP/IP 4계층

- 1계층: Network Interface 네트워크 엑세스 계층
- 2계층: Internet 인터넷 계층
- 3계층: Transport Layer 전송 계층
- 4계층: Application Layer 응용 계층

## Socket
지금까지 WebSocket을 거의 사용해본 적이 없었던 것 같다. 그래서 학습을 거의 안해본 것 같다.

- 컴퓨터가 이해하기 쉽게 작성된 프로그램 or API
- TCP / UDP를 추상화한 개발자를 위한 API
- 프로토콜이 아니다
- OSI 7계층에 포함되지 않는다

## TCP
신뢰성 있는 연결지향성으로 이메일, 파일 전송, 웹브라우저 등에서 사용한다.

- Stateful 프로토콜
- 연결되면 끊기 전까지 계속 메시지를 주고 받는 프로토콜이다
- 한쪽에 문제가 생기면 다른쪽에서 감지가 가능하다
- 속도가 빠르다
- 신뢰성 있는 연결지향성으로 식별할 수 있는 식별자가 필요하다
- 응답을 알 수 없기 때문에 타임아웃에 대해 직접 구현해야 한다
- HTTP보다 빠르다

## UDP
신속한 데이터 전송이나 손실 가능성이 있는 상황에 주로 사용한다.
주로 실시간 서비스 스트리밍, 게임 등에서 사용한다.

- TCP와 반대로 신뢰성이 보장되지 않는 비연결형 프로토콜이다.
- 흐름 제어가 없다
- 멀티캐스팅 및 브로드캐스팅
