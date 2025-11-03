package com.ezlevup.my.day05.exercise3


/*
연습문제 1
다음 정보를 저장하기 좋은 컬렉션을 List, Set, Map 중 고르시오. 그 이유는?
1. 대한민국의 도시 이름 모음 (순서 상관 없음)
2. 10명 학생의 시험 점수
3. 대한민국의 도시별 인구수 (순서 상관 없음)
 */

class Ex1 {
}

fun main() {
    // 대한민국의 도시 이름 모음 (순서 상관 없음)
    // 순서에 상관이 없다면 Set 으로 하는 것이 좋아요.
    val koreanCities: Set<String> = setOf("서울", "부산", "인천", "대구", "대전", "광주", "수원", "울산")
    val iterator = koreanCities.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    // 2. 10명 학생의 시험 점수
    // 단순히 10명의 총합, 평균, 등 을 원하면 순서에 상관 없이 점수만 저장을 하면 되기 때문에 Set
    // 학생학번:점수 가 필요하면 Map을 사용을 하면 됩니다.
    val studentScores: Set<Int> = setOf(85, 92, 78, 88, 95, 76, 89, 91, 83, 87)
    println("총 학생 수: ${studentScores.size}")
    println("평균 점수: ${studentScores.average()}")
    println("총점: ${studentScores.sum()}")

    // 3. 대한민국의 도시별 인구수 (순서 상관 없음)
    // 도시별 인구수 라서 Map을 사용하는 것이 좋을 것 같습니다.
    val cityPopulation = mapOf<String, Int>(
        "서울" to 11111,
        "부산" to 22222,
        "경기" to 33333,
    )
    cityPopulation.entries.forEach {
        println("${it.key} : ${it.value}")
    }
    cityPopulation.forEach(::println)
    cityPopulation.forEach { p -> println(p) }
    cityPopulation.forEach { println(it) }
    for (entity in cityPopulation) {
        println(entity)
    }
    for ((city, population) in cityPopulation) {
        println("$city: $population")
    }

}
