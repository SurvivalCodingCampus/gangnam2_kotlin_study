package com.ezlevup.my.day02


// 톱 레벨(Top-level)에 선언된 const val
// 컴파일 시점에 이 값이 100으로 대체됩니다. (인라인(inline))
const val MAX_USER_COUNT = 100


/*
프로그램 인자 전달 방법
args 파라미터에 값을 전달하려면 Run > Edit Configurations로 이동합니다.
Program arguments 필드에 전달할 값을 공백으로 구분하여 입력합니다. 예: arg1 arg2 arg3.
 */
fun main(args: Array<String>) {
    println("Hello world!")
    println(args.contentToString())

    // val (Value): 변경 불가능한 변수 (읽기 전용, 상수)
    val size = args.size;

    // size = 3 // (컴파일 에러!) val로 선언된 변수는 재할당이 불가능합니다.
    // Error: Val cannot be reassigned

    // var (Variable): 변경 가능한 변수
    // 코틀린은 타입 추론(Type Inference)을 지원합니다.
    var itemSize = 10
    itemSize = 11

}


fun checkUser(count: Int): Boolean {
    return count <= MAX_USER_COUNT
}

