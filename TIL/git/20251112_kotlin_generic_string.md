# Kotlin

## 오늘 배운것

동등성 리뷰
```kotlin
data class Student(val name: String)
```
위와 같은 코드에서 name이 다른 객체로 복사를 할때 
data class 에서 copy() 메소드를 사용하면서 프로퍼티가 val인 이유는 
성능은 버리고 불변으로 방향성을 간다 -> 사람의 실수를 줄이겠다

개념
- 제네릭 타입이 없을때
  - 런타임에러가 나기 쉽다
  - IDE가 컴파일에러를 미리 찾을수 없다.

- 문자열
  - String은 한번 세팅하면 변경할수 없다.
  - String은 같은 문자 주소 비교를 하면 true로 나온다. String pool에 저장
  ```kotlin
  val string1 = "hello"
  val string2 = "hello"

  println(string1 === string2) // true
  ```
  - 컴파일시점의 문자열은 string pool에,
  - 런타임시점의 문자열은 일반 heap에 
  - Accessor, Mutator의 개념 - 원본을 수정하냐의 차이
