package com.luca.kotlinstudy._04_collection

import java.time.LocalDate

/*
캡슐화 연습문제 2
Person 클래스를 작성하시오.

1.이름과 태어난 해를 생성자로 받는다 (name, birthYear)
2.이름과 태어난 해는 한번 정해지면 수정이 불가능하다.
3.age 프로퍼티를 통해 나이를 제공하지만, 임의로 수정은 불가능하다.
4.나이 계산은 올해년도에서 birthYear 년도를 뺀 값을 리턴한다
    a.현재 시간과 날짜를 구하는 방법은 검색 해 볼 것


컬렉션 연습문제 2
다음을 수행하는 코드를 작성하시오.
1.이름을 가지는 Person 클래스를 작성하시오. Person 은 반드시 이름을 포함해야 합니다.
2.이름이 ‘홍길동', ‘한석봉' 인 Person 인스턴스를 생성하고, List에 담습니다.
3.List에 담긴 모든 Person 인스턴스의 이름을 표시하시오.

 */
class Person(
    val name: String,
    val birthYear: Int = 0,
) {
    val age: Int
        get() = if (birthYear > 0) LocalDate.now().year - birthYear else 0
}

fun main() {
    // 캡슐화 - 연습문제 2
    val p1 = Person("루카", 1996)
    println("${p1.name}의 나이는 ${p1.age + 1}세입니다.")

    // 컬렉션 - 연습문제 2
    val p2 = Person(name = "홍길동")
    val p3 = Person(name = "한석봉")
    val names: List<Person> = listOf(p2, p3)
    names.forEach { println(it.name) }

    // 컬렉션 - 연습문제 3
    val people = mapOf(
        "홍길동" to 20,
        "한석봉" to 25
    )
    val gildong = mapOf(
        "name" to "홍길동",
        "age" to 20
    )
    val seokbong = mapOf(
        "name" to "한석봉",
        "age" to 25
    )
    people.forEach {println("${it.key}의 나이는 ${it.value}살.")
    }

}
