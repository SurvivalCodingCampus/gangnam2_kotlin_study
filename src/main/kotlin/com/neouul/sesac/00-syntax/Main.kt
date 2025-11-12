package com.neouul.sesac.`00-syntax`

// 컴파일타임 상수
const val PI = 3.14
// 런타임 상수
val PI2 = 3.14

fun main() {
    println("hello world")
    println(PI)

    readln()

    val x = 10  // 타입 추론
    // 다형성
    val y: Long = x.toLong()

    // 표현식
    val a = 10
    val b = 5
    val result = if(a > b) a else b

    val result2 = when(a){
        10 -> true
        else -> false
    }

    // named arguments
    sum(b = 10, a = 20)

    // Default parameter value
    sum(20)

    // Null safety
    var name: String = "홍길동"
//    name = null     // 컴파일 에러

    // nullable
    var name2: String? = "홍길동"
    name2 = null
    println(name2?.toInt())     // 안전한 호출

    // !! null이 아님을 보증 (사용 금지)
    name = name2!!      // null이라면, 에러 발생
}


//fun sum(a: Int, b: Int): Int{
//    return a + b
//}

// 표현식
//fun sum(a: Int, b: Int) = a + b

// 리턴 없음 Unit (엄밀히는 void와 다름)
fun sum(a: Int, b: Int = 10): Unit{
    println("합은 ${a + b}입니다.")
}