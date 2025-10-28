package com.ezlevup.my._01_syntax

/*
프로그램 인자 전달 방법
args 파라미터에 값을 전달하려면 Run > Edit Configurations로 이동합니다.
Program arguments 필드에 전달할 값을 공백으로 구분하여 입력합니다. 예: arg1 arg2 arg3.
 */
fun main(args: Array<String>) {
    println("Hello world!")
    println(args.contentToString())
}
