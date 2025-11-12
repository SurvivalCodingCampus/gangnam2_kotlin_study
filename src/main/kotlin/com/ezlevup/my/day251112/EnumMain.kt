package com.ezlevup.my.day251112

enum class AuthState {
    AUTH,
    UN,
    UNKNOWN,
}

fun something(authState: AuthState) {
    when (authState) {
        AuthState.AUTH -> println("A")
        AuthState.UN -> println("B")
        AuthState.UNKNOWN -> println("C")
    }
}

fun main() {

}