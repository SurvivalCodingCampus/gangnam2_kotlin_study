package com.survivalcoding.kotlinstudy;

public class HeroJava {
    String name;
    int hp;

    public static void main(String[] args) {


        AuthState state = AuthState.AUTHENTICATED;

        switch (state) {
            case AuthState.AUTHENTICATED:

            case AuthState.UNAUTHENTICATED:

            case AuthState.UNKNOWN:

            default:
        }

//        if (state == AuthState.UNKNOWN) {
//
//        }
    }
}

enum AuthState2 {
    AUTHENTICATED,
    UNAUTHENTICATED,
    UNKNOWN,
}

enum AuthState {
    AUTHENTICATED,
    UNAUTHENTICATED,
    UNKNOWN,
}