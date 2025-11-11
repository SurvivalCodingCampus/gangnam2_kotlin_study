## 연습문제 1

\ | (1)                        | (2)
---|----------------------------|----
코드 | `val item: Item = Sword()` | `val a: Monster = Slime()`
이미지 | Sword 인스턴스<br>`<<Item>>`     | Slime 인스턴스<br>`<<Monster>>`
해설문 | Sword를 생성했지만<br>컴파일러에게는 Item으로 보임 | Slime을 생성했지만<br>컴파일러에게는 Monster로 보임


## 연습문제 2

<img height="300" alt="image" src="https://github.com/user-attachments/assets/7a4cc356-b36f-4634-94cf-40819e088288" />


1. val obj: X = A() 로 A인스턴스를 생성한 후, 변수 obj에서 호출할 수 있는 메소드를 a(), b(), c() 중에 골라보시오
> a()  
> 변수 obj는 인터페이스 X로 선언되어 있는데, X에는 메서드 a()만 존재하므로 obj로는 a()만 호출할 수 있다

2. val y1: Y = A()
   val y2: Y = B() 로 A와 B의 인스턴스를 생성한 후
   y1.a()
   y2.a() 를 실행했을 때에 화면에 표시되는 내용을 말하시오.
```text
Aa
Ba
```
> 변수 y1, y2는 추상 클래스 Y로 선언되어 있다  
> 컴파일러는 해당 변수들을 Y로 인식하여 메서드 a() 또는 b()만 호출가능하지만,  
> 런타임에서는 각각 실제 구현체의 메서드 a()가 호출되므로 "Aa"와 "Ba"가 호출된다


## 연습문제 3

1. List 변수의 타입으로 무엇을 사용하여야 하는가
> List<Y>  
> 클래스 A와 클래스 B의 공통된 슈퍼 클래스인 Y를 List의 타입으로 사용하여야 한다

2. 프로그램 작성하시오
> Ex23.kt에 작성했습니다
