package com.survivalcoding.kotlinstudy.`04_encapsulation_collections`

class Student(
    var id: Int,
    val name: String,
    age: Int = 0,
) {
    // 클래스 안에서도 접근이 안됨
    //    fun study() {
    //        age
    //    }

    // 내부적으로 수정가능한 객체는 _로 정의
    private var _age = age
    var age: Int = 0
        // get() = _age
        // 얘가 의미하는게 바이트 코드 디컴파일 했을 때 보이는 거
        set(value) {
            // 들어오는 값을 넣겠다!
            field = value * 10
        }

    fun study() {
        age = 10
    }

}

fun main() {
    val student = Student(0, "홍길동")
    student.id = 100
    // id 에 100이 들어가는 것 처럼 보이지만
    // 필드에 잇는 것을 프로퍼티라고 부르고
    // var getter와 setter 가 있는것
    // val 은 읽기 전용 수정 못하게 하는거 name은 getName 만 있고 setName 은 없음
    // getter setter 경유하고 있는게 프로퍼티
    // = 해서 할당하기 때문에
    // 코틀린은 getter setter 이미 내장 - 조절 var val
    // 커스텀할 수 있음

    // age.
    // 얘도 접근이 안돼

    student.study()
    // setter를 통한 조작
    println(student.age)
}