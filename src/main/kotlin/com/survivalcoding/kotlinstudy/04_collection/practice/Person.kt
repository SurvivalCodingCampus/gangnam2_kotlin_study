package com.survivalcoding.kotlinstudy.`04_collection`.practice

/*
1번. 다음 정보를 저장하기 좋은 컬렉션을 List, Set, Map 중 고르시오. 그 이유는?

1) 대한민국의 도시 이름 모음 (순서 상관 없음)
 도시는 순서가 상관없기 때문에 순서 상관 없고 속도가 빠른 Set이 좋다

2) 10명 학생의 시험 점수
 학생의 시험 점수는 순서가 중요하지 않을 수 있지만, 학생이름 혹은 학번과 점수로 묶어서 저장하기 좋기에 Map이 좋다.

3) 대한민국의 도시별 인구수 (순서 상관 없음)
 도시별 인구수는 순서가 중요하지 않고, 묶어서 저장하기 좋아서 Map이 좋다.
*/

/*
2번. 다음을 수행하는 코드를 작성하시오.

1) 이름을 가지는 Person 클래스를 작성하시오. Person 은 반드시 이름을 포함해야 합니다.
2) 이름이 ‘홍길동', ‘한석봉' 인 Person 인스턴스를 생성하고, List에 담습니다.
3) List에 담긴 모든 Person 인스턴스의 이름을 표시하시오.
*/

/*
3번.

연습문제 2 에서 작성한 Person 클래스로 생성한 ‘홍길동’, ‘한석봉'의 나이를 각각 20, 25살 이라고 할 때, 이름과 나이를 쌍으로 적당한 컬렉션에 넣습니다.
그 다음, 컬렉션에 저장한 값을 하나씩 다음과 같이 출력합니다.
“홍길동의 나이는 20살”
“한석봉의 나이는 25살”
*/

class Person(val name: String, var age: Int? = null) {}

fun main() {
    // 2번 문제
    val person1 = Person("홍길동")
    val person2 = Person("한석봉")

    val people: List<Person> = listOf(person1, person2)

    for (person in people) {
        println(person.name)
    }

    /*
    3번 문제

    val person1 = Person("홍길동", 20)
    val person2 = Person("한석봉", 25)

    val people: Map<String, Int?> = mapOf(
        person1.name to person1.age,
        person2.name to person2.age
    )

    people.entries.forEach {
        println("${it.key}의 나이는 ${it.value}살")
    }
     */
}