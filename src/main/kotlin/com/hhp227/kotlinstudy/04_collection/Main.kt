package com.hhp227.kotlinstudy.`04_collection`

/*
연습문제 1
다음 정보를 저장하기 좋은 컬렉션을 List, Set, Map 중 고르시오. 그 이유는?
대한민국의 도시 이름 모음 (순서 상관 없음) -> Set 이유: 도시 자체는 고유한 지역임 그러나 어떻게 저장하냐에 따라서 중복이 있을수 있음 예)경기도 광주시, 광주광역시를 광주로 저장할 경우는 List에 저장해야함
10명 학생의 시험 점수 -> Map 이유: 학생은 고유하므로 키로 정하고 점수는 밸류로 저장, 점수는 동점이 나올 경우가 있음
대한민국의 도시별 인구수 (순서 상관 없음) -> Map 이유: 도시 자체는 고유하므로 키로 정하고 도시의 인구는 희박하게 동점이 나올수 있으므로 밸류로 저장

연습문제 2
다음을 수행하는 코드를 작성하시오.
이름을 가지는 Person 클래스를 작성하시오. Person 은 반드시 이름을 포함해야 합니다.
이름이 ‘홍길동', ‘한석봉' 인 Person 인스턴스를 생성하고, List에 담습니다.
List에 담긴 모든 Person 인스턴스의 이름을 표시하시오.

연습문제 3
연습문제 2 에서 작성한 Person 클래스로 생성한 ‘홍길동’, ‘한석봉'의 나이를 각각 20, 25살 이라고 할 때, 이름과 나이를 쌍으로 적당한 컬렉션에 넣습니다.
그 다음, 컬렉션에 저장한 값을 하나씩 다음과 같이 출력합니다.
“홍길동의 나이는 20살”
“한석봉의 나이는 25살”
 */

fun main() {
    val people = listOf(Person("홍길동"), Person("한석봉"))

    // 연습문제 2
    for (person in people) {
        println(person.name)
    }

    // 연습문제 3
    val peopleMap = people.zip(listOf(20, 25)).toMap()

    for ((person, age) in peopleMap) {
        println("${person.name}의 나이는 ${age}살")
    }
}

data class Person(var name: String)