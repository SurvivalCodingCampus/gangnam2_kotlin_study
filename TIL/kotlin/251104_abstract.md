# Kotlin

## 추상화 Abstract, 인터페이스 Interface

기본적인 내용은 Java와 동일하다.  

선언은 클래스 헤더에 생성자 뒤에 `:` 콜론을 적고 뒤에 적는다.

```kotlin
abstract class A

class B : A
```

```kotlin
interface A

class B : A
```

Java에서는 `interface`에 변수를 선언하면 `static final`로 상수이지만,  
Kotlin에서는 `abstract val or var`로 사용이 된다. 구현 클래스에서 `override val or var`로 재정의를 해서 사용한다.