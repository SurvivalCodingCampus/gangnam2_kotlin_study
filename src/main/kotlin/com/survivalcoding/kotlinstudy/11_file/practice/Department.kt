package com.survivalcoding.kotlinstudy.`11_file`.practice

/*
총무부 리더 ‘홍길동(41세)’의 인스턴스를 생성하고 직렬화하여 company.txt 파일에 저장하는 프로그램을 작성하시오.
직렬화를 위해 위의 2개 클래스를 일부 수정하시오.
*/

class Employee(
    var name: String,
    var age: Int
) {
    fun toJson() = """
        {
            "name": "$name",
            "age": $age
        }
    """.trimIndent()
}

class Department(
    var name: String,
    var leader: Employee
) {
    fun toJson() = """
        {
            "name": "$name",
            "leader": "${leader.toJson()}"
        }
    """.trimIndent()
}