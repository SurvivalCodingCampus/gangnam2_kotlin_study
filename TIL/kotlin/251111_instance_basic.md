# 인스턴스 기본 조작

## Object 클래스의 기본 기능
Java에서는 `Object` 클래스가 모든 클래스들의 슈퍼 클래스이다.  
Kotlin에서는 `Any`가 이에 해당한다.

## `==`, `===` 비교 연산자
- `==`는 `equals()`와 같다.
- `===`는 실제 주소를 비교한다.

## 컬렉션 비교 `equals()`
- `List`는 `hashCode()`를 무시하고, `equals()`로 비교
- `Set`은 `hashCode()`로 비교
  - `hashCode()` 값이 다르면 다른 객체로 처리
  - `hashCode()` 값이 같으면 `equals()`로 비교

## `copy()` 얕은 복사(shallow copy)
- `copy()`에 대한 객체는 새로 만들어서 깊은 복사(deep copy)이지만, 객체 안에 참조 필드가 존재하면 해당 참조는 얕은 복사가 된다.
