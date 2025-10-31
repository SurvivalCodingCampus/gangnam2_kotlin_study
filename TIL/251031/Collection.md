# 컬렉션

## 데이터 구조에 따른 대표적인 컬렉션 ( 자료구조 )

- List: 순서대로 쌓여있는 구조 ( 아이템의 중복 허용 )
- Map: 키와 값을 쌍으로 저장 ( 키의 중복 불가 )
- Set: 순서가 없는 집합 ( 중복 불가 )

## List

### 1-1) 동적 배열( array )

- 크기가 정해져 있다.
- 데이터가 순서대로 올라간다.
- 순회하기 좋다.
- 속도가 빠르다.
  하지만 수정, 추가, 삭제를 하려면 새로 복사해서 만들어야 한다.

```kotlin
fun main() {
    // Array
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4)
    numbers[0] = 10 // 원소 수정 가능
    println(numbers[0]) // 10
}

```

그래서 List가 나왔다.

### 1-2) List

- 값 삭제 및 수정이 쉽다. 앞 뒤 데이터에 대한 주소 정보를 가지고 있다.
- 순회를 해야해서 느릴 수 있다.
```kotlin
fun main() {
    // 수정 가능한 리스트
    val numbers: MutableList<Int> = mutableListOf()
    numbers.add(10)
    numbers.add(20)
    println(numbers) // [10, 20]

    // 수정 불가능한 리스트
    val numbers2: List<Int> = listOf(1, 2, 3, 4)
    println(numbers2[3]) 
}

```
## Stack

- List 처럼 주솟값을 가지고 있으나 마지막 값만 넣고 뺄 수 있다.

## 큐

스택이랑은 반대 개념. 선입 선출된다. 순서대로 해야하는 작업에 쓰인다.

## Set

- 중복 값을 허용하지 않는 집합
- 순서가 없다. 반복에서 찾기에 좋다.

## Map

- 키와 값이 쌍으로 이루어진 요소를 담는 자료구조
- 키의 중복은 허용하지 않는다.
- Map은 순서를 보장하지 않는다.
```kotlin
fun main() { 
    // Map을 자바에서는 
    // val namePair: Pair<String, String> = Pair("name", "홍길동")

  val gildong = mapOf(
        "name" to "홍길동",
        "age" to 10
    )
    println(gildong["name"]) // Map 호출 방법
}
// Map보다 데이터를 표현하는 클래스를 직접 만드는 게 더 낫다.
class Person(
  val name: String,
  val age: Int
)

```
## 컬렉션 선택시 생각해야할 것
- key, value 쌍 : Map
- 중복 가능 : List
- 중복 불가 : Set
- 순서 중요 : List
- 순서 안 중요 : Set
- 검색 속도 중요 : Set
