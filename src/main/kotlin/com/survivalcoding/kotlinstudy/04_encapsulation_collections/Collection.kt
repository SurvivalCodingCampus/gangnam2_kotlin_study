package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

// 연습문제 1. 컬렉션 고르기
/**
 * 1) 대한민국의 도시 이름 모음 (순서 상관 없음)
 * Set
 *
 * 순서가 중요하지 않은 단순 이름의 모음이며
 * 도시를 광역시, 특별시, 시로 한정했을 때 중복을 제거하기 위해 Set 이 적합
 * 다만 군, 구, 읍, 면, 동을 포함한다면 중복 지명을 고려하여 List
 *
 */

/**
 *  2) 10명 학생의 시험 점수
 *  List
 *
 *  학생 이름 없이 단순히 점수만 담는 것을 고려한다면
 *  점수는 중복이 가능하므로 List 가 적합
 *  학생 번호에 따라서 순서를 고려하여 점수를 List 에 담고
 *  인덱스로 접근해서 사용하는 것도 가능
 *
 */

/**
 *  3) 대한민국의 도시별 인구수 (순서 상관 없음)
 * Map
 *
 * Key-Value 형태로 각 도시와 인구수가 1:1로 연결됨
 * Key로 빠른 접근이 가능
 * key 인 도시 이름은 중복이 불가능하지만 Value인 인구수는 중복이 가능한 구조
 */

// 연습문제 2. Person class
class Person3(
    val name: String,   // 반드시 이름 포함
)

fun main() {
    // 인스턴스 생성
    val person1 = Person3(name = "홍길동")
    val person2 = Person3(name = "한석봉")

    val peoples: List<Person3> = listOf(person1, person2)    // 리스트에 담기

    // 리스트에 담긴 모든 이름 출력
    peoples.forEach { println(it.name) }

    // 연습문제 3. 이름 - 나이 쌍 컬렉션
    val nameAges: Map<String, Int> = mapOf(
        "홍길동" to 20,
        "한석봉" to 25
    )

    // Map에 저장된 값 하나씩 출력
    nameAges.entries.forEach {
        println("${it.key}의 나이는 ${it.value}살")
    }

    // 같은 코드
//    for ((name, age) in nameAges) {
//        println("${name}의 나이는 ${age}살")
//    }
}