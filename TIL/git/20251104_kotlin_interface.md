# Kotlin

## 오늘 배운것

개념
- 접근제어자 
  - protected는 자식에게까지만 허용하겠다
- 코틀린 Property
  - 프로퍼티에 override가 있는 이유
    프로퍼티는 변수처럼 보이지만 getter setter가 있는 메소드들이 내장되어있음
    그래서 override가 가능함
- 추상클래스
  - 추상 메소드를 1개 이상 갖고 있는 클래스
- 인터페이스
  - 모든 메소드는 추상메소드이어야 한다.
  - 필드가 없다
    -> 자바에서 인터페이스 필드는 
    ```java 
    interface {
       int a = 0;
    }
    ```
    이렇게 선언이 가능한데 
    ```java
    interface {
       public static final int a = 0;
    }
    ```
    위와 같이 public static final 이 생략된 상수이다

프로퍼티 선언 관련
- lateinit var 은 왠만하면 안쓰는걸 권장

    ``` kotlin 
    lateinit var name: String 
    ```

    lateinit var을 쓰는 경우는 테스트 코드를 짤때나 사용

    by lazy() 는 사용해도 된다.
